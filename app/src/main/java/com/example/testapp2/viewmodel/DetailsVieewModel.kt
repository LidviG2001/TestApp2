package com.example.testapp2.viewmodel

import androidx.lifecycle.ViewModel
import com.example.testapp2.repository.Repository
import com.example.testapp2.room.DataView

class DetailsViewModel(private val repository: Repository): ViewModel() {

    fun getDetailsEntity(id: Int): DataView {
        return repository.getDetailsEntity(id)
    }

    fun setAllItems(list: List<DataView>){
        repository.setAll(list)
    }

    fun getDataRoom(): List<DataView>{
        return repository.getDataViewRoom()
    }

    fun getListEntities(): List<DataView>{
        return repository.getListEntities()
    }

    fun deleteDAtaView(){
        repository.deleteDataView()
    }
}