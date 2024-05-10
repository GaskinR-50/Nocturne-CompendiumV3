package com.example.finalchance;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EDatabaseAdapter {
        EDatabase e_data;
        SQLiteDatabase db;
        List<Entity> entityList = new ArrayList<>();

       public EDatabaseAdapter(Context context){
           e_data = new EDatabase(context);
           db = e_data.getWritableDatabase();
       }

public List<String> sendNames(){
           List<String> nameList = new ArrayList<>();
           Cursor cursor = db.query(EDatabase.T2, new String[] {EDatabase.KEY_ROW_ID, EDatabase.KEY_NAME,EDatabase.KEY_REC}, null,null, null,null,null,null);
           while(cursor.moveToNext()){
               int index2 = cursor.getColumnIndex(EDatabase.KEY_NAME);
               String name = cursor.getString(index2);
               nameList.add(name);
           }
           return nameList;
}
public List<String> sendRecipes(){
        List<String> recipeList = new ArrayList<>();
        Cursor cursor = db.query(EDatabase.T2, new String[] {EDatabase.KEY_ROW_ID, EDatabase.KEY_NAME,EDatabase.KEY_REC}, null,null, null,null,null,null);
        while(cursor.moveToNext()){
            int index3 = cursor.getColumnIndex(EDatabase.KEY_REC);
            String name = cursor.getString(index3);
            recipeList.add(name);
        }
        return recipeList;
    }

public List<Entity> getDATA(){
           Cursor cursor = db.query(EDatabase.TB_NAME, new String[] {EDatabase.KEY_ROW_ID,EDatabase.KEY_IMG,EDatabase.KEY_NAME, EDatabase.KEY_DESC, EDatabase.KEY_LEVEL, EDatabase.KEY_TYPE, EDatabase.KEY_ORIGIN}, null,null, null,null,null,null);
           while(cursor.moveToNext()){
               int index1 = cursor.getColumnIndex(EDatabase.KEY_ROW_ID);
               int rowid = cursor.getInt(index1);
               int index2 = cursor.getColumnIndex(EDatabase.KEY_IMG);
               byte[] img = cursor.getBlob(index2);
               int index3 = cursor.getColumnIndex(EDatabase.KEY_NAME);
               String name = cursor.getString(index3);
               int index4 = cursor.getColumnIndex(EDatabase.KEY_TYPE);
               String type = cursor.getString(index4);
               int index5 = cursor.getColumnIndex(EDatabase.KEY_DESC);
               String desc = cursor.getString(index5);
               int index6 = cursor.getColumnIndex(EDatabase.KEY_LEVEL);
               String level = cursor.getString(index6);
               int index7 = cursor.getColumnIndex(EDatabase.KEY_ORIGIN);
               String origin = cursor.getString(index7);
               Entity entity = new Entity(rowid, img, name, type, desc, level ,origin);
               entityList.add(entity);
           }
           return entityList;
}

private static class EDatabase extends SQLiteOpenHelper {
    private static final String DB_NAME = "demons.db";
    private static final int DB_Version = 6;
    private static final String TB_NAME = "demons";
    private static final String T2 = "recipe";
    private static final String KEY_ROW_ID = "_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_TYPE = "type";
    private static final String KEY_ORIGIN = "origin";
    private static final String KEY_DESC = "description";
    private static final String KEY_LEVEL = "level";
    private static final String KEY_IMG = "image";
    private static final String KEY_REC = "recipes";

    private static final String CREATE_TABLE = "create table " + TB_NAME +
            " (" + KEY_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_IMG + " BLOB NOT NULL, " +  KEY_NAME + " text," + KEY_LEVEL + " text, " + KEY_DESC + " text, " +
            KEY_ORIGIN + " text, " + KEY_TYPE + " text)";

    private static final String CREATE_TABLE2 = "create table " + T2 +
            " (" + KEY_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME + " text, " +  KEY_REC + " text)";

    private static final String DROP_TABLE = "drop table if exists " + TB_NAME + T2;
    private Context context;

    public EDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_Version);
        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
            db.execSQL(CREATE_TABLE2);
            Toast.makeText(context, "summoning available", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Toast.makeText(context, "refreshing temple", Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (SQLException e) {
            Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
        }
    }


}

}

