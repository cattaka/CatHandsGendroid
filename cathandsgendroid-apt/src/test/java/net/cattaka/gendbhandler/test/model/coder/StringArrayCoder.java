
package net.cattaka.gendbhandler.test.model.coder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringArrayCoder {
    public static byte[] encode(List<String> arg) {
        if (arg == null) {
            return null;
        }
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            DataOutputStream dout = new DataOutputStream(bout);
            dout.writeInt(arg.size());
            for (String str : arg) {
                dout.writeUTF(str);
            }
            dout.flush();
            return bout.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }

    public static List<String> decode(byte[] arg) {
        if (arg == null) {
            return null;
        }
        try {
            ByteArrayInputStream bin = new ByteArrayInputStream(arg);
            DataInputStream din = new DataInputStream(bin);
            int n = din.readInt();
            List<String> result = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                String str = din.readUTF();
                result.add(str);
            }
            return result;
        } catch (IOException e) {
            return null;
        }
    }

}
