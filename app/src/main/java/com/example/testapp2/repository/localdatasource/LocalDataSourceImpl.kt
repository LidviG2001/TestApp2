package com.example.testapp2.repository.localdatasource

import com.example.testapp2.room.DataView
import com.example.testapp2.room.DataViewDao
import com.example.testapp2.room.DataViewList

class LocalDataSourceImpl(private val dataViewDao: DataViewDao): LocalDataSource {

    override fun setAll(listDataView: List<DataView>) {
        dataViewDao.insertAll(listDataView)
    }

    override fun getListEntities(): List<DataViewList> {
        return dataViewDao.getAllEntitys().map{
            DataViewList(it.uid, it.title, it.detail, it.imageId)
        }
    }

    override fun getDetailsEntity(id: Int): DataView {
        return dataViewDao.getDetailsEntity(id)
    }

 /*   override fun getDataViewRoomList(): List<DataView> {
        return null
    }*/
}