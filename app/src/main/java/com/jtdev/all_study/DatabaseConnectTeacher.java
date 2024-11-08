package com.jtdev.all_study;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseConnectTeacher extends SQLiteOpenHelper {

    private static String dbName = "teacherLoginRegister";
    private static String dbTable = "teacherusers";
    private static int dbVersion = 1;

    private static String TeacherID = "teacherid";
    private static String fullTeacherName = "fullteachername";
    private static String teacherEmailAddress = "teacherEmailAddress";
    private static String teacherPassword = "teacherpassword";

    public DatabaseConnectTeacher(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + dbTable + " ("
                + TeacherID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + fullTeacherName + " TEXT, "
                + teacherEmailAddress + " TEXT, "
                + teacherPassword + " TEXT);";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + dbTable);
        onCreate(sqLiteDatabase);
    }
        public void addTeacher(DatabaseTeacher teacher){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(fullTeacherName, teacher.getFullTeacherName());
            values.put(teacherEmailAddress, teacher.getTeacherEmailAddress());
            values.put(teacherPassword, teacher.getTeacherPassword());
            db.insert(dbTable, null, values);
    }
}
