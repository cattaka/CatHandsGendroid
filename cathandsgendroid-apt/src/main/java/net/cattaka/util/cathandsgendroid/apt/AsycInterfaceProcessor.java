
package net.cattaka.util.cathandsgendroid.apt;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;

import org.mvel2.templates.TemplateRuntime;

import net.cattaka.util.cathandsgendroid.annotation.AsyncInterface;
import net.cattaka.util.cathandsgendroid.annotation.AsyncInterfaceAttrs;
import net.cattaka.util.cathandsgendroid.apt.util.ResourceUtil;

@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes("net.cattaka.util.genasyncif.*")
public class AsycInterfaceProcessor {
    public static class ArgType {
        public String typeName;

        public String innerTypeName;

        public String hiddenTypeName;

        public boolean isGenerics;

        private ArgType(String typeName, String innerTypeName) {
            super();
            this.typeName = typeName;
            this.innerTypeName = innerTypeName;
            this.hiddenTypeName = innerTypeName;
            isGenerics = false;
        }

        private ArgType(String typeName, String innerTypeName, String hiddenTypeName,
                boolean isGenerics) {
            super();
            this.typeName = typeName;
            this.innerTypeName = innerTypeName;
            this.hiddenTypeName = hiddenTypeName;
            this.isGenerics = isGenerics;
        }

        @Override
        public String toString() {
            return "ArgType [" + typeName + ", " + innerTypeName + ", " + hiddenTypeName + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            ArgType other = (ArgType)obj;
            if (typeName == null) {
                if (other.typeName != null)
                    return false;
            } else if (!typeName.equals(other.typeName))
                return false;
            return true;
        }
    }

    private static class InterfaceInfo {
        String packageName;

        String interfaceName;

        String asyncClassName;

        String fullGenerics;

        String shortGenerics;

        public InterfaceInfo(String packageName, String interfaceName, String asyncClassName,
                String fullGenerics, String shortGenerics) {
            super();
            this.packageName = packageName;
            this.interfaceName = interfaceName;
            this.asyncClassName = asyncClassName;
            this.fullGenerics = fullGenerics;
            this.shortGenerics = shortGenerics;
        }

        @Override
        public String toString() {
            return "InterfaceInfo [packageName=" + packageName + ", className=" + interfaceName
                    + ", asyncClassName=" + asyncClassName + "]";
        }

    }

    public static class MethodInfo {
        public boolean needSync;

        public String methodName;

        public String genericsDeclare;

        public String eventName;

        public List<ArgType> argTypes;

        public List<String> throwsList;

        public ArgType returnType;

        public MethodInfo(boolean needSync, String methodName, String genericsDeclare,
                String eventName, List<ArgType> argTypes, List<String> throwsList,
                ArgType returnType) {
            super();
            this.needSync = needSync;
            this.methodName = methodName;
            this.genericsDeclare = genericsDeclare;
            this.eventName = eventName;
            this.argTypes = argTypes;
            this.throwsList = throwsList;
            this.returnType = returnType;
        }

        @Override
        public String toString() {
            return "MethodInfo [methodName=" + methodName + ", argTypes=" + argTypes
                    + ", throwsList=" + throwsList + ", returnType=" + returnType + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((argTypes == null) ? 0 : argTypes.hashCode());
            result = prime * result + ((methodName == null) ? 0 : methodName.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            MethodInfo other = (MethodInfo)obj;
            if (argTypes == null) {
                if (other.argTypes != null)
                    return false;
            } else if (!argTypes.equals(other.argTypes))
                return false;
            if (methodName == null) {
                if (other.methodName != null)
                    return false;
            } else if (!methodName.equals(other.methodName))
                return false;
            return true;
        }

    }

    private ProcessingEnvironment processingEnv;

    private String mTemplate;

