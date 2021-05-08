package com.example.harcamatakipuygulamasi.data

import androidx.room.*

@Dao
interface HarcamaDao {

    @Query("SELECT * FROM harcama_table ORDER BY kiymet DESC")
    fun getAllHarcamaInfo():List<HarcamaEntity>

    @Insert
    fun insertHarcama(harcama: HarcamaEntity)

    @Delete
    fun deleteHarcama(harcama: HarcamaEntity)

    @Update
    fun updateHarcama(harcama: HarcamaEntity)
}