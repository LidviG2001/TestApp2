package com.example.testapp2.di

import androidx.room.Room.databaseBuilder
import com.example.testapp2.repository.localdatasource.LocalDataSource
import com.example.testapp2.repository.localdatasource.LocalDataSourceImpl
import com.example.testapp2.repository.Repository
import com.example.testapp2.repository.RepositoryImpl
import com.example.testapp2.room.AppDatabase
import com.example.testapp2.room.DataViewDao
import com.example.testapp2.viewmodel.DetailsViewModel
import com.example.testapp2.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule : org.koin.core.module.Module = module{

    viewModel{
        MainViewModel(get())
    }

    viewModel{
        DetailsViewModel(get())
    }

    single{
       AppDatabase.getDatabase(get())
    }

    single<DataViewDao>{
        (get() as AppDatabase).dataViewDao()
    }

    factory<Repository> {
        RepositoryImpl(get())
    }

    factory<LocalDataSource> {
        LocalDataSourceImpl(get())
    }
}