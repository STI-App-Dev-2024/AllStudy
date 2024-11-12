package com.jtdev.all_study;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseConnectStudent extends SQLiteOpenHelper {

    private static final String dbName = "studentLoginRegister";
    private static final String dbTable = "studentusers";
    private static final int dbVersion = 1;
    private static final String fullName = "fullname";
    private static final String emailAddress = "emailAddress";
    private static final String Password = "password";

    public DatabaseConnectStudent(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String studentID = "studentid";
        String query = "CREATE TABLE " + dbTable + " ("
                + studentID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + fullName + " TEXT, "
                + emailAddress + " TEXT, "
                + Password + " TEXT);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + dbTable);
        onCreate(sqLiteDatabase);
    }

    public void addStudent(DatabaseStudent student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(fullName, student.getFullName());
        values.put(emailAddress, student.getEmailAddress());
        values.put(Password, student.getPassword());
        db.insert(dbTable, null, values);
    }
}
