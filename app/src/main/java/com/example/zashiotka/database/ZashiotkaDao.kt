package com.example.zashiotka.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ZashiotkaDao {

    @Insert
    fun insert(vararg zashiotka: Zashiotka)

    @Query("SELECT * FROM Zashiotka")
    fun getAll() : ArrayList<Zashiotka>

    @Query("SELECT * FROM Zashiotka WHERE idStudent = idStudent")
    fun search(idStudent : Int)

    @Query("DELETE FROM Zashiotka")
    fun deleteAll()
}