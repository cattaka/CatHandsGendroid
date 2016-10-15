package net.cattaka.util.cathandsgendroid.apt.util;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;

public class Functions {
    public static String join(List<?> objects, String delim) {
        if (objects == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object object : objects) {
            if (i > 0) {
                sb.append(delim);
            }
            sb.append(String.valueOf(object));
            i++;
        }
        return sb.toString();
    }
    
    public static List<String> pullTypes(DeclaredType tm) {
        List<String> results = new ArrayList<String>();
        results.add(String.valueOf(tm.asElement()));
        if (tm instanceof DeclaredType) {
            for (TypeMirror t : ((DeclaredType)tm).getTypeArguments()) {
                results.addAll(pullTypes((DeclaredType)t));
            }
        }
        return results;
    }
}
