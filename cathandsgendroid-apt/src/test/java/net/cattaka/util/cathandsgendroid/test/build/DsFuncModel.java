package net.cattaka.util.cathandsgendroid.test.build;

import net.cattaka.util.cathandsgendroid.annotation.DataModel;
import net.cattaka.util.cathandsgendroid.annotation.DataModelAttrs;

@DataModel(genContentResolverFunc=false,genDbFunc=false,genDsFunc=true,genParcelFunc=false)
public class DsFuncModel {
    @DataModelAttrs(primaryKey = true)
    private int key;
    private String value;
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
