package com.example.testapp2.repository.localdatasource

import com.example.testapp2.room.DataView

interface LocalDataSource {
    fun setAll(listDataView: List<DataView>)

    fun getListEntities(): List<DataView>

    fun getDetailsEntity(id: Int): DataView

    fun deleteAllDataView()

}