package com.example.testapp2.viewmodel

import androidx.lifecycle.ViewModel
import com.example.testapp2.repository.Repository
import com.example.testapp2.room.DataView

class DetailsViewModel(private val repository: Repository): ViewModel() {

    fun getDetailsEntity(id: Int): DataView {
        return repository.getDetailsEntity(id)
    }
}