package net.cattaka.util.cathandsgendroid.test.model;

import net.cattaka.util.cathandsgendroid.annotation.DataModel;
import net.cattaka.util.cathandsgendroid.annotation.DataModelAttrs;

@DataModel(find="key", autoincrement=false, 
query= {
        "Distinct:select distinct value from stringKvModel",
        "QueryKey:select value from stringKvModel where key=?",
        "QueryValue:select key as value from stringKvModel where value=?"
}
)
public class StringKvModel {
	@DataModelAttrs(primaryKey=true)
	private String key;
	private String value;

	public StringKvModel() {
	}
	
	public StringKvModel(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
