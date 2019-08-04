package com.example.zashiotka.database


import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Zashiotka::class], version =  1)

abstract class ZashiotkaDatabase : RoomDatabase() {

    abstract fun zashiotkaDao() : ZashiotkaDao

    companion object{
        private var Insance : ZashiotkaDatabase?= null

        fun getInsance(context: Context) : ZashiotkaDatabase? {
            if (Insance == null){
                synchronized(ZashiotkaDatabase::class){
                    Insance = Room.databaseBuilder(context.applicationContext , ZashiotkaDatabase::class.java , "Zashiotka.db")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
            }
                return Insance
        }
    }
}