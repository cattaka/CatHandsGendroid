package net.cattaka.util.cathandsgendroid.test.model;

import net.cattaka.util.cathandsgendroid.annotation.DataModel;
import net.cattaka.util.cathandsgendroid.annotation.DataModelAttrs;

@DataModel(find = "key", genDbFunc = true, autoincrement = true)
public class IntKeyAiModel {
	@DataModelAttrs(primaryKey=true)
	private Integer key;

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}
}