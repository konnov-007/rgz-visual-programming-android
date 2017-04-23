package konnov.commr.vk.myapplication9;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ilya on 4/23/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "customerDb";
    public static final String TABLE_CUSTOMERS = "customers";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_FILM = "film";
    public static final String KEY_DATE = "date";
    public static final String KEY_MAIL = "mail";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_CUSTOMERS + "(" + KEY_ID
                + " integer primary key," + KEY_NAME + " text," + KEY_FILM + " text," + KEY_DATE + " text, " + KEY_MAIL + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CUSTOMERS);

        onCreate(db);
    }
}