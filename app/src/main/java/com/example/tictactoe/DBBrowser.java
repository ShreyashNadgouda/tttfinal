package com.example.tictactoe;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBBrowser extends SQLiteOpenHelper
{
    private static final String dbname = "gametrack.db";
    public DBBrowser(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String qry="create table scores (player_1 varchar(255), player_2 varchar(255))";
        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("drop table if exists scores");
        onCreate(db);
    }

    public String addRecord(String p1, String p2)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv= new ContentValues();
        cv.put("player_1",p1);
        cv.put("player_2",p2);

        long res=db.insert("scores", null, cv);

        if (res==-1)
            return "Failed";
        else
            return "Inserted";
    }
}