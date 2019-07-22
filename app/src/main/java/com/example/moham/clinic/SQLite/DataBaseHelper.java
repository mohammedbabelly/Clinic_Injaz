package com.example.moham.clinic.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ClinicOffline.db";

    public static final String TABLE_NAME = "day_table";
    public static final String DELETED_TABLE = "deleted_records";
    public static final String ADDED_TABLE = "added_records";

    public static final String COL1 = "fullName";
    public static final String COL2 = "status";
    public static final String COL3 = "time";


    public DataBaseHelper( Context context) { //constructer
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //execute the database and make it ready to use
        db.execSQL("create table if not exists " + TABLE_NAME + " (fullname TEXT,status TEXT,time TEXT) ");
        db.execSQL("create table if not exists " + DELETED_TABLE + " (fullname TEXT,status TEXT,time TEXT) ");
        db.execSQL("create table if not exists " + ADDED_TABLE + " (fullname TEXT,status TEXT,time TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
       // onCreate(db);

    }

    public boolean insertData(String fullName,String status, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, fullName);
        contentValues.put(COL2, status);
        contentValues.put(COL3, time);
         long result = db.insert(TABLE_NAME, null, contentValues);

        if (result < 1)
            return false;
        else
            return true;

    }
    public boolean insertDeleted(String fullName,String status, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, fullName);
        contentValues.put(COL2, status);
        contentValues.put(COL3, time);
        long result = db.insert(DELETED_TABLE, null, contentValues);

        if (result < 1)
            return false;
        else
            return true;

    }
    public boolean insertAdded(String fullName,String status, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, fullName);
        contentValues.put(COL2, status);
        contentValues.put(COL3, time);
        long result = db.insert(ADDED_TABLE, null, contentValues);

        if (result < 1)
            return false;
        else
            return true;

    }




    public void emptyTable() {
        SQLiteDatabase db = this.getWritableDatabase();
         db.execSQL(" delete from  " + TABLE_NAME);

        onCreate(db);
    }
    public void emptyDeleted() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(" delete from " + DELETED_TABLE);
    }
    public void emptyAdded() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(" delete from " + ADDED_TABLE);
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery(" SELECT * FROM  " + TABLE_NAME, null);
    }
    public Cursor getDeletedData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery(" SELECT * FROM  " + DELETED_TABLE, null);
    }
    public Cursor getAddedData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery(" SELECT * FROM  " + ADDED_TABLE, null);
    }


    public void deleteData(String time) {
        SQLiteDatabase db = this.getWritableDatabase();

         db.delete(TABLE_NAME, " time=? ", new String[]{time});
    }


    public boolean upgradeData(String id, String title, String des) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, id);

        contentValues.put(COL2, title);
        contentValues.put(COL3, des);


        db.update(TABLE_NAME, contentValues, "ID =? ", new String[]{id});

        return true;
    }








}
