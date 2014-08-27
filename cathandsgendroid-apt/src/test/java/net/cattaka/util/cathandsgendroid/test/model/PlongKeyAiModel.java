package net.cattaka.util.cathandsgendroid.test.model;

import net.cattaka.util.cathandsgendroid.annotation.DataModel;
import net.cattaka.util.cathandsgendroid.annotation.DataModelAttrs;

@DataModel(find = "key", genDbFunc = true, autoincrement = true)
public class PlongKeyAiModel {
	@DataModelAttrs(primaryKey=true)
	private long key;

	public long getKey() {
		return key;
	}

	public void setKey(long key) {
		this.key = key;
	}
}