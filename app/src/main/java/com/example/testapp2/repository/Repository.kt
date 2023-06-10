package com.example.testapp2.repository

import com.example.testapp2.room.DataView

interface Repository {

    fun setAll(listDataView: List<DataView>)

    fun getListEntities(): List<DataView>

    fun getDetailsEntity(id: Int): DataView

    fun getDataViewRoom(): List<DataView>

    fun deleteDataView()

}