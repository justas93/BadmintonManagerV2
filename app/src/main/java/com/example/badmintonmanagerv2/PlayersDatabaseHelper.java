package com.example.badmintonmanagerv2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class PlayersDatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "PlayersDatabase.db";
    public static final int DATABASE_VERSION = 1;

    public PlayersDatabaseHelper(Context context) {super(context,DATABASE_NAME, null, DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PlayersDatabaseContract.PlayerEntry.SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
