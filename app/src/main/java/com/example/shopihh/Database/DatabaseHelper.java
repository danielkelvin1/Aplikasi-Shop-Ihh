package com.example.shopihh.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    //nama database
    private static final String NamaDatabase = "shopihh.db";
    //versi database menandakan database sudah di rubah sebanyak 3 kali
    private static final int VersiDatabase = 3;


    //Query yang digunakan untuk membuat table login
    private static final String SQL_CREATE_ENTRIES_LOGIN = "CREATE TABLE "+ loginProperty.NamaTabel+" ("+
            loginProperty.Username+" TEXT PRIMARY KEY, "+loginProperty.Password+" TEXT NOT NULL, "+
            loginProperty.Nama+" TEXT NOT NULL, "+loginProperty.JK+" TEXT NOT NULL, "+loginProperty.Telepon+
            " TEXT NOT NULL, "+loginProperty.Email+" TEXT NOT NULL, "+ loginProperty.Alamat+" TEXT NOT NULL)";

    //construktor untuk mendapatkan conteks
    public DatabaseHelper(Context context){
        super(context, NamaDatabase, null, VersiDatabase);
    }

    //membuat database
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES_LOGIN);
    }

    //upgrade database jika ada perubahan di table
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+loginProperty.NamaTabel);
        onCreate(db);
    }



}
