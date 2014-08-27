
package net.cattaka.util.cathandsgendroid.apt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;

import net.cattaka.util.cathandsgendroid.annotation.AsyncInterface;
import net.cattaka.util.cathandsgendroid.annotation.AsyncInterfaceAttrs;
import net.cattaka.util.cathandsgendroid.apt.util.ResourceUtil;

@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes("net.cattaka.util.genasyncif.*")
public class AsycInterfaceProcessor {
    private static class ArgType {
        String typeName;

        String innerTypeName;

        String hiddenTypeName;

        boolean isGenerics;

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

    private static class MethodInfo {
        boolean needSync;

        String methodName;

        String genericsDeclare;

        String eventName;

        List<ArgType> argTypes;

        List<String> throwsList;

        ArgType returnType;

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

    public void process(TypeElement srcElement, RoundEnvironment roundEnv) {
        AsyncInterface gai = srcElement.getAnnotation(AsyncInterface.class);
        String packageName = getPackageName(srcElement);
        List<? extends TypeParameterElement> typeParameters = srcElement.getTypeParameters();
        String fullGenerics = "";
        String shortGenerics = "";
        if (typeParameters.size() > 0) {
            fullGenerics = createGenericsDeclare(typeParameters, true);
            shortGenerics = createGenericsDeclare(typeParameters, false);

        }
        String interfaceName = String.valueOf(srcElement.getSimpleName());
        String asyncClassName = gai.prefix() + srcElement.getSimpleName() + gai.suffix();
        String qualifiedName = packageName + ".async." + asyncClassName;

        InterfaceInfo interfaceInfo = new InterfaceInfo(packageName, interfaceName, asyncClassName,
                fullGenerics, shortGenerics);

        Filer filer = processingEnv.getFiler();
        PrintWriter writer = null;
        try {
            JavaFileObject fileObject = filer.createSourceFile(qualifiedName, srcElement);
            writer = new PrintWriter(fileObject.openWriter());
            generateCode(gai, srcElement, writer, interfaceInfo);
        } catch (IOException e) {
            processingEnv.getMessager().printMessage(Kind.ERROR, e.getMessage(), srcElement);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    private void generateCode(AsyncInterface gai, TypeElement srcElement, PrintWriter writer,
            InterfaceInfo info) throws IOException {
        List<MethodInfo> methodInfos = pullMethodInfos(srcElement);
        String packageName = info.packageName + ".async";
        String importLines = "import " + info.packageName + "." + info.interfaceName + ";";
        String asyncClassName = info.asyncClassName;
        String interfaceName = info.interfaceName;
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
            if (useAsyncInterfaceException) {
                importLines += "\nimport net.cattaka.util.cathandsgendroid.exception.AsyncInterfaceException;";
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

        for (int i = 0; i < methodInfos.size(); i++) {
            MethodInfo mi = methodInfos.get(i);
            methodEventLines += "    private static final int " + mi.eventName
                    + " = EVENT_START + " + i + ";\n";
        }
        String methodLines;
        int workSize = 0;
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < methodInfos.size(); i++) {
                MethodInfo mi = methodInfos.get(i);
                workSize = Math.max(workSize, mi.argTypes.size() + 4);
                sb.append("    @Override\n");
                sb.append("    public " + mi.genericsDeclare + mi.returnType.typeName + " "
                        + mi.methodName + "(");
                for (int j = 0; j < mi.argTypes.size(); j++) {
                    ArgType arg = mi.argTypes.get(j);
                    if (j > 0) {
                        sb.append(", ");
                    }
                    sb.append(arg.typeName + " arg" + j);
                }
                sb.append(")");
                if (mi.throwsList.size() > 0) {
                    sb.append(" throws ");
                    for (int j = 0; j < mi.throwsList.size(); j++) {
                        if (j > 0) {
                            sb.append(", ");
                        }
                        sb.append(mi.throwsList.get(0));
                    }

                }
                sb.append(" {\n");
                sb.append("        Object[] work = obtain();\n");
                sb.append("        work[0] = this;\n");
                sb.append("        work[1] = orig;\n");
                for (int j = 0; j < mi.argTypes.size(); j++) {
                    // ArgType arg = mi.argTypes.get(j);
                    sb.append("        work[" + (j + 2) + "] = arg" + j + ";\n");
                }
                if (!mi.needSync) {
                    sb.append("        mHandler.obtainMessage(" + mi.eventName
                            + ", work).sendToTarget();\n");
                } else {
                    sb.append("        synchronized (work) {\n");
                    sb.append("            mHandler.obtainMessage(" + mi.eventName + ", work)\n");
                    sb.append("                    .sendToTarget();\n");
                    sb.append("            try {\n");
                    sb.append("                work.wait();\n");
                    sb.append("            } catch (InterruptedException e) {\n");
                    sb.append("                throw new AsyncInterfaceException(e);\n");
                    sb.append("            }\n");
                    sb.append("        }\n");
                    sb.append("        if (work[WORK_SIZE - 1] != null) {\n");
                    if (mi.throwsList.size() == 0) {
                        sb.append("            throw new AsyncInterfaceException((Exception) work[WORK_SIZE - 1]);\n");
                    } else {
                        for (int j = 0; j < mi.throwsList.size(); j++) {
                            String t = mi.throwsList.get(j);
                            sb.append("            ");
                            if (j > 0) {
                                sb.append("} else ");
                            }
                            sb.append("if (work[WORK_SIZE - 1] instanceof " + t + ") {\n");
                            sb.append("                throw (" + t + ") work[WORK_SIZE - 1];\n");
                        }
                        sb.append("            } else {\n");
                        sb.append("                throw new AsyncInterfaceException((Exception) work[WORK_SIZE - 1]);\n");
                        sb.append("            }\n");
                    }
                    sb.append("        }\n");
                    if (!"void".equalsIgnoreCase(mi.returnType.typeName)) {
                        if (mi.returnType.isGenerics) {
                            sb.append("        @SuppressWarnings(\"unchecked\")\n");
                        }
                        sb.append("        " + mi.returnType.typeName + " result = ("
                                + mi.returnType.innerTypeName + ") work[WORK_SIZE - 2];\n");
                    }
                    sb.append("        recycle(work);\n");
                    if (!"void".equalsIgnoreCase(mi.returnType.typeName)) {
                        sb.append("        return result;\n");
                    }
                }
                sb.append("    }\n");
            }
            methodLines = sb.toString();
        }
        String caseLines;
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < methodInfos.size(); i++) {
                MethodInfo mi = methodInfos.get(i);
                sb.append("            case " + mi.eventName + ": {\n");
                sb.append("                Object[] work = (Object[]) msg.obj;\n");
                if (!mi.needSync) {
                    sb.append("                ${asyncClassName} me = (${asyncClassName}) work[0];\n");
                }
                sb.append("                ${interfaceName} orig = (${interfaceName}) work[1];\n");
                for (int j = 0; j < mi.argTypes.size(); j++) {
                    ArgType arg = mi.argTypes.get(j);
                    sb.append("                " + arg.hiddenTypeName + " arg" + j + " = ("
                            + arg.hiddenTypeName + ") (work[" + (j + 2) + "]);\n");
                }

                if (!mi.needSync) {
                    sb.append("                orig." + mi.methodName + "(");
                    for (int j = 0; j < mi.argTypes.size(); j++) {
                        if (j > 0) {
                            sb.append(" ,");
                        }
                        sb.append("arg" + j);
                    }
                    sb.append(");\n");
                    sb.append("                me.recycle(work);\n");
                    sb.append("                return true;\n");
                } else {
                    sb.append("                try {\n");
                    sb.append("                    ");
                    if (!"void".equalsIgnoreCase(mi.returnType.typeName)) {
                        sb.append("Object result = ");
                    }
                    sb.append("orig." + mi.methodName + "(");
                    for (int j = 0; j < mi.argTypes.size(); j++) {
                        if (j > 0) {
                            sb.append(" ,");
                        }
                        sb.append("arg" + j);
                    }
                    sb.append(");\n");
                    if (!"void".equalsIgnoreCase(mi.returnType.typeName)) {
                        sb.append("                    work[WORK_SIZE - 2] = result;\n");
                    }
                    sb.append("                } catch (Exception e) {\n");
                    sb.append("                    work[WORK_SIZE - 1] = e;\n");
                    sb.append("                }\n");
                    sb.append("                synchronized (work) {\n");
                    sb.append("                    work.notify();\n");
                    sb.append("                }\n");
                    sb.append("                return true;\n");
                }
                sb.append("            }\n");
            }
            caseLines = sb.toString();
        }

