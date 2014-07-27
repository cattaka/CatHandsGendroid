
package net.cattaka.util.cathandsgendroid.apt;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;

import net.cattaka.util.cathandsgendroid.accessor.EnumNameAccessor;
import net.cattaka.util.cathandsgendroid.accessor.IAccessor;
import net.cattaka.util.cathandsgendroid.accessor.ParcelableAccessor;
import net.cattaka.util.cathandsgendroid.accessor.SerializableAccessor;
import net.cattaka.util.cathandsgendroid.annotation.DataModel;
import net.cattaka.util.cathandsgendroid.annotation.DataModel.NamingConventions;
import net.cattaka.util.cathandsgendroid.annotation.DataModelAttrs;

import org.mvel2.templates.TemplateRuntime;

public class DataModelProcessor {
    private ProcessingEnvironment processingEnv;

    public static class FieldEntry {
        public String origName;

        public String setter;

        public String getter;

        public String dbDataType;

        public String javaDataType;

        public String origJavaDataType;

        public boolean primitiveType;

        public String columnName;

        public String compositeName;

        public String accessor;

        public boolean forContentResolver = true;

        public boolean forDb = true;

        public boolean forParcel = true;

        public boolean ignore = false;

        public boolean primaryKey = false;

        public long version = 1;

        public String getColumnNameCapped() {
            return convertCap(origName, true);
        }
    }

    public static class OrderByEntry {
        public FieldEntry fieldEntry;

        public boolean desc;

        public OrderByEntry(FieldEntry fieldEntry, boolean desc) {
            super();
            this.fieldEntry = fieldEntry;
            this.desc = desc;
        }

    }

    public static class FindEntry {
        public List<FieldEntry> columns;

        public List<OrderByEntry> orderBy;

        public boolean unique;
    }

    public static class FindEntriesPerVersion implements Comparable<FindEntriesPerVersion> {
        public long version;

        public List<FieldEntry> fieldEntries;

        @Override
        public int compareTo(FindEntriesPerVersion o) {
            return (int)(this.version - o.version);
        }
    }

    public static class UniqueEntry {
        public List<FieldEntry> columns;
    }

    public DataModelProcessor(ProcessingEnvironment processingEnv) {
        super();
        this.processingEnv = processingEnv;
    }

