package net.cattaka.util.cathandsgendroid.test.model;

import net.cattaka.util.cathandsgendroid.annotation.DataModel;
import net.cattaka.util.cathandsgendroid.annotation.DataModelAttrs;

@DataModel(find = "key", genDbFunc = true, autoincrement = true)
public class LongKeyAiModel {
	@DataModelAttrs(primaryKey=true)
	private Long key;

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}
}