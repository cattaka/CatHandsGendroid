
package net.cattaka.util.cathandsgendroid.test.model.coder;

import net.cattaka.util.cathandsgendroid.test.model.UserModel.Authority;

public class AuthorityCoder {
    public static Integer encode(Authority arg) {
        return (arg != null) ? arg.ordinal() : null;
    }

    public static Authority decode(Integer arg) {
        Authority[] values = Authority.values();
        if (arg != null && 0 <= arg && arg < values.length) {
            return values[arg];
        } else {
            return null;
        }
    }
}
