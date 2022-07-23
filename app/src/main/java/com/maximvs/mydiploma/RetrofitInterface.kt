package com.maximvs.mydiploma

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// ретрофит п.2 Создаю интерфейс который определил один метод для получения списка юзеров,
   // этот метод возвращает в данном случае класс Call (специальный класс для отправки/получения
   // сообщения), который и будет содержать ответ UsersData. UsersData — класс, делаю его под ответ
interface RetrofitInterface {
    @GET("api/v1/artworks")
    fun getUsers(): Call<UsersData>
}