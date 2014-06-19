
package net.cattaka.util.cathandsgendroid.test.model;

import java.io.Serializable;

public class TinySerializable implements Serializable {
    private static final long serialVersionUID = 1L;

    private int mData;

    public TinySerializable() {
    }

    
    
    public TinySerializable(int mData) {
		super();
		this.mData = mData;
	}



	public int getData() {
        return mData;
    }

    public void setData(int data) {
        this.mData = data;
    }

}
