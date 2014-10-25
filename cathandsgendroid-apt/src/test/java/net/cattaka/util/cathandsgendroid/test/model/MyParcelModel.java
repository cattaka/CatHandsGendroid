package net.cattaka.util.cathandsgendroid.test.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import net.cattaka.util.cathandsgendroid.annotation.DataModel;

@DataModel(genParcelFunc=true, genDbFunc=false)
public class MyParcelModel implements Parcelable {
    public static final Creator<MyParcelModel> CREATOR = 
            MyParcelModelCatHands.CREATOR;
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        MyParcelModelCatHands.writeToParcel(this, dest, flags);
    }
    @Override
    public int describeContents() {
        return 0;
    }
    
    private String strValue1;
    private String strValue2;
    private int intValue1;
    private int intValue2;
    private int doubleValue1;
    private int doubleValue2;

    public String getStrValue1() {
        return strValue1;
    }
    public void setStrValue1(String strValue1) {
        this.strValue1 = strValue1;
    }
    public String getStrValue2() {
        return strValue2;
    }
    public void setStrValue2(String strValue2) {
        this.strValue2 = strValue2;
    }
    public int getIntValue1() {
        return intValue1;
    }
    public void setIntValue1(int intValue1) {
        this.intValue1 = intValue1;
    }
    public int getIntValue2() {
        return intValue2;
    }
    public void setIntValue2(int intValue2) {
        this.intValue2 = intValue2;
    }
    public int getDoubleValue1() {
        return doubleValue1;
    }
    public void setDoubleValue1(int doubleValue1) {
        this.doubleValue1 = doubleValue1;
    }
    public int getDoubleValue2() {
        return doubleValue2;
    }
    public void setDoubleValue2(int doubleValue2) {
        this.doubleValue2 = doubleValue2;
    }
}
