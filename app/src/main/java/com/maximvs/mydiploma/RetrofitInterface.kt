package com.maximvs.mydiploma

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// ретрофит п.2 Создаю интерфейс который определил один метод для получения списка юзеров,
   // этот метод возвращает в данном случае класс Call (специальный класс для отправки/получения
   // сообщения), который и будет содержать ответ UsersData. UsersData — класс, делаю его под ответ
interface RetrofitInterface {
    @GET("api/v1/artworks")
    fun getUsers(
       @Query("id") id: Int,
       @Query("title") title: String,
       @Query("date_start") date_start: Int,
       @Query("date_end") date_end: Int,
       @Query("artist_display") artist_display: String
    ): Call<UsersData>
}