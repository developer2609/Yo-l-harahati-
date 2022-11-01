package com.example.yolqoidasiapp.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build.ID
import com.example.yolqoidasiapp.models.Belgi

class DbHelper(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION),
    MyIterface {

    companion object {

        const val DB_NAME = "yol_db"
        const val DB_VERSION = 1

        const val TABLE_NAME_OGOH = "table_ogohlantiruvchi"
        const val OGOH_ID = "id"
        const val OGOH_NAME = "name"
        const val OGOH_TEXT = "text"
        const val OGOH_IMAGE = "image_path"
        const val OGOH_LIKE = "likes"
        const val CATEGORY = "category"


    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query =
            "create table $TABLE_NAME_OGOH($OGOH_ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE ,$OGOH_NAME TEXT NOT NULL,$OGOH_TEXT TEXT NOT NULL ,$OGOH_IMAGE TEXT NOT NULL ,$OGOH_LIKE INTEGER  NOT NULL,$CATEGORY INTEGER NOT NULL)"
        db?.execSQL(query)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    override fun addQoida(belgi: Belgi) {

        val database = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(OGOH_NAME, belgi.name)
        contentValues.put(OGOH_TEXT, belgi.matn)
        contentValues.put(OGOH_IMAGE, belgi.imagePath)
        contentValues.put(OGOH_LIKE, belgi.like)
        contentValues.put(CATEGORY, belgi.category)
        database.insert(TABLE_NAME_OGOH, null, contentValues)
        database.close()

    }

    override fun getQoida(): ArrayList<Belgi> {

        val list = ArrayList<Belgi>()
        val query = "select * from $TABLE_NAME_OGOH"
        val database = this.readableDatabase
        val cursor = database.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val matni = cursor.getString(2)
                val imagePath = cursor.getString(3)
                val like = cursor.getInt(4)
                val category = cursor.getInt(5)
                val contact = Belgi(id, name, matni, imagePath, like, category)
                list.add(contact)
            } while (cursor.moveToNext())
        }
        return list
    }

    override fun deleteBelgi(belgi: Belgi) {

        val database = writableDatabase
        database.delete(TABLE_NAME_OGOH, "$OGOH_ID=?", arrayOf(belgi.id.toString()))
        database.close()
    }

    override fun editBelgi(belgi: Belgi) {

        val database =this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(OGOH_NAME, belgi.name)
        contentValues.put(OGOH_IMAGE, belgi.imagePath)
        contentValues.put(OGOH_TEXT, belgi.matn)
        contentValues.put(OGOH_LIKE, belgi.like)
        contentValues.put(CATEGORY, belgi.category)

        database.update(TABLE_NAME_OGOH, contentValues, "$OGOH_ID=?", arrayOf(belgi.id.toString()))
        database.close()
    }


