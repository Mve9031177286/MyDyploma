package com.maximvs.mydiploma

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.maximvs.mydiploma.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity: AppCompatActivity(), ArtAdapter.Listener {

    private lateinit var artAdapter: ArtAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        artAdapter = ArtAdapter(this)

        // Функция with позволяет выполнить несколько операций над одним объектом, не повторяя его имени.
        with(binding.recyclerViewStart) {
            adapter = artAdapter
            // itemAnimator = MyItemAnimator(applicationContext)
            addItemDecoration(TopSpacingItemDecoration(5))  //Применяю декоратор для отступов
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
                println("Ответ ${response.body()}")
                val result = response.body() as? UsersData
                result?.data?.let { artAdapter?.addData(result.data) } // С ?.let все довольно просто.
                // Если результат body() не null то выполнится код в фигурных скобках. It уже будет
                // тем, что body вернул, то есть в нашем случае это UserData
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

    override fun onClick(artist: Data) {
           val bundle = Bundle()
           bundle.putString("b1", artist.image_id)
           bundle.putString("b2", artist.title)
           bundle.putString("b3", artist.artist_title)
           bundle.putString("b4", artist.date_display)
           bundle.putString("b5", artist.artist_display)

           val intent = Intent(this, ActivityLocal::class.java)
           intent.putExtra("bundle", bundle)
           startActivity(intent)
    }
}

