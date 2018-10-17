package routin_qin.tirage.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Choice.db";
    /*public static final String SQL_CREATE_ELEMENTS_ENTRIES = "CREATE TABLE " + Category.TABLE_NAME + "(" +
                                                                                 Category.COLUMN_NUM_ID + " INTEGER PRIMARY KEY," +
                                                                                 Category.COLUMN_NAME_TITLE + " TEXT," +
                                                                                 Category.COLUMN_NAME_DESCRIPTION + " TEXT);";*/
    public static final String SQL_CREATE_ELEMENTS_ENTRIES = "CREATE TABLE elements (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT)";

    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ELEMENTS_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public void addElement(String title, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("description", description);
        db.insert("elements", null, contentValues);
    }

    public void removeElement(String title){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("elements", "title" + "=" + title, null);
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM elements", null);
        return result;
    }


}
