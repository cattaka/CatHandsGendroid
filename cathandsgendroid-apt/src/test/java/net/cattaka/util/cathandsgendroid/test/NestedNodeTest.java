package net.cattaka.util.cathandsgendroid.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowSQLiteDatabase;

import net.cattaka.util.cathandsgendroid.test.model.Node;
import net.cattaka.util.cathandsgendroid.test.model.NodeCatHands;
import android.database.sqlite.SQLiteDatabase;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(RobolectricTestRunner.class)
public class NestedNodeTest {
    @Test
    public void testNested() {
        SQLiteDatabase db = ShadowSQLiteDatabase.create(null);
        db.execSQL(NodeCatHands.SQL_CREATE_TABLE);

        Node node3 = new Node(3,null);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        NodeCatHands.insert(db, node1);
        
        Node sup = NodeCatHands.findByKey(db, 1);
        { // Check nested values
            assertThat(sup, is(notNullValue()));
            assertThat(sup.getNode(), is(notNullValue()));
            assertThat(sup.getNode().getNode(), is(notNullValue()));
            assertThat(sup.getNode().getNode().getNode(), is(nullValue()));
            assertThat(sup.getKey(), is(1));
            assertThat(sup.getNode().getKey(), is(2));
            assertThat(sup.getNode().getNode().getKey(), is(3));
        }
    }
}
