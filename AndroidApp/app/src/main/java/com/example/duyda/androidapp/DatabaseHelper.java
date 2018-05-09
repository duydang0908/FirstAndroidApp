package com.example.duyda.androidapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table User(username text primary key, password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS User");
        onCreate(db);
    }

    public Boolean insert(String name, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", name);
        contentValues.put("password", pass);
        long ins = db.insert("User", null, contentValues);
        if (ins == -1)
            return false;
        else
            return true;
    }

    public Boolean checkUserName(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select *from user where username= ?", new String[]{username});
        if (cursor.getCount() > 0)
            return false;
        else
            return true;
    }

    public Boolean checkLogin(String name, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=? and password=?", new String[]{name, pass});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

}
