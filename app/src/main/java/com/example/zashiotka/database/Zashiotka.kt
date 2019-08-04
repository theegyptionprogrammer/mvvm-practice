package com.example.zashiotka.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity (tableName = "Zashiotka")
data class Zashiotka(

     @PrimaryKey(autoGenerate = true)
     val idStudent : Int = 0,
     @ColumnInfo(name = "nameStudent")
     val nameStudent : String ,
     @ColumnInfo(name = "english")
     val english : Double ,
     @ColumnInfo(name = "informatics")
     val informatics : Double
)