package com.example.farmket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "FarmKet.db";
    public static final String TABLE_NAME = "cart_table";
    public static final String COL1 = "ID";
    public static final String COL2 = "ITEM";
    public static final String COL3 = "FARMER";
    public static final String COL4 = "PRICE";
    public static final String COL5 = "WEIGHT";
    public static final String COL6 = "AMOUNT";
    public static final String COL7 = "TOTAL";


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 4);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("delete from "+ TABLE_NAME);
        db.execSQL("create table "+ TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, ITEM TEXT, FARMER TEXT, PRICE INTEGER, WEIGHT TEXT, AMOUNT INTEGER, TOTAL INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String item, String name, Integer price, String weight, Integer amount, Integer total){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item);
        contentValues.put(COL3, name);
        contentValues.put(COL4, price);
        contentValues.put(COL5, weight);
        contentValues.put(COL6, amount);
        contentValues.put(COL7, total);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
/*
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME, null);
        return res;
    }

*/
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public ArrayList<cart> getAllData(){
        ArrayList<cart> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME, null);

        while(res.moveToNext()){
            int id = res.getInt(0);
            String item = res.getString(1);
            String name = res.getString(2);
            int price = res.getInt(3);
            String weight = res.getString(4);
            int amount = res.getInt(5);
            int total = res.getInt(6);

            cart cart = new cart(id, item, name, price, weight, amount, total);

            arrayList.add(cart);
        }
        return arrayList;
    }
}
