package com.example.bogusz.eartraining.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bogusz on 09.09.17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // fields to database
    public static final String DB_NAME = "Ear-data.sqlite";
    public static final String DB_LOCATION = "/data/data/com.example.bogusz.eartraining/databases/";

    public static final String INTERWALY_TAB = "interwaly";

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String CONTENT = "content";
    public static final String BUTTON = "button";

    private Context myContext;
    private SQLiteDatabase myDatabase;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void openDatabas(){

        String dbPath = myContext.getDatabasePath(DB_NAME).getPath();
        if(myDatabase != null && myDatabase.isOpen()){
            return;
        }
        myDatabase = SQLiteDatabase.openDatabase(dbPath,null,SQLiteDatabase.OPEN_READWRITE);
    }

    private void closeDatabase(){
        if(myDatabase != null){
            myDatabase.close();
        }
    }

    public List<CardQuest> getAllCards(){
        CardQuest cardQuest;
        List<CardQuest> cardQuestList = new ArrayList<>();
        openDatabas();
        Cursor cursor = myDatabase.rawQuery("SELECT * FROM " + INTERWALY_TAB, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            cardQuest = new CardQuest(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            cardQuestList.add(cardQuest);
            cursor.moveToNext();
        }

        cursor.close();
        closeDatabase();
        return cardQuestList;
    }
}
