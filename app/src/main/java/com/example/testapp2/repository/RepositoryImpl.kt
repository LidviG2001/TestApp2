package com.example.testapp2.repository

import com.example.testapp2.repository.localdatasource.LocalDataSource
import com.example.testapp2.room.DataView

class RepositoryImpl(private val lds: LocalDataSource): Repository {
    override fun setAll(listDataView: List<DataView>) {
        lds.setAll(listDataView)
    }

    override fun getListEntities(): List<DataView> {
        return lds.getListEntities()
    }

    override fun getDetailsEntity(id: Int): DataView {
        return lds.getDetailsEntity(id)
    }

    override fun getDataViewRoom(): List<DataView> {
        return lds.getListEntities()
    }

    override fun deleteDataView() {
        lds.deleteAllDataView()
    }
}