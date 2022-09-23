package com.example.hw14roombottomnavigation

import android.app.Application
import android.content.Context
import androidx.room.Room

class DBApplication : Application() {

    private var _appDB: AppDatabase? = null
    private val appDB get() = requireNotNull(_appDB)

    override fun onCreate() {
        super.onCreate()
        _appDB = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                "pet-database"
            )
            .allowMainThreadQueries()
            .build()
    }

    val Context.appDatabase: AppDatabase
    get() = when (this) {
        is DBApplication -> appDB
        else -> applicationContext.appDatabase
    }
}