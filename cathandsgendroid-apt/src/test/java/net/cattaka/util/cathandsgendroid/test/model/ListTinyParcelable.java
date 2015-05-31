package net.cattaka.util.cathandsgendroid.test.model;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import net.cattaka.util.cathandsgendroid.annotation.DataModel;
import net.cattaka.util.cathandsgendroid.annotation.DataModelAttrs;

@DataModel(genDbFunc=false,genParcelFunc=true)
public class ListTinyParcelable implements Parcelable {
    public static final Creator<ListTinyParcelable> CREATOR = ListTinyParcelableCatHands.CREATOR;
    
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        ListTinyParcelableCatHands.writeToParcel(this, out, flags);
    }
    
    @DataModelAttrs(forDb=false)
    private java.util.List<TinyParcelable> tinyParcelables;
 
    public List<TinyParcelable> getTinyParcelables() {
        return tinyParcelables;
    }

    public void setTinyParcelables(List<TinyParcelable> tinyParcelables) {
        this.tinyParcelables = tinyParcelables;
    }
}
