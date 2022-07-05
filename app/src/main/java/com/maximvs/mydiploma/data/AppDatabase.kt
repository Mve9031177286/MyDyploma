package com.maximvs.mydiploma.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.maximvs.mydiploma.data.dao.ArtDao
import com.maximvs.mydiploma.data.entity.Art

@Database(entities = [Art::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun catDao(): ArtDao
}