    public AsycInterfaceProcessor(ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;

        String templateResource = getClass().getPackage().getName().replace('.', '/')
                + "/AsyncInterfaceTemplate.java.mvel";
        try {
            mTemplate = ResourceUtil.getResourceAsString(templateResource);
        } catch (IOException e) {
            processingEnv.getMessager().printMessage(Kind.ERROR, e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void process(TypeElement element, RoundEnvironment roundEnv) {
        boolean isInterface = (element.getKind() == ElementKind.INTERFACE);
        AsyncInterface gai = element.getAnnotation(AsyncInterface.class);
        List<? extends TypeParameterElement> typeParameters = element.getTypeParameters();
        String fullGenerics = "";
        String shortGenerics = "";
        if (typeParameters.size() > 0) {
            fullGenerics = createGenericsDeclare(typeParameters, true);
            shortGenerics = createGenericsDeclare(typeParameters, false);

        }

        String packageName;
        {
            String t = String.valueOf(element.getQualifiedName());
            int n = t.lastIndexOf('.');
            packageName = (n >= 0) ? t.substring(0, n) : "";
        }
        String interfaceName = String.valueOf(element.getSimpleName());
        String asyncClassName = gai.prefix() + interfaceName + gai.suffix();
        InterfaceInfo info = new InterfaceInfo(packageName, interfaceName, asyncClassName,
                fullGenerics, shortGenerics);
        List<MethodInfo> methodInfos = pullMethodInfos(element);
        Set<String> importClasses = new TreeSet<String>();
        String methodEventLines = "";
        String suppressWarnings = "";

        boolean useAsyncInterfaceException = false;
        {
            for (MethodInfo mi : methodInfos) {
                if (mi.needSync) {
                    useAsyncInterfaceException = true;
                    break;
                }
            }
            importClasses.add(info.packageName + "." + info.interfaceName);
            if (useAsyncInterfaceException) {
                importClasses
                        .add("net.cattaka.util.cathandsgendroid.exception.AsyncInterfaceException");
            }
        }
        {
            Set<String> items = new TreeSet<String>();
            if (info.fullGenerics.length() > 0) {
                items.add("rawtypes");
            }
            outer: for (MethodInfo mi : methodInfos) {
                if (mi.genericsDeclare.length() > 0) {
                    items.add("unchecked");
                    break outer;
                }
                for (ArgType at : mi.argTypes) {
                    if (at.isGenerics) {
                        items.add("unchecked");
                        break outer;
                    }
                }
            }
            if (items.size() > 0) {
                StringBuilder sb = new StringBuilder();
                int c = 0;
                sb.append("        @SuppressWarnings({");
                for (String item : items) {
                    if (c > 0) {
                        sb.append(',');
                    }
                    sb.append('"');
                    sb.append(item);
                    sb.append('"');
                    c++;
                }
                sb.append("})");
                suppressWarnings = sb.toString();
            }
        }

        int workSize = 0;
        {
            for (int i = 0; i < methodInfos.size(); i++) {
                MethodInfo mi = methodInfos.get(i);
                workSize = Math.max(workSize, mi.argTypes.size() + 4);
            }
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isInterface", isInterface);
        map.put("interfaces", element.getInterfaces());
        map.put("annotation", gai);
        map.put("importClasses", importClasses);
        map.put("methodInfos", methodInfos);
        map.put("methodEventLines", methodEventLines);
        map.put("packageName", packageName);
        map.put("asyncClassName", asyncClassName);
        map.put("interfaceName", interfaceName);
        map.put("fullGenerics", info.fullGenerics);
        map.put("shortGenerics", info.shortGenerics);
        map.put("poolSize", String.valueOf(gai.poolSize()));
        map.put("suppressWarnings", suppressWarnings);
        map.put("workSize", String.valueOf(workSize));

        String generated = (String)TemplateRuntime.eval(mTemplate, map);
        {
            String qualifiedName = ((packageName.length() > 0) ? packageName + "." : "")
                    + asyncClassName;
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
    }

    public static List<MethodInfo> pullMethodInfos(TypeElement rootElement) {
        List<MethodInfo> methodInfos = new ArrayList<MethodInfo>();
        List<TypeElement> interfaces = pullInterfaces(rootElement);
        Set<MethodInfo> existMethodInfos = new HashSet<MethodInfo>();
        int count = 0;
        for (TypeElement element : interfaces) {
            for (ExecutableElement method : ElementFilter.methodsIn(element.getEnclosedElements())) {
                AsyncInterfaceAttrs attr = method.getAnnotation(AsyncInterfaceAttrs.class);
                if (attr != null && attr.ignore()) {
                    continue;
                }

                String methodName = method.getSimpleName().toString();
                String eventName = "EVENT_METHOD_" + count + "_" + methodName;
                String genericsDeclare = "";
                List<? extends TypeParameterElement> tps = method.getTypeParameters();
                if (tps.size() > 0) {
                    genericsDeclare = createGenericsDeclare(tps, true) + "";
                }

                List<ArgType> argTypes = new ArrayList<ArgType>();
                for (VariableElement arg : method.getParameters()) {
                    argTypes.add(createArgType(arg.asType()));
                }
                // for (TypeParameterElement arg : method.getTypeParameters()) {
                // }

                List<String> throwsList = new ArrayList<String>();
                for (TypeMirror tm : method.getThrownTypes()) {
                    throwsList.add(pickQualifiedName(tm));
                }

                ArgType returnType = createArgType(method.getReturnType());
                boolean needSync = !"void".equalsIgnoreCase(returnType.typeName)
                        || (throwsList.size() > 0);

                if (attr != null) {
                    if (attr.forceSync()) {
                        needSync = true;
                    }
                }

                MethodInfo methodInfo = new MethodInfo(needSync, methodName, genericsDeclare,
                        eventName, argTypes, throwsList, returnType);
                if (existMethodInfos.add(methodInfo)) {
                    methodInfos.add(methodInfo);
                    count++;
                }
            }
        }
        return methodInfos;
    }

    public static List<TypeElement> pullInterfaces(TypeElement root) {
        List<TypeElement> dts = new ArrayList<TypeElement>();
        List<TypeElement> tmp = new LinkedList<TypeElement>();
        tmp.add(root);
        while (tmp.size() > 0) {
            TypeElement dt = tmp.remove(0);
            dts.add(dt);
            List<? extends TypeMirror> tms = dt.getInterfaces();
            for (TypeMirror tm : tms) {
                if (tm instanceof DeclaredType) {
                    Element ele = ((DeclaredType)tm).asElement();
                    if (ele instanceof TypeElement) {
                        tmp.add((TypeElement)ele);
                    }
                }
            }
        }
        return dts;
    }

    private static ArgType createArgType(TypeParameterElement tpe) {
        List<? extends TypeMirror> tms = tpe.getBounds();
        ArgType at = null;
        for (TypeMirror tm : tms) {
            at = createArgType(tm);
            break;
        }

        String name = String.valueOf(tpe);
        if (at != null && !Object.class.getName().equals(at.typeName)) {
            return new ArgType(name, name + " extends " + at.typeName, "Object", true);
        } else {
            return new ArgType(name, name, "Object", true);
        }
    }

    private static ArgType createArgType(TypeMirror tm) {
        switch (tm.getKind()) {
            case BOOLEAN:
                return new ArgType("boolean", "Boolean");
            case BYTE:
                return new ArgType("byte", "Byte");
            case CHAR:
                return new ArgType("char", "Char");
            case SHORT:
                return new ArgType("short", "Short");
            case INT:
                return new ArgType("int", "Integer");
            case LONG:
                return new ArgType("long", "Long");
            case FLOAT:
                return new ArgType("float", "Float");
            case DOUBLE:
                return new ArgType("double", "Double");
            case VOID:
                return new ArgType("void", "Void");
            case TYPEVAR:
                String t = String.valueOf(((TypeVariable)tm).asElement());
                // String l =
                // String.valueOf(((TypeVariable)tm).getLowerBound());
                String u = String.valueOf(((TypeVariable)tm).getUpperBound());
                return new ArgType(t, t, u, true);
            case DECLARED: {
                String hiddenName = pickQualifiedName(tm);
                String name = String.valueOf(tm);
                DeclaredType dt = (DeclaredType)tm;
                List<? extends TypeMirror> tms = dt.getTypeArguments();
                if (tms.size() > 0) {
                    hiddenName += createHiddenGenericsDeclare(tms.size());
                    return new ArgType(name, name, hiddenName, true);
                } else {
                    return new ArgType(name, name, hiddenName, false);
                }
            }
            default: {
                String name = pickQualifiedName(tm);
                return new ArgType(name, name);
            }
        }
    }

    private static String createGenericsDeclare(
            List<? extends TypeParameterElement> typeParameters, boolean full) {
        StringBuilder sb = new StringBuilder();
        {
            for (TypeParameterElement tpe : typeParameters) {
                ArgType at = createArgType(tpe);
                if (sb.length() > 0) {
                    sb.append(',');
                }
                if (full) {
                    sb.append(at.innerTypeName);
                } else {
                    sb.append(at.typeName);
                }
            }
        }
        return '<' + sb.toString() + '>';
    }

    private static String createHiddenGenericsDeclare(int n) {
        StringBuilder sb = new StringBuilder();
//        sb.append('<');
//        for (int i = 0; i < n; i++) {
//            if (i > 0) {
//                sb.append(',');
//            }
//            sb.append('?');
//        }
//        sb.append('>');
        return sb.toString();
    }

    private static String pickQualifiedName(TypeMirror src) {
        if (src.getKind() == TypeKind.DECLARED) {
            return String
                    .valueOf(((TypeElement)((DeclaredType)src).asElement()).getQualifiedName());
        } else if (src.getKind() == TypeKind.ARRAY) {
            return pickQualifiedName(((ArrayType)src).getComponentType()) + "[]";
        } else if (src instanceof PrimitiveType) {
            return ((PrimitiveType)src).getKind().name().toLowerCase();
        }
        return null;
    }

    public static String getPackageName(Element element) {
        while (!(element instanceof PackageElement)) {
            element = element.getEnclosingElement();
        }
        return ((PackageElement)element).getQualifiedName().toString();
    }
}
