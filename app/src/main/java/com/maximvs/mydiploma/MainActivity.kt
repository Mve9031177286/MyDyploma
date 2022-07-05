package com.maximvs.mydiploma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.maximvs.mydiploma.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerViewStart.adapter = MyAdapter()

        // ретрофит п.1 Создаю базу для моего запроса (здесь - мин.набор: домен сервера и конвертер,
        // чтобы он под капотом парсил JSON-ответ.
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.artic.edu/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // ретрофит п.3 Сервис для запросов формируется вот так:
        val service = retrofit.create(RetrofitInterface::class.java)

       // ретрофит п.4 При помощи базового экземпляра Retrofit создаю из интерфейса (в котором я
        // перечислил все методы) объект, который будет отправлять запросы и получать ответы:
        service.getUsers(Int, String(),Int,Int,String()).enqueue(object : Callback<UsersData> {
            override fun onResponse(call: Call<UsersData>, response: Response<UsersData>) {
                println(response.body())
            }

            override fun onFailure(call: Call<UsersData>, t: Throwable) {
                t.printStackTrace()
            }
        })

        binding.btnDevelopment.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, ActivityThree::class.java)
            startActivity(intent)
        })

        binding.btnCollection.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, ActivityTwoo::class.java)
            startActivity(intent)
        })

    }
}

