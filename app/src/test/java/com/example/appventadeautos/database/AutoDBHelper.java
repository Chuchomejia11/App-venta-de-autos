package com.example.appventadeautos.database;
// AutoDBHelper.java

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AutoDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "autos.db";
    private static final int DATABASE_VERSION = 1;

    // Constructor
    public AutoDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear la tabla de autos
        String createTable = "CREATE TABLE autos " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "marca TEXT, " +
                "nombre TEXT, " +
                "anio INTEGER, " +
                "precio REAL);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Manejar las actualizaciones de la base de datos si es necesario
    }
}
