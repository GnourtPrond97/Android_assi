package com.example.android_assignment.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static   final String DB_NAME = "Payment";
    public static   final int DB_VERSION = 1;

    public static String TABLE_NAME = "PAYMENT";
    public static String ID = "_id";
    public static String NAME = "name";
    public static String AMOUNT = "amount";
    public static String DES = "des";
    public static String TIME = "time";
    public static String CATEGORY = "category";

    public static String TABLE_NAME_CATEGORY = "Category";
    public static String CATEGORY_ID = "_id";
    public static String CATEGORY_NAME = "name";




    public DBHelper(Context context){
        super(context, DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY, " +
                NAME + " TEXT, " +
                AMOUNT + " DOUBLE, " +
                DES + " TEXT, " +
                TIME + " INTEGER, " +
                CATEGORY + " TEXT)";
        sqLiteDatabase.execSQL(sql);
        String sqlCategory = "CREATE TABLE " + TABLE_NAME_CATEGORY + "(" +
                ID + " INTEGER PRIMARY KEY, " +
                NAME + " TEXT)";
        sqLiteDatabase.execSQL(sqlCategory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS "  + TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public String addPayment(String name, Double amount, String des, int time,String category){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);


        long isAdd = db.insert(TABLE_NAME,null,contentValues);
        if(isAdd == -1){
            return  "Add fail !";
        }
        db.close();
        return "Add success !";
    }

    public String addCategory(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);


        long isAdd = db.insert(TABLE_NAME_CATEGORY,null,contentValues);
        if(isAdd == -1){
            return  "Add fail !";
        }
        db.close();
        return "Add success !";
    }

    public Cursor getAllPayment(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + DB_NAME;
        Cursor c = db.rawQuery(sql,null);
        return c;
    }

}
