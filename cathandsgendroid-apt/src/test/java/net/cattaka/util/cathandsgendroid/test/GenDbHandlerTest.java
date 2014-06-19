
package net.cattaka.util.cathandsgendroid.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.cattaka.util.cathandsgendroid.test.model.UserModel;
import net.cattaka.util.cathandsgendroid.test.model.UserModel.Authority;
import net.cattaka.util.cathandsgendroid.test.model.UserModel.Role;
import net.cattaka.util.cathandsgendroid.test.model.handler.UserModelHandler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowSQLiteDatabase;

import android.database.sqlite.SQLiteDatabase;

@RunWith(RobolectricTestRunner.class)
public class GenDbHandlerTest {

    @Test
    public void testDml() {
        SQLiteDatabase db = ShadowSQLiteDatabase.create(null);
        db.execSQL(UserModelHandler.SQL_CREATE_TABLE);
        { // Insert
            UserModel model;
            { // create model
                List<String> tags = new ArrayList<String>();
                tags.add("Java");
                tags.add("PHP");
                model = new UserModel(null, "taro", "Taro Yamada", "A", Role.PROGRAMMER,
                        new Date(), tags, Authority.ADMIN, new byte[] {
                                1, 2
                        }, true, (byte)120, 'C');
            }
            UserModelHandler.insert(db, model);
            UserModel model2 = UserModelHandler.findByUsername(db, "taro");
            assertEquals(model.getId(), model2.getId());
            assertEquals(model.getUsername(), model2.getUsername());
            assertEquals(model.getTeam(), model2.getTeam());
            assertEquals(model.getRole(), model2.getRole());
            assertEquals(model.getCreatedAt(), model2.getCreatedAt());
            assertEquals(model.getTags().size(), model2.getTags().size());
            assertEquals("Java", model2.getTags().get(0));
            assertEquals("PHP", model2.getTags().get(1));
            assertEquals(Authority.ADMIN, model2.getAuthority());
            assertNotNull(model2.getBlob());
            assertEquals((byte)1, model2.getBlob()[0]);
            assertEquals((byte)2, model2.getBlob()[1]);
            assertEquals(true, model2.getBooleanData().booleanValue());
            assertEquals((byte)120, model2.getByteData().byteValue());
            assertEquals('C', model2.getCharData().charValue());
        }
        { // Update
            UserModel model = UserModelHandler.findByUsername(db, "taro");
            { // update model
                List<String> tags = new ArrayList<String>();
                tags.add("Java");
                tags.add("PHP");
                tags.add("Ruby");
                model.setUsername("taro2");
                model.setNickname("Taro Yamada2");
                model.setTeam("B");
                model.setRole(Role.MANAGER);
                model.setCreatedAt(new Date());
                model.setTags(tags);
                model.setBlob(null);
                model.setBooleanData(false);
                model.setByteData((byte)111);
                model.setCharData('D');
            }
            long n = UserModelHandler.update(db, model);
            assertEquals(1L, n);
            UserModel model2 = UserModelHandler.findByUsername(db, "taro2");
            assertEquals(model.getId(), model2.getId());
            assertEquals(model.getUsername(), model2.getUsername());
            assertEquals(model.getTeam(), model2.getTeam());
            assertEquals(model.getRole(), model2.getRole());
            assertEquals(model.getCreatedAt(), model2.getCreatedAt());
            assertEquals(model.getTags().size(), model2.getTags().size());
            assertEquals("Java", model2.getTags().get(0));
            assertEquals("PHP", model2.getTags().get(1));
            assertNull(model2.getBlob());
            assertEquals(false, model2.getBooleanData().booleanValue());
            assertEquals((byte)111, model2.getByteData().byteValue());
            assertEquals('D', model2.getCharData().charValue());
        }
        { // delete
            UserModel model = UserModelHandler.findByUsername(db, "taro2");
            UserModelHandler.delete(db, model.getId());
            UserModel model2 = UserModelHandler.findByUsername(db, "taro2");
            assertNull(model2);
        }

        db.close();
    }

    @Test
    public void testFind() {
        SQLiteDatabase db = ShadowSQLiteDatabase.create(null);
        db.execSQL(UserModelHandler.SQL_CREATE_TABLE);
        UserModelHandler.insert(db, new UserModel(null, "taro", "Taro Yamada", "A",
                Role.PROGRAMMER, new Date(), null, Authority.ADMIN));
        UserModelHandler.insert(db, new UserModel(null, "hana", "Hana Yamada", "A", Role.DESIGNNER,
                new Date(), null, Authority.ADMIN));
        UserModelHandler.insert(db, new UserModel(null, "yuji", "Yuji Tanaka", "B",
                Role.PROGRAMMER, new Date(), null, Authority.ADMIN));
        UserModelHandler.insert(db, new UserModel(null, "chun", "Chun Tanaka", "B", Role.DESIGNNER,
                new Date(), null, Authority.USER));
        { // findById
            UserModel model = UserModelHandler.findById(db, 2L);
            assertEquals("hana", model.getUsername());
        }
        { // findByUsername
            UserModel model = UserModelHandler.findByUsername(db, "yuji");
            assertEquals("yuji", model.getUsername());
        }
        { // findByTeamOrderByRoleAscAndIdAsc
            List<UserModel> models = UserModelHandler.findByTeamOrderByRoleAscAndIdAsc(db, 0, "A");
            assertEquals(2, models.size());
            assertEquals("hana", models.get(0).getUsername());
            assertEquals("taro", models.get(1).getUsername());
        }
        { // findByTeamOrderByRoleAscAndIdDesc
            List<UserModel> models = UserModelHandler.findByTeamOrderByIdDesc(db, 0, "B");
            assertEquals(2, models.size());
            assertEquals("chun", models.get(0).getUsername());
            assertEquals("yuji", models.get(1).getUsername());
        }
        { // findByTeamOrderByRoleAscAndIdDesc
            List<UserModel> models = UserModelHandler.findByAuthorityOrderByIdAsc(db, 0,
                    Authority.ADMIN);
            assertEquals(3, models.size());
            assertEquals("taro", models.get(0).getUsername());
            assertEquals("hana", models.get(1).getUsername());
            assertEquals("yuji", models.get(2).getUsername());
        }
    }
}
