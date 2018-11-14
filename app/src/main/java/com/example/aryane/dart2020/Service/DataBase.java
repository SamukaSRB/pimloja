package com.example.aryane.dart2020.Service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    public static  final String  NOME_BANCO = "bancoDeDados.db";
    public static  final  int VERSAO = 2;

    public DataBase(Context context){
        super (context ,NOME_BANCO,null,VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql= "CREATE TABLE clientes (_id integer primary key  autoincrement, nome text,endereco text,numero text,bairro text,cep text,cidade text,estado text)";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP  TABLE  IF EXISTS clientes");
    onCreate(db);
    }
}
