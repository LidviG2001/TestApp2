package com.example.testapp2.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataViewDao {

    @Query("SELECT * FROM data")
    fun getAllEntitys(): List<DataView>

    @Query("SELECT * FROM data WHERE uid LIKE :id")
    fun getDetailsEntity(id : Int): DataView

    @Insert
    fun insertAll( data: List<DataView>)

    @Query("DELETE FROM data")
    fun deleteAll()
}