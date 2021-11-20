package com.example.tutorial8_rp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
    Context context;
    public DBHelper(Context context) {

        super(context, "Login.db", null, 2);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table if not exists users(id integer primary key autoincrement, username Text,password Text, email Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists users");
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String username, String password, String email) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("email", email);
        long result = sqLiteDatabase.insert("users", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkusername(String username) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery("select * from users where username = ?", new String[]{username});
        Cursor cursor = sqLiteDatabase.query("users", null, "username = ?", new String[]{username}, null, null, null);
        return (cursor.getCount() > 0);
        //        if (cursor.getCount() > 0) {
        //            return true;
        //        } else {
        //            return false;
        //        }
    }

    public boolean checkusernamePassword(String username, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from users where username = ? and password = ?", new String[]{username, password});

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Cursor getListData() {
        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("select username from users",null);
        Cursor cursor = db.query("users", new String[]{"id,username"}, null, null, null, null, null, null);

        return cursor;
    }
    public Cursor ShowListData()
    {
        SQLiteDatabase db1 = this.getReadableDatabase();
        Cursor c1 = db1.query("users",null,null,null,null,null,null);

        return c1;
    }
    public Cursor ShowListItemData()
    {
        SQLiteDatabase db2 =this.getReadableDatabase();
        Cursor c2 =db2.rawQuery("select * from users",null);
        Toast.makeText(context, c2.getColumnName(0), Toast.LENGTH_SHORT).show();
        Toast.makeText(context, c2.getColumnName(1), Toast.LENGTH_SHORT).show();
        Toast.makeText(context, c2.getColumnName(2), Toast.LENGTH_SHORT).show();
        Toast.makeText(context, c2.getColumnName(3), Toast.LENGTH_SHORT).show();


        return c2;
    }
}
