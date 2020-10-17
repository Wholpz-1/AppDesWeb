package com.example.desweb2020;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;



public class BD extends SQLiteOpenHelper {
    private static final String NOMBRE_BD=("registro.bd");
    private static final int VERSION_BD=1;
    private static final String TABLA_REGISTROP="CREATE TABLE REGISTROP(CODIGO VARCHAR PRIMARY KEY, NOMBRE VARCHAR, APELLIDO VARCHAR, TELEFONO VARCHAR)";

    public BD(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_REGISTROP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_REGISTROP);
        sqLiteDatabase.execSQL(TABLA_REGISTROP);

    }
    public void agregarRegistroP(String codigo, String nombre, String apellido, String telefono){
        SQLiteDatabase bd= getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO REGISTROP VALUES('"+codigo+"','"+nombre+"','"+apellido+"','"+telefono+"')");
            bd.close();
        }

    }
}
