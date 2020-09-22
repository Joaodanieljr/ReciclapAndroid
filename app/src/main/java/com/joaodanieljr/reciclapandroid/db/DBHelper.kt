package com.joaodanieljr.reciclapandroid.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.joaodanieljr.reciclapandroid.model.Materiais


class DBHelper(context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_TABLE_QUERY:String = ("CREATE TABLE $TABLE_NAME (" +
                "$COL_ID INTEGER PRIMARY KEY," +
                "$COL_NOME TEXT," +
                "$COL_LIXEIRA TEXT," +
                "$COL_COMPOSICAO TEXT," +
                "$COL_DECOMPOSICAO TEXT," +
                "$COL_INFORMACAO TEXT," +
                "$COL_EMPRESA TEXT," +
                "$COL_LOCAL_RECICLAR TEXT)")

        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 2
        const val DATABASE_NAME = "Materiais"

        //Table
        val TABLE_NAME = "Materiais"
        val COL_ID = "Id"
        val COL_NOME = "Nome"
        val COL_LIXEIRA = "Lixeira"
        val COL_COMPOSICAO = "Composicao"
        val COL_DECOMPOSICAO = "Decomposicao"
        val COL_INFORMACAO = "Informacao"
        val COL_EMPRESA = "Empresa"
        val COL_LOCAL_RECICLAR = "Local_Reciclar"

    }

    fun selecionarLista(s:String?):List<Materiais> {
        val listMateriais = ArrayList<Materiais>()
        val selectQuery = "SELECT * FROM $TABLE_NAME WHERE $COL_LIXEIRA = '$s'"
        val db = this.writableDatabase

        val cursor:Cursor = db.rawQuery(selectQuery,null)

        if (cursor.moveToFirst()){
                do{
                    val material = Materiais()
                    material.id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                    material.nome = cursor.getString(cursor.getColumnIndex(COL_NOME))
                    material.lixeira = cursor.getString(cursor.getColumnIndex(COL_LIXEIRA))
                    material.composicao = cursor.getString(cursor.getColumnIndex(COL_COMPOSICAO))
                    material.decomposicao = cursor.getString(cursor.getColumnIndex(COL_DECOMPOSICAO))
                    material.informacao = cursor.getString(cursor.getColumnIndex(COL_INFORMACAO))
                    material.empresa = cursor.getString(cursor.getColumnIndex(COL_EMPRESA))
                    material.localReciclar = cursor.getString(cursor.getColumnIndex(COL_LOCAL_RECICLAR))

                    listMateriais.add(material)
                }while (cursor.moveToNext())
        }

        return listMateriais

    }

        fun addMaterial(material:Materiais){

            val db:SQLiteDatabase = this.writableDatabase
            val values = ContentValues()

            values.put(COL_ID, material.id)
            values.put(COL_NOME, material.nome)
            values.put(COL_LIXEIRA, material.lixeira)
            values.put(COL_COMPOSICAO, material.composicao)
            values.put(COL_DECOMPOSICAO, material.decomposicao)
            values.put(COL_INFORMACAO, material.informacao)
            values.put(COL_EMPRESA, material.empresa)
            values.put(COL_LOCAL_RECICLAR, material.localReciclar)

            db.insert(TABLE_NAME, null, values)
            db.close()
        }






}