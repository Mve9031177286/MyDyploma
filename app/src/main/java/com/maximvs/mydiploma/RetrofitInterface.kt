package com.maximvs.mydiploma

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("api/v1/artworks")
    fun getUsers(): Call<UsersData>
}