
package net.cattaka.cathandsgendroid.apt;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;

import net.cattaka.util.gendbhandler.GenDbHandler;
import net.cattaka.util.gendbhandler.GenDbHandler.NamingConventions;

@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes("net.cattaka.util.gendbhandler.*")
public class CatHandsGendroidProcessor extends AbstractProcessor {
    public static class FieldEntry {
        InnerFieldType innerFieldType;

        Name origName;

        String columnname;
    }

    @Override
    public synchronized void init(ProcessingEnvironment env) {
        super.init(env);
    }

    @Override
    public boolean process(Set<? extends TypeElement> elements, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(GenDbHandler.class)) {
            GenDbHandler annotation = element.getAnnotation(GenDbHandler.class);

            System.out.println(element);
            TypeElement te = (TypeElement)element;
            for (Element ee : ElementFilter.fieldsIn(te.getEnclosedElements())) {
                VariableElement ve = (VariableElement)ee;
                pullFieldEntry(annotation, ve);
            }
        }
        return false;
    }

    public static FieldEntry pullFieldEntry(GenDbHandler annotation, VariableElement ve) {
        System.out.print(" - " + ve.getSimpleName());
        printElement(ve.asType());
        System.out.println();

        FieldEntry fe = new FieldEntry();
        fe.origName = ve.getSimpleName();
        fe.columnname = convertName(annotation.fieldNamingConventions(),
                String.valueOf(fe.origName));

        return fe;
    }

    public static InnerFieldType printElement(TypeMirror tm) {
        InnerFieldType result = null;
        System.out.print(" : " + tm.getKind());
        if (tm.getKind() == TypeKind.DECLARED) {
            TypeElement te2 = (TypeElement)((DeclaredType)tm).asElement();
            System.out.print(" : " + te2.getQualifiedName());

            if (te2.getQualifiedName().contentEquals(Byte.class.getCanonicalName())) {
                result = InnerFieldType.BYTE;
            } else if (te2.getQualifiedName().contentEquals(Character.class.getCanonicalName())) {
                result = InnerFieldType.CHAR;
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
                    InnerFieldType ift = printElement(tas.get(0));
                    // TODO create InnerFieldType of List
                }
            } else if (hasInterface((DeclaredType)tm, "java.lang.Enum")) {
                result = InnerFieldType.ENUM_NAME;
            } else if (false) {
                // TODO if it has CatHandsGendroidAnnotation
            } else if (hasInterface((DeclaredType)tm, "java.io.Serializable")) {
                result = InnerFieldType.SERIALIZABLE;
            } else if (hasInterface((DeclaredType)tm, "android.os.Parcelable")) {
                result = InnerFieldType.PARCELABLE;
            }
        } else if (tm.getKind() == TypeKind.ARRAY) {
            TypeMirror tm2 = ((ArrayType)tm).getComponentType();
            InnerFieldType ift = printElement(tm2);
            // TODO create InnerFieldType of Array
        } else if (tm.getKind() == TypeKind.BOOLEAN) {
            result = InnerFieldType.P_BOOLEAN;
        } else if (tm.getKind() == TypeKind.BYTE) {
            result = InnerFieldType.P_BYTE;
        } else if (tm.getKind() == TypeKind.CHAR) {
            result = InnerFieldType.P_CHAR;
        } else if (tm.getKind() == TypeKind.DECLARED) {
            result = InnerFieldType.P_DOUBLE;
        } else if (tm.getKind() == TypeKind.FLOAT) {
            result = InnerFieldType.P_FLOAT;
        } else if (tm.getKind() == TypeKind.INT) {
            result = InnerFieldType.P_INT;
        } else if (tm.getKind() == TypeKind.LONG) {
            result = InnerFieldType.P_LONG;
        } else if (tm.getKind() == TypeKind.SHORT) {
            result = InnerFieldType.P_SHORT;
        }

        return result;
        // BLOB : InnerFieldType
        // ENUM_NAME : InnerFieldType
        // ENUM_ORDER : InnerFieldType
        // PARCELABLE : InnerFieldType
        // SERIALIZABLE : InnerFieldType

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
}
