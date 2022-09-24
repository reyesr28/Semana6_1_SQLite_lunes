package com.example.semana6_1_sqlite_lunes

import Beans.Usuarios
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class OpenHelper(context: Context):SQLiteOpenHelper(
    context,"usuarios.db",null,1) {

    override fun onCreate(p0: SQLiteDatabase?) {
        val query="create table users(_ID integer primary key autoincrement, " +
                "nombre text, edad integer, mail text)"
        p0!!.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val query2="drop table users"
        p0!!.execSQL(query2)
        onCreate(p0)
    }

    fun nuevoUser(u:Usuarios){
        val datos=ContentValues()
        datos.put("nombre",u.nombre)
        datos.put("edad",u.edad)
        datos.put("mail",u.mail)
        val db=this.writableDatabase.insert("users",null,datos)
    }

    fun leerData():MutableList<Usuarios>{

        val db=this.readableDatabase
        val query="select * from users"
        val result=db.rawQuery(query,null)

        val listaU= mutableListOf<Usuarios>()

        if(result.moveToFirst()){
            do{
                listaU.add(
                    Usuarios(
                    result.getInt(0),result.getString(1),
                        result.getInt(2),result.getString(3)
                ))
            }while (result.moveToNext())
        }
        return listaU
    }

    fun deleteData(id:Int){
        val db=this.writableDatabase
        val contentValues=ContentValues()
        contentValues.put("_ID",id)
        db.delete("users","_ID="+id,null)
        db.close()
    }

    fun editarUser(u:Usuarios){
        val datos=ContentValues()
        datos.put("nombre",u.nombre)
        datos.put("edad",u.edad)
        datos.put("mail",u.mail)
        val db=this.writableDatabase.update("users",datos,"_ID="+u.cod,null)
    }

}