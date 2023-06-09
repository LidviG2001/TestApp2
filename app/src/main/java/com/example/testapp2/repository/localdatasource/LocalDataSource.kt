package com.example.testapp2.repository.localdatasource

import com.example.testapp2.room.DataView
import com.example.testapp2.room.DataViewList

interface LocalDataSource {
    fun setAll(listDataView: List<DataView>)

    fun getListEntities(): List<DataViewList>

    fun getDetailsEntity(id: Int): DataView

//    fun getDataViewRoomList(): List<DataView>
}