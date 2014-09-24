
package net.cattaka.util.cathandsgendroid.test.model;

import net.cattaka.util.cathandsgendroid.annotation.DataModel;
import android.os.Parcel;
import android.os.Parcelable;

@DataModel(genParcelFunc=true, genDbFunc=false, genAccessor=true, genDsFunc=true)
public class TinyParcelable implements Parcelable {
    public static final Creator<TinyParcelable> CREATOR = TinyParcelableCatHands.CREATOR;
    
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        TinyParcelableCatHands.writeToParcel(this, out, flags);
    }

    private int data;

    public TinyParcelable() {
    }

    
    
    public TinyParcelable(int data) {
        super();
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}
