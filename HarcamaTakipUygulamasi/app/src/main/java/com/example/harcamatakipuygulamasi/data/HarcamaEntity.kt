package com.example.harcamatakipuygulamasi.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "harcama_table")
data class HarcamaEntity (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo (name = "aciklama") val aciklama: String,
    @ColumnInfo(name = "kiymet") val kiymet: Double,
    @ColumnInfo(name = "type") val type: Int,
    @ColumnInfo(name = "currency") val currency:Int
    )