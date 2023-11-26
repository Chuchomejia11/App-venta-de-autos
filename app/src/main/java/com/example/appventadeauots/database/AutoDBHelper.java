package com.example.appventadeauots.database;

import android.content.ContentValues;
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

        // Insertar datos por defecto
        insertDefaultAutos(db);
    }

    private void insertDefaultAutos(SQLiteDatabase db) {
        // Insertar 5 autos por defecto
        insertAuto(db, "Toyota", "Corolla", 2020, 20000.0);
        insertAuto(db, "Honda", "Civic", 2019, 18000.0);
        insertAuto(db, "Ford", "Fusion", 2021, 22000.0);
        insertAuto(db, "Chevrolet", "Malibu", 2018, 19000.0);
        insertAuto(db, "Nissan", "Altima", 2022, 24000.0);
    }

    private long insertAuto(SQLiteDatabase db, String marca, String nombre, int anio, double precio) {
        ContentValues values = new ContentValues();
        values.put("marca", marca);
        values.put("nombre", nombre);
        values.put("anio", anio);
        values.put("precio", precio);

        return db.insert("autos", null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Manejar las actualizaciones de la base de datos si es necesario
    }
}
