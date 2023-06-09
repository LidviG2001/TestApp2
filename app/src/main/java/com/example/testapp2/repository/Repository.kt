package com.example.testapp2.repository

import com.example.testapp2.room.DataView
import com.example.testapp2.room.DataViewList

interface Repository {

    fun setAll(listDataView: List<DataView>)

    fun getListEntities(): List<DataViewList>

    fun getDetailsEntity(id: Int): DataView

    fun getDataViewRoom(): List<DataView>

}