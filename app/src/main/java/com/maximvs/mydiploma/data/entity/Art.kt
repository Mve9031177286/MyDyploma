package com.maximvs.mydiploma.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "art_table")
data class Art(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "art_image_id") val artImageId: String,
    @ColumnInfo(name = "art_title") val artTitle: String,
    @ColumnInfo(name = "art_artist_title") val artArtistTitle: String,
    @ColumnInfo(name = "art_date_start") val artDateStart: Int,
    @ColumnInfo(name = "art_date_end") val artDateEnd: Int,
    @ColumnInfo(name = "art_date_display") val artDateDisplay: String,
    @ColumnInfo(name = "art_artist_display") val artArtistDisplay: String
    )