        StringBuilder sb = new StringBuilder(mTemplate);
        replaceStringBuilder(sb, "${importLines}", importLines);
        replaceStringBuilder(sb, "${caseLines}", caseLines);
        replaceStringBuilder(sb, "${methodEventLines}", methodEventLines);
        replaceStringBuilder(sb, "${methodLines}", methodLines);
        replaceStringBuilder(sb, "${packageName}", packageName);
        replaceStringBuilder(sb, "${asyncClassName}", asyncClassName);
        replaceStringBuilder(sb, "${interfaceName}", interfaceName);
        replaceStringBuilder(sb, "${fullGenerics}", info.fullGenerics);
        replaceStringBuilder(sb, "${shortGenerics}", info.shortGenerics);
        replaceStringBuilder(sb, "${poolSize}", String.valueOf(gai.poolSize()));
        replaceStringBuilder(sb, "${suppressWarnings}", suppressWarnings);
        replaceStringBuilder(sb, "${workSize}", String.valueOf(workSize));

        writer.print(sb.toString());
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
        sb.append('<');
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append('?');
        }
        sb.append('>');
        return sb.toString();
    }

    private static String pickQualifiedName(TypeMirror src) {
        if (src instanceof PrimitiveType) {
            return ((PrimitiveType)src).getKind().name().toLowerCase();
        } else if (src instanceof ArrayType) {
            return pickQualifiedName(((ArrayType)src).getComponentType()) + "[]";
        } else if (src instanceof DeclaredType) {
            Element element = ((DeclaredType)src).asElement();
            return getPackageName(element) + "." + String.valueOf(element.getSimpleName());
        }
        return null;
    }

    public static String getPackageName(Element element) {
        while (!(element instanceof PackageElement)) {
            element = element.getEnclosingElement();
        }
        return ((PackageElement)element).getQualifiedName().toString();
    }

    private static void replaceStringBuilder(StringBuilder sb, String target, String replacement) {
        int start = 0;
        while (true) {
            start = sb.indexOf(target, start);
            if (start >= 0) {
                sb.replace(start, start + target.length(), replacement);
            } else {
                break;
            }
        }
    }
}
