package com.example.zashiotka.roomDB

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Zashiotka::class] , version = 1)
abstract class ZashiotkaDatabase : RoomDatabase(){

    abstract fun zashiotkaDao() : ZashiotkaDAO

    companion object{
        private  var instance : ZashiotkaDatabase ?= null

        fun getInstance(context: Context) : ZashiotkaDatabase? {
            if (instance == null){
                synchronized(ZashiotkaDatabase::class){
                    instance = Room.databaseBuilder(context.applicationContext , ZashiotkaDatabase::class.java , "zashiotkaDB")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance
        }
    }
}