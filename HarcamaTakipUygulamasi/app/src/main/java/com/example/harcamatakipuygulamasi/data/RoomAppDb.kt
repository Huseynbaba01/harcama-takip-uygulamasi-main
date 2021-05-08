package com.example.harcamatakipuygulamasi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HarcamaEntity::class],version = 1)
abstract class RoomAppDb: RoomDatabase() {
    abstract fun harcamaDao():HarcamaDao?
    companion object{
        private var INSTANCE:RoomAppDb?=null

        fun getAppDatabase(context: Context):RoomAppDb?{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder<RoomAppDb>(
                        context.applicationContext, RoomAppDb::class.java,"AppDB"
                    ).allowMainThreadQueries().build()
            }
             return INSTANCE
        }
    }
}