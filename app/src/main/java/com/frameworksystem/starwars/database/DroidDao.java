package com.frameworksystem.starwars.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.frameworksystem.starwars.model.Droid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felipe.arimateia on 12/3/2015.
 */
public class DroidDao {

    SQLiteDatabase db;

    public DroidDao(Context context) {
        db = DatabaseHelper.getDatabase(context);
    }

    public boolean save(Droid droid) {

        ContentValues contentValues = createContentValues(droid);
        long result = db.insert("droids",null,contentValues);

        if (result == -1) {
            return false;
        }

        return true;
    }

    public List<Droid> droids() {

        List<Droid> droids = new ArrayList<>();

        Cursor cursor = db.query("droid", null, null, null, null, null, "name");
        cursor.moveToFirst();

        while (cursor.moveToNext()) {
            Droid droid = createDroid(cursor);
            droids.add(droid);
        }

        return droids;
    }

    public boolean delete(String id) {
        return true;
    }

    public void close() {
        db.close();
    }

    private ContentValues createContentValues(Droid droid) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("id", droid.getId());
        contentValues.put("name", droid.getName());
        contentValues.put("description", droid.getDescription());
        contentValues.put("link", droid.getLink());
        contentValues.put("image", droid.getImage());

        return contentValues;
    }

    private Droid createDroid(Cursor cursor) {

        Droid droid = new Droid();
        droid.setId(cursor.getString(cursor.getColumnIndex("id")));
        droid.setName(cursor.getString(cursor.getColumnIndex("name")));
        droid.setDescription(cursor.getString(cursor.getColumnIndex("description")));
        droid.setImage(cursor.getString(cursor.getColumnIndex("image")));
        droid.setLink(cursor.getString(cursor.getColumnIndex("link")));

        return droid;
    }
}
