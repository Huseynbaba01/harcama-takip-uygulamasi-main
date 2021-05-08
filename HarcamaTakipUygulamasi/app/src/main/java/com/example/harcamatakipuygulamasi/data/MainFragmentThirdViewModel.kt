package com.example.harcamatakipuygulamasi.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MainFragmentThirdViewModel(app:Application):AndroidViewModel(app) {
    lateinit var allHarcama:MutableLiveData<List<HarcamaEntity>>
    init {
        allHarcama = MutableLiveData()
    }
    fun getAllHarcamaObservers():MutableLiveData<List<HarcamaEntity>>{
        return allHarcama
    }
    fun getAllHarcama(){
        val harcamaDao = RoomAppDb.getAppDatabase(getApplication())?.harcamaDao()
        val list = harcamaDao?.getAllHarcamaInfo()
        allHarcama.postValue(list)
    }
    fun insertAllHarcamaInfoEntity(entity: HarcamaEntity){
        val harcamaDao = RoomAppDb.getAppDatabase((getApplication()))?.harcamaDao()
        harcamaDao?.insertHarcama(entity)
        getAllHarcama()
    }
    /*
    fun updateAllHarcamaInfoEntity(entity: HarcamaEntity){
        val harcamaDao = RoomAppDb.getAppDatabase((getApplication()))?.harcamaDao()
        harcamaDao?.updateHarcama(entity)
        getAllHarcama()
    }*/
    fun deleteAllHarcamaInfoEntity(entity: HarcamaEntity){
        val harcamaDao = RoomAppDb.getAppDatabase((getApplication()))?.harcamaDao()
        harcamaDao?.deleteHarcama(entity)
        getAllHarcama()
    }



}