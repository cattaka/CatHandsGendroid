package net.cattaka.util.cathandsgendroid.test.model;

import net.cattaka.util.cathandsgendroid.annotation.DataModel;
import net.cattaka.util.cathandsgendroid.annotation.DataModelAttrs;
import android.os.Parcelable;

@DataModel(genDbFunc=true, genParcelFunc=true)
public class ForDbParelData implements Parcelable {
    public static Creator<ForDbParelData> CREATOR = ForDbParelDataCatHands.CREATOR;
    
    @Override
    public int describeContents() {
        return 0;
    }
    public void writeToParcel(android.os.Parcel dest, int flags) {
        
    };
    
    
    @DataModelAttrs(primaryKey=true)
    private int id;
    @DataModelAttrs(forDb=true, forParcel=false)
    private String forOnlyDb;
    @DataModelAttrs(forDb=false, forParcel=true)
    private String forOnlyParcel;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getForOnlyDb() {
        return forOnlyDb;
    }
    public void setForOnlyDb(String forOnlyDb) {
        this.forOnlyDb = forOnlyDb;
    }
    public String getForOnlyParcel() {
        return forOnlyParcel;
    }
    public void setForOnlyParcel(String forOnlyParcel) {
        this.forOnlyParcel = forOnlyParcel;
    }
    
    
}
