
package net.cattaka.util.cathandsgendroid.apt;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

/**
 * The hack for buggy SourceTypeBinding of eclipse.
 * 
 * @see <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=300408">Bug
 *      300408 - TypeElement.getEnclosedElements does not respect source
 *      order</a>
 */
class Bug300408 {
    /**
     * If given TypeElement is SourceTypeBinding, the order of results are corrected.
     * 
     * @param type target
     * @return the enclosed elements, or an empty list if none
     */
    public static List<? extends Element> getEnclosedElementsDeclarationOrder(TypeElement type) {
        List<? extends Element> result = null;
        try {
            Object binding = field(type, "_binding");

            Class<?> sourceTypeBinding = null;
            {
                Class<?> c = binding.getClass();
                do {
                    if (c.getCanonicalName().equals(
                            "org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding")) {
                        sourceTypeBinding = c;
                        break;
                    }
                } while ((c = c.getSuperclass()) != null);
            }

            final List<Object> declarationOrder;
            if (sourceTypeBinding != null) {
                declarationOrder = findSourceOrder(binding);

                List<Element> enclosedElements = new ArrayList<Element>(type.getEnclosedElements());
                Collections.sort(enclosedElements, new Comparator<Element>() {

                    public int compare(Element o1, Element o2) {
                        try {
                            Object o1Binding = field(o1, "_binding");
                            Object o2Binding = field(o2, "_binding");

                            int i1 = declarationOrder.indexOf(o1Binding);
                            int i2 = declarationOrder.indexOf(o2Binding);

                            return i1 - i2;
                        } catch (Exception e) {
                            return 0;
                        }
                    }

                });
                result = enclosedElements;
            }
        } catch (Exception e) {
            // ignore
        }
        return (result != null) ? result : type.getEnclosedElements();
    }

    private static List<Object> findSourceOrder(Object binding) throws Exception {
        Object referenceContext = field(field(binding, "scope"), "referenceContext");

        TreeMap<Integer, Object> orderedBindings = new TreeMap<Integer, Object>();

        collectSourceOrder(orderedBindings, referenceContext, "methods");
        collectSourceOrder(orderedBindings, referenceContext, "fields");
        collectSourceOrder(orderedBindings, referenceContext, "memberTypes");

        return new ArrayList<Object>(orderedBindings.values());
    }

    private static void collectSourceOrder(TreeMap<Integer, Object> orderedBindings,
            Object referenceContext, String fieldName) throws Exception {
        Object[] declarations = (Object[])field(referenceContext, fieldName);
        if (declarations != null) {
            for (int i = 0; i < declarations.length; i++) {
                Integer declarationSourceStart = (Integer)field(declarations[i],
                        "declarationSourceStart");
                orderedBindings.put(declarationSourceStart, field(declarations[i], "binding"));
            }
        }
    }

    private static Object field(Object o, String fieldName) throws Exception {
        if (o == null) {
            return null;
        }
        Field field = o.getClass().getField(fieldName);
        field.setAccessible(true);
        return field.get(o);
    }
}
