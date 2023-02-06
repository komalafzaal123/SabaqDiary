package com.example.sabaq;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "SabaqDiary";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "sabaqRecord";
    private static final String ID_COL = "id";
    private static final String STUDENT_NAME = "student_name";
    private static final String SABAQ_PARA = "sabaq_para";
    private static final String SABAQ_STATUS = "sabaq_status";
    private static final String SABAQII_PARA = "sabaqii_para";
    private static final String SABAQII_STATUS = "sabaqii_status";
    private static final String MANZIL_PARA = "manzil_para";
    private static final String MANZIL_STATUS = "manzil_status";
    private static final String DATE = "date";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + STUDENT_NAME + " TEXT, "
                + SABAQ_PARA + " TEXT, "
                + SABAQ_STATUS + " TEXT, "
                + SABAQII_PARA + " TEXT, "
                + SABAQII_STATUS + " TEXT, "
                + MANZIL_PARA + " TEXT, "
                + MANZIL_STATUS + " TEXT, "
                + DATE + " Text )";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void saveData(SabaqDiary sabaq) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(STUDENT_NAME, sabaq.getStudentName());
        values.put(SABAQ_PARA, sabaq.getSabaqPara());
        values.put(SABAQ_STATUS, sabaq.getSabaqStatus());
        values.put(SABAQII_PARA, sabaq.getSabaqiiPara());
        values.put(SABAQII_STATUS, sabaq.getSabaqiiStatus());
        values.put(MANZIL_PARA, sabaq.getManzilPara());
        values.put(MANZIL_STATUS, sabaq.getManzilStatus());
        values.put(DATE, sabaq.getDate());


        db.insert(TABLE_NAME, null, values);
    }

    public ArrayList<SabaqDiary> getAllData() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<SabaqDiary> dataArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursor.moveToFirst()) {
            do {
                dataArrayList.add(new SabaqDiary(cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8)));
            } while (cursor.moveToNext());

        }

        cursor.close();
        return dataArrayList;
    }
}