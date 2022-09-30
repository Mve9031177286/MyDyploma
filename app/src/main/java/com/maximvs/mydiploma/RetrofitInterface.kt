package com.maximvs.mydiploma

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// ретрофит п.2 Создаю интерфейс который определил один метод для получения списка юзеров,
   // этот метод возвращает в данном случае класс Call (специальный класс для отправки/получения
   // сообщения), который и будет содержать ответ UsersData. UsersData — класс, сделан под ответ

interface RetrofitInterface {
    @GET("api/v1/artworks?fields=id,title,artist_title,date_display,artist_display,image_id&limit=25&page=1")
    fun getUsers(): Call<UsersData>
}