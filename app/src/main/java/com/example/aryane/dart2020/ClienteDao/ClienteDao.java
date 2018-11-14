package com.example.aryane.dart2020.ClienteDao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aryane.dart2020.Service.DataBase;

public class ClienteDao {
public SQLiteDatabase banco;
public DataBase dataBase;

public ClienteDao(Context context){
dataBase = new DataBase(context);
}
public  boolean criarClientes(String nome,String endereco,String numero,String bairro,String cep,String cidade,String estado) {
    banco =  dataBase.getWritableDatabase();
    ContentValues valores = new ContentValues();
    valores.put("nome",nome);
    valores.put("endereco",endereco);
    valores.put("numero",numero);
    valores.put("bairro",bairro);
    valores.put("cep",cep);
    valores.put("cidade",cidade);
    valores.put("estado",estado);

    long resultado = banco.insert("clientes",null,valores);
    banco.close();
    return resultado >0;
    }
public Cursor consultarClientes(){
    String[] campos = {"_id","nome","endereco","numero","cep","bairro","cidade","estado"};
    SQLiteDatabase db = dataBase.getReadableDatabase();
    Cursor cursor = db.query("clientes",campos ,null,null,null,null,"nome ASC");
    if (cursor!=null) {
        cursor.moveToFirst();
    }
    db.close();
    return cursor;
    }
public void atualizaCliente(int id,String nome,String endereco,String numero,String bairro,String cep,String cidade,String estado){
    SQLiteDatabase db = dataBase.getReadableDatabase();
    String where = "_id =" +id;
        ContentValues valores = new ContentValues();
        valores.put("nome",nome);
        valores.put("endereco",endereco);
        valores.put("numero",numero);
        valores.put("bairro",bairro);
        valores.put("cep",cep);
        valores.put("cidade",cidade);
        valores.put("estado",estado);

        db.update("clientes",valores ,where ,null);
        db.close();

    }
public void  excluirClientes(int _id){
        SQLiteDatabase db =  dataBase.getReadableDatabase();
        String  where = "_id="+_id;
        db.delete("clientes",where,null);
        db.close();

    }
}
