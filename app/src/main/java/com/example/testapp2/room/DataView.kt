package com.example.testapp2.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class DataView(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo (name = "title") val title: String?,
    @ColumnInfo (name = "detail") val detail: String?,
    @ColumnInfo (name = "imageId") val imageId: Int?,
    @ColumnInfo (name = "fullDescription") val fullDescription: String?
)
