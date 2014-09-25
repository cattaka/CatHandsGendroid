
package net.cattaka.util.cathandsgendroid.test.model;

import net.cattaka.util.cathandsgendroid.annotation.DataModel;
import net.cattaka.util.cathandsgendroid.annotation.DataModelAttrs;
import android.os.Parcel;
import android.os.Parcelable;

@DataModel(genParcelFunc=true, genDbFunc=true, genAccessor=true, genDsFunc=true, find="key")
public class Node implements Parcelable {
    public static final Creator<Node> CREATOR = NodeCatHands.CREATOR;
    
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        NodeCatHands.writeToParcel(this, out, flags);
    }
    
    @DataModelAttrs(primaryKey=true)
    private int key;
    private Node node;

    public Node() {
    }

    public Node(int key, Node node) {
        super();
        this.key = key;
        this.node = node;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    
}
