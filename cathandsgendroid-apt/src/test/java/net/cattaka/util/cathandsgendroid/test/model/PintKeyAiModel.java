package net.cattaka.util.cathandsgendroid.test.model;

import net.cattaka.util.cathandsgendroid.annotation.DataModel;
import net.cattaka.util.cathandsgendroid.annotation.DataModelAttrs;

@DataModel(find = "key", genDbFunc = true, autoincrement = true)
public class PintKeyAiModel {
	@DataModelAttrs(primaryKey=true)
	private int key;

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
}