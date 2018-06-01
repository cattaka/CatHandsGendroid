package net.cattaka.util.cathandsgendroid.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import net.cattaka.util.cathandsgendroid.test.model.FullModel;
import net.cattaka.util.cathandsgendroid.test.model.ListTinyParcelable;
import net.cattaka.util.cathandsgendroid.test.model.TinyParcelable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import android.os.Parcel;
import org.robolectric.annotation.Config;
import org.robolectric.shadow.api.Shadow;

@RunWith(RobolectricTestRunner.class)
public class ListTinyParcelableTest {
	@Test
    public void testParcelFunc_null() {
	    ListTinyParcelable model = new ListTinyParcelable();
        Parcel parcel;
        {
            parcel = Shadow.newInstanceOf(Parcel.class);
            parcel.writeParcelable(model, 0);
        }
        {
            ListTinyParcelable t = parcel.readParcelable(this.getClass().getClassLoader());
            parcel.recycle();
            assertEquals(model.getTinyParcelables(), null);
        }        
	}
    @Test
    public void testParcelFunc() {
        ListTinyParcelable model = new ListTinyParcelable();
        {
            model.setTinyParcelables(new ArrayList<TinyParcelable>());
            model.getTinyParcelables().add(new TinyParcelable(10));
            model.getTinyParcelables().add(new TinyParcelable(20));
        }
        Parcel parcel;
        {
            parcel = Shadow.newInstanceOf(Parcel.class);
            parcel.writeParcelable(model, 0);
        }
        {
            ListTinyParcelable t = parcel.readParcelable(this.getClass().getClassLoader());
            parcel.recycle();
            assertEquals(model.getTinyParcelables().size(), 2);
            assertEquals(model.getTinyParcelables().get(0).getData(), 10);
            assertEquals(model.getTinyParcelables().get(1).getData(), 20);
        }        
    }
}
