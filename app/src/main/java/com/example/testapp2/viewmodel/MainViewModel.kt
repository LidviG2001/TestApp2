package com.example.testapp2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp2.repository.Repository
import com.example.testapp2.room.DataView
import com.example.testapp2.room.DataViewList

class MainViewModel(private val repository: Repository): ViewModel() {
    private val _data : MutableLiveData<DataView> = MutableLiveData()
    val data : LiveData<DataView> get() = _data

    fun setAllItems(list: List<DataView>){
        repository.setAll(list)
    }

    fun getDataRoom(): List<DataView>{
        return repository.getDataViewRoom()
    }

    fun getListEntities(): List<DataViewList>{
        return repository.getListEntities()
    }

}