    public boolean process(TypeElement element, RoundEnvironment roundEnv) {
        DataModel annotation = element.getAnnotation(DataModel.class);

        FieldEntry primaryKey = null;
        Map<String, FieldEntry> columnName2FieldEntry = new HashMap<String, DataModelProcessor.FieldEntry>();
        List<FieldEntry> fieldEntries = new ArrayList<DataModelProcessor.FieldEntry>();
        Set<String> importClasses = new TreeSet<String>();
        for (Element ee : ElementFilter.fieldsIn(Bug300408
                .getEnclosedElementsDeclarationOrder(element))) {
            VariableElement ve = (VariableElement)ee;
            FieldEntry fe = pullFieldEntry(annotation, ve, importClasses);
            if (fe != null) {
                fieldEntries.add(fe);
                columnName2FieldEntry.put(fe.columnName, fe);
                if (fe.primaryKey) {
                    primaryKey = fe;
                }
            }
        }

        List<FindEntriesPerVersion> findEntriesPerVersions = new ArrayList<DataModelProcessor.FindEntriesPerVersion>();
        {
            Map<Long, FindEntriesPerVersion> map = new HashMap<Long, DataModelProcessor.FindEntriesPerVersion>();
            for (FieldEntry fieldEntry : fieldEntries) {
                FindEntriesPerVersion t = map.get(fieldEntry.version);
                if (t == null) {
                    t = new FindEntriesPerVersion();
                    t.version = fieldEntry.version;
                    t.fieldEntries = new ArrayList<DataModelProcessor.FieldEntry>();
                    map.put(t.version, t);
                }
                t.fieldEntries.add(fieldEntry);
            }
            findEntriesPerVersions.addAll(map.values());
            Collections.sort(findEntriesPerVersions);
        }

        List<UniqueEntry> uniqueEntries = new ArrayList<DataModelProcessor.UniqueEntry>();
        if (primaryKey != null) {
            UniqueEntry entry = new UniqueEntry();
            entry.columns = new ArrayList<DataModelProcessor.FieldEntry>();
            entry.columns.add(primaryKey);
            uniqueEntries.add(entry);
        }
        for (String unique : annotation.unique()) {
            UniqueEntry entry = new UniqueEntry();
            entry.columns = createFieldList(processingEnv, element, unique, columnName2FieldEntry);
            uniqueEntries.add(entry);
        }

        List<FindEntry> findEntries = new ArrayList<DataModelProcessor.FindEntry>();
        for (String find : annotation.find()) {
            String[] tmp = find.split(":");
            FindEntry entry = new FindEntry();
            entry.columns = createFieldList(processingEnv, element, tmp[0], columnName2FieldEntry);
            entry.orderBy = (tmp.length > 1) ? createOrderByList(processingEnv, element, tmp[1],
                    columnName2FieldEntry) : new ArrayList<OrderByEntry>();
            entry.unique = false;
            for (UniqueEntry uniqueEntry : uniqueEntries) {
                if (entry.columns.containsAll(uniqueEntry.columns)) {
                    entry.unique = true;
                    break;
                }
            }
            findEntries.add(entry);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        String packageName;
        {
            String t = String.valueOf(element.getQualifiedName());
            int n = t.lastIndexOf('.');
            packageName = (n >= 0) ? t.substring(0, n) : "";
        }
        String className = String.valueOf(element.getSimpleName());
        String genClassName = className + "CatHands";
        map.put("annotation", annotation);
        map.put("packageName", packageName);
        map.put("className", className);
        map.put("genClassName", genClassName);
        map.put("fieldEntries", fieldEntries);
        map.put("findEntries", findEntries);
        map.put("uniqueEntries", uniqueEntries);
        map.put("findEntriesPerVersions", findEntriesPerVersions);
        map.put("importClasses", importClasses);
        if (primaryKey != null) {
            map.put("primaryKey", primaryKey);
        }
        if (annotation.genDbFunc()) {
            String tableName = convertName(annotation.tableNamingConventions(), className);
            map.put("tableName", tableName);
        }

        String templateResource = getClass().getPackage().getName().replace('.', '/')
                + "/DataModelTemplate.java.mvel";
        String template;
        try {
            template = getResourceAsString(templateResource);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load:" + templateResource, e);
        }
        String generated = (String)TemplateRuntime.eval(template, map);

        System.out.println(generated);
        {
            String qualifiedName = ((packageName.length() > 0) ? packageName + "." : "")
                    + genClassName;
            Filer filer = processingEnv.getFiler();
            Writer writer = null;
            try {
                JavaFileObject fileObject = filer.createSourceFile(qualifiedName, element);
                writer = fileObject.openWriter();
                writer.write(generated);
            } catch (IOException e) {
                Messager messager = processingEnv.getMessager();
                messager.printMessage(Kind.ERROR, e.getMessage(), element);
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e2) {
                        Messager messager = processingEnv.getMessager();
                        messager.printMessage(Kind.ERROR, e2.getMessage(), element);
                    }
                }
            }
        }

        return false;
    }

    private static List<FieldEntry> createFieldList(ProcessingEnvironment env, Element element,
            String src, Map<String, FieldEntry> columnName2FieldEntry) {
        List<FieldEntry> fieldEntries = new ArrayList<FieldEntry>();
        if (src != null && src.length() > 0) {
            String[] names = src.split(",");
            for (String name : names) {
                name = name.trim();
                FieldEntry fe = columnName2FieldEntry.get(name);
                if (fe != null) {
                    fieldEntries.add(fe);
                } else {
                    Messager messager = env.getMessager();
                    messager.printMessage(Kind.ERROR, "Field '" + name
                            + "' in fields is not found.", element);
                }
            }
        }
        return fieldEntries;
    }

    private static List<OrderByEntry> createOrderByList(ProcessingEnvironment env, Element element,
            String src, Map<String, FieldEntry> columnName2FieldEntry) {
        String[] names = src.split(",");
        List<OrderByEntry> orderByEntries = new ArrayList<OrderByEntry>();
        for (String name : names) {
            name = name.trim();
            boolean desc = false;
            {
                char ch = name.charAt(name.length() - 1);
                if (ch == '+' || ch == '-') {
                    name = name.substring(0, name.length() - 1);
                    desc = (ch == '-');
                }
            }
            FieldEntry fe = columnName2FieldEntry.get(name);
            if (fe != null) {
                orderByEntries.add(new OrderByEntry(fe, desc));
            } else {
                Messager messager = env.getMessager();
                messager.printMessage(Kind.ERROR, "Field '" + name + "' in fields is not found.",
                        element);
            }
        }
        return orderByEntries;
    }

    public static FieldEntry pullFieldEntry(DataModel annotation, VariableElement ve,
            Set<String> destImportClasses) {
        DataModelAttrs attr = ve.getAnnotation(DataModelAttrs.class);
        if (attr != null && attr.ignore()) {
            return null;
        }

        InnerFieldType ift = printElement(ve.asType(), attr);

        System.out.print("\t" + ve.getSimpleName());
        if (ift != null) {
            System.out.print("\t" + ift.accessor);
        }
        System.out.println();

        if (ift != null) {
            FieldEntry fe = new FieldEntry();
            fe.origName = String.valueOf(ve.getSimpleName());
            fe.javaDataType = ift.javaDataType;
            fe.origJavaDataType = ift.origJavaDataType;
            fe.dbDataType = ift.dbDataType;
            fe.setter = "set" + convertCap(fe.origName, true);
            fe.getter = "get" + convertCap(fe.origName, true);
            fe.columnName = convertName(annotation.fieldNamingConventions(),
                    String.valueOf(fe.origName));
            fe.compositeName = convertName(NamingConventions.UPPER_COMPOSITE,
                    String.valueOf(fe.origName));
            fe.accessor = ift.accessor;
            fe.primitiveType = ift.primitiveType;
            if (attr != null) {
                fe.forContentResolver = attr.forContentResolver();
                fe.forDb = attr.forDb();
                fe.forParcel = attr.forParcel();
                fe.ignore = attr.ignore();
                fe.primaryKey = attr.primaryKey();
                fe.version = attr.version();
            }
            return fe;
        } else {
            return null;
        }
    }

    public static InnerFieldType printElement(TypeMirror tm, DataModelAttrs attr) {
        InnerFieldType result = null;
        System.out.print(" : " + tm.getKind());
        if (attr != null && !IAccessor.class.getName().equals(pickAccessor(attr))) {
            result = InnerFieldType.createCustomType(String.valueOf(tm), pickAccessor(attr),
                    attr.dbDataType());
        } else if (tm.getKind() == TypeKind.DECLARED) {
            TypeElement te2 = (TypeElement)((DeclaredType)tm).asElement();
            System.out.print(" : " + te2.getQualifiedName());
            if (te2.getQualifiedName().contentEquals(Boolean.class.getCanonicalName())) {
                result = InnerFieldType.BOOLEAN;
            } else if (te2.getQualifiedName().contentEquals(Byte.class.getCanonicalName())) {
                result = InnerFieldType.BYTE;
            } else if (te2.getQualifiedName().contentEquals(Character.class.getCanonicalName())) {
                result = InnerFieldType.CHARACTER;
            } else if (te2.getQualifiedName().contentEquals(Date.class.getCanonicalName())) {
                result = InnerFieldType.DATE;
            } else if (te2.getQualifiedName().contentEquals(Double.class.getCanonicalName())) {
                result = InnerFieldType.DOUBLE;
            } else if (te2.getQualifiedName().contentEquals(Float.class.getCanonicalName())) {
                result = InnerFieldType.FLOAT;
            } else if (te2.getQualifiedName().contentEquals(Integer.class.getCanonicalName())) {
                result = InnerFieldType.INTEGER;
            } else if (te2.getQualifiedName().contentEquals(Long.class.getCanonicalName())) {
                result = InnerFieldType.LONG;
            } else if (te2.getQualifiedName().contentEquals(Short.class.getCanonicalName())) {
                result = InnerFieldType.SHORT;
            } else if (te2.getQualifiedName().contentEquals(String.class.getCanonicalName())) {
                result = InnerFieldType.STRING;
            } else if (hasSuperclass((DeclaredType)tm, "java.util.List")) {
                List<? extends TypeMirror> tas = ((DeclaredType)tm).getTypeArguments();
                if (tas.size() > 0) {
                    InnerFieldType ift = printElement(tas.get(0), null);
                    result = InnerFieldType.createListType(ift);
                }
            } else if (hasSuperclass((DeclaredType)tm, "java.lang.Enum")) {
                result = InnerFieldType.createCustomType(String.valueOf(te2.getQualifiedName()),
                        EnumNameAccessor.class.getName(), "TEXT");
            } else if (hasInterface((DeclaredType)tm, "java.io.Serializable")) {
                result = InnerFieldType.createCustomType(String.valueOf(te2.getQualifiedName()),
                        SerializableAccessor.class.getName(), "TEXT");
            } else if (hasInterface((DeclaredType)tm, "android.os.Parcelable")) {
                result = InnerFieldType.createCustomType(String.valueOf(te2.getQualifiedName()),
                        ParcelableAccessor.class.getName(), "TEXT");
            }
        } else if (tm.getKind() == TypeKind.ARRAY) {
            TypeMirror tm2 = ((ArrayType)tm).getComponentType();
            if (tm2.getKind() == TypeKind.BYTE) {
                result = InnerFieldType.BLOB;
            } else {
                InnerFieldType ift = printElement(tm2, null);
                result = InnerFieldType.createArrayType(ift);
            }
        } else if (tm.getKind() == TypeKind.BOOLEAN) {
            result = InnerFieldType.P_BOOLEAN;
        } else if (tm.getKind() == TypeKind.BYTE) {
            result = InnerFieldType.P_BYTE;
        } else if (tm.getKind() == TypeKind.CHAR) {
            result = InnerFieldType.P_CHARACTER;
        } else if (tm.getKind() == TypeKind.DOUBLE) {
            result = InnerFieldType.P_DOUBLE;
        } else if (tm.getKind() == TypeKind.FLOAT) {
            result = InnerFieldType.P_FLOAT;
        } else if (tm.getKind() == TypeKind.INT) {
            result = InnerFieldType.P_INTEGER;
        } else if (tm.getKind() == TypeKind.LONG) {
            result = InnerFieldType.P_LONG;
        } else if (tm.getKind() == TypeKind.SHORT) {
            result = InnerFieldType.P_SHORT;
        }

        return result;
    }

    public static boolean hasSuperclass(DeclaredType tm, String qualifiedName) {
        TypeMirror t = tm;
        TypeElement te;
        do {
            if (t.getKind() != TypeKind.DECLARED) {
                return false;
            }
            te = (TypeElement)((DeclaredType)t).asElement();
            if (te.getQualifiedName().contentEquals(qualifiedName)) {
                return true;
            }
        } while ((t = te.getSuperclass()) != null);
        return false;
    }

    public static boolean hasInterface(DeclaredType tm, String qualifiedName) {
        if (tm.getKind() != TypeKind.DECLARED) {
            return false;
        }
        TypeElement element = (TypeElement)tm.asElement();
        for (TypeMirror itm : element.getInterfaces()) {
            if (itm.getKind() != TypeKind.DECLARED) {
                continue;
            }
            TypeElement te = (TypeElement)((DeclaredType)itm).asElement();
            if (te.getQualifiedName().contentEquals(qualifiedName)) {
                return true;
            }
        }
        return false;
    }

    private static String pickAccessor(DataModelAttrs attrs) {
        try {
            return attrs.accessor().toString();
        } catch (MirroredTypeException expected) {
            TypeMirror type = expected.getTypeMirror();
            if (type.getKind() == TypeKind.DECLARED) {
                TypeElement te = (TypeElement)((DeclaredType)type).asElement();
                return String.valueOf(te.getQualifiedName());
            } else {
                return String.valueOf(type);
            }
        }
    }

    private static String convertName(NamingConventions namingConventions, String src) {
        if (src == null) {
            return null;
        }
        switch (namingConventions) {
            case LOWER_CAMEL_CASE:
                return convertCap(src, false);
            case UPPER_CAMEL_CASE:
                return convertCap(src, true);
            case LOWER_COMPOSITE:
                return camelToComposite(src, false);
            case UPPER_COMPOSITE:
                return camelToComposite(src, true);
        }
        return src;
    }

    private static String camelToComposite(String camel, boolean upperCase) {
        if (camel == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < camel.length(); i++) {
            char ch = camel.charAt(i);
            if (i > 0 && Character.isUpperCase(ch)) {
                sb.append('_');
                sb.append(ch);
            } else {
                sb.append(Character.toUpperCase(ch));
            }
        }
        if (upperCase) {
            return sb.toString().toUpperCase();
        } else {
            return sb.toString().toLowerCase();
        }
    }

    private static String convertCap(String name, boolean upperCase) {
        if (name == null) {
            return null;
        }
        if (name.length() == 0) {
            return name;
        }
        if (upperCase) {
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        } else {
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
    }

    private static String getResourceAsString(String resourceName) throws IOException {
        InputStream in = null;
        try {
            in = DataModelProcessor.class.getClassLoader().getResourceAsStream(resourceName);
            Reader reader = new InputStreamReader(in, "UTF-8");
            StringBuilder sb = new StringBuilder();
            char[] cbuf = new char[1 << 12];
            int r;
            while ((r = reader.read(cbuf)) > 0) {
                sb.append(cbuf, 0, r);
            }

            return sb.toString();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e2) {
                    // ignore
                }
            }
        }
    }
}
