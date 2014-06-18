
package net.cattaka.util.gendbhandler.apt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Converter<F, T> {
    public abstract T encode(F src);

    public abstract F decode(T src);

    public static byte[] toByteArray(Serializable src) {
        if (src == null) {
            return null;
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(src);
            out.flush();
            return bos.toByteArray();
        } catch (IOException ex) {
            // ignore close exception
            return null;
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                // ignore close exception
            }
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }
    }

    public static <T> T fromByteArray(byte[] src) {
        if (src == null) {
            return null;
        }
        ByteArrayInputStream bis = new ByteArrayInputStream(src);
        ObjectInput in = null;
        try {
            in = new ObjectInputStream(bis);
            @SuppressWarnings("unchecked")
            T obj = (T)in.readObject();
            return obj;
        } catch (ClassNotFoundException ex) {
            // ignore close exception
            return null;
        } catch (IOException ex) {
            // ignore close exception
            return null;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                // ignore close exception
            }
            try {
                bis.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }
    }
}
