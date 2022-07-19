package com.maximvs.mydiploma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.init
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

        binding.recyclerViewStart.apply {

                //Присваиваю адаптер
            binding.recyclerViewStart.adapter = ArtAdapter()

                //Применяю декоратор для отступов
            val decorator = TopSpacingItemDecoration(5)
            addItemDecoration(decorator)
        }

        // ретрофит п.1 Создаю базу для моего запроса (здесь - мин.набор: домен сервера и конвертер,
        // чтобы он под капотом парсил JSON-ответ.
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // ретрофит п.3 Сервис для запросов формируется вот так:
        val service = retrofit.create(RetrofitInterface::class.java)

       // ретрофит п.4 При помощи базового экземпляра Retrofit создаю из интерфейса (в котором я
        // перечислил все методы) объект, который будет отправлять запросы и получать ответы:
        service.getUsers().enqueue(object : Callback<UsersData> {
            override fun onResponse(call: Call<UsersData>, response: Response<UsersData>) {
                println(response.body())
            }

            override fun onFailure(call: Call<UsersData>, t: Throwable) {
                t.printStackTrace()
            }
        })

        binding.topAppBar.setNavigationOnClickListener {
            Toast.makeText(this, "Когда-нибудь здесь будет навигация...", Toast.LENGTH_SHORT).show()
        }

        binding.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.fav -> {
                    val intent = Intent(this@MainActivity, ActivityFavour::class.java)
                    startActivity(intent)
                    true
                }
                R.id.search -> {
                    Toast.makeText(this, "Поиск", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.more -> {
                    Toast.makeText(this, "Еще", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

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

