package com.example.zashiotka.roomDB

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity (tableName = "Zashiotka")
data class Zashiotka (
    @PrimaryKey(autoGenerate = true)
    val studentId : Int,
    @ColumnInfo(name = "student_name")
    val studentName : String,
    @ColumnInfo(name = "english_subject")
    val englishSubject: Double,
    @ColumnInfo(name = "informatics_subject")
    val informaticsSubject : Double
)