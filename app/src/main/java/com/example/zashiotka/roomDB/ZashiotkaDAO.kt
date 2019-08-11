package com.example.zashiotka.roomDB

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ZashiotkaDAO {

    @Insert
    fun insertZashiotka(zashiotka: Zashiotka)

    @Query("SELECT * FROM Zashiotka")
    fun getAllZashiotkas() : MutableList<Zashiotka>


}