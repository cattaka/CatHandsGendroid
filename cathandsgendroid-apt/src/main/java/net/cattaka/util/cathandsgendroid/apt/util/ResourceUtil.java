package net.cattaka.util.cathandsgendroid.apt.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ResourceUtil {
    public static String getResourceAsString(String resourceName) throws IOException {
        InputStream in = null;
        try {
            in = ResourceUtil.class.getClassLoader().getResourceAsStream(resourceName);
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
