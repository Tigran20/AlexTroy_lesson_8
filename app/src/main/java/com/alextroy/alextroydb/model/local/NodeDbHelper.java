package com.alextroy.alextroydb.model.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NodeDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "node.db";
    public static final int DATABASE_VERSION = 1;

    public NodeDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + NodeContract.NodeEntry.TABLE_NAME + "("
                + NodeContract.NodeEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NodeContract.NodeEntry.COLUMN_NODE_VALUE + " TEXT NOT NULL);";
        db.execSQL(SQL_CREATE_PETS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
