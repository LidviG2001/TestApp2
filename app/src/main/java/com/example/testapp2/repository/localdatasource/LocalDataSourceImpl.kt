package com.example.testapp2.repository.localdatasource

import com.example.testapp2.room.DataView
import com.example.testapp2.room.DataViewDao

class LocalDataSourceImpl(private val dataViewDao: DataViewDao): LocalDataSource {

    override fun setAll(listDataView: List<DataView>) {
        dataViewDao.insertAll(listDataView)
    }

    override fun getListEntities(): List<DataView> {
        return dataViewDao.getAllEntitys().map{
            DataView(
                it.uid,
                it.title,
                it.detail,
                it.imageId,
                it.image2,
                it.mainTitle,
                it.firstDescription,
                it.secondTitle,
                it.secondDescription)
        }
    }

    override fun getDetailsEntity(id: Int): DataView {
        return dataViewDao.getDetailsEntity(id)
    }

    override fun deleteAllDataView() {
        dataViewDao.deleteAll()
    }

}