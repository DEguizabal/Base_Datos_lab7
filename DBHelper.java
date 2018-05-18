package com.example.uca.base_datos_lab7.Entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.uca.base_datos_lab7.Datos.Persona;

/**
 * Created by UCA on 17/05/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "db_usuarios";
    public static final String TABLA_USUARIO = "Persona";
    public static final String CAMPO_ID = "dui";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CREAR_TABLA_USUARION = "CREATE TABLE " + TABLA_USUARIO + "("
            + CAMPO_ID + " TEXT, " + CAMPO_NOMBRE + "TEXT)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_USUARION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CAMPO_NOMBRE);
        onCreate(db);

    }

    public static DBHelper myDB = null;
    private Context context;//Contexto de la app
    SQLiteDatabase db;//para hacer operaciones dentro de la bd

    public static DBHelper getInstance(Context ctx){
        if (myDB == null){
            myDB = new DBHelper(ctx.getApplicationContext());
        }
        return myDB;
    }

    public DBHelper(Context context){
        super(context,DB_NAME,null,1);
        this.context = context;
        db = this.getWritableDatabase();
    }

    // Agrega persona
    public boolean add(Persona p){
        ContentValues values = new ContentValues();
        values.put(CAMPO_ID,p.getDui());
        values.put(CAMPO_NOMBRE,p.getNombre());
        db.insert(TABLA_USUARIO, null, values);
        Toast.makeText(context, "Insertado con exito", Toast.LENGTH_SHORT).show();
        return true;
    }

    public
}
