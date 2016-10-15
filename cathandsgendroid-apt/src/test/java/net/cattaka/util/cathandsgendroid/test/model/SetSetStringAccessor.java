package net.cattaka.util.cathandsgendroid.test.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Set;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import net.cattaka.util.cathandsgendroid.accessor.Accessors;
import net.cattaka.util.cathandsgendroid.accessor.IAccessor;

public class SetSetStringAccessor implements IAccessor<Set<Set<String>>> {
    private IAccessor<Set<Set<String>>> child;

    public static <T> SetSetStringAccessor createAccessor(Class<?>... clazz) {
        return new SetSetStringAccessor(Accessors
                .createSetAccessor(Accessors.createSetAccessor(Accessors.StringAccessor.createAccessor(String.class))));
    }

    public SetSetStringAccessor(IAccessor<Set<Set<String>>> child) {
        super();
        this.child = child;
    }

    @Override
    public Set<Set<String>> readFromStream(DataInputStream in) throws IOException {
        return child.readFromStream(in);
    }

    @Override
    public void writeToStream(DataOutputStream out, Set<Set<String>> value) throws IOException {
        child.writeToStream(out, value);
    }

    @Override
    public Set<Set<String>> readFromParcel(Parcel p) {
        return child.readFromParcel(p);
    }

    @Override
    public void writeToParcel(Parcel p, Set<Set<String>> value) {
        child.writeToParcel(p, value);
    }

    @Override
    public Set<Set<String>> readFromCursor(Cursor c, int idx) {
        return child.readFromCursor(c, idx);
    }

    @Override
    public void putToContentValues(ContentValues values, String columnName, Set<Set<String>> value) {
        child.putToContentValues(values, columnName, value);
    }

    @Override
    public String stringValue(Set<Set<String>> value) {
        return child.stringValue(value);
    }
}
