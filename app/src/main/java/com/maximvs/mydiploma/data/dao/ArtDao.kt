package com.maximvs.mydiploma.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.maximvs.mydiploma.data.entity.Art

@Dao
interface ArtDao {
    @Query("SELECT * FROM art_table")
    fun getAll(): List<Art>

    @Insert
    fun insertAll(arts: List<Art>)
}