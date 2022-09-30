package com.maximvs.mydiploma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.datatransport.runtime.util.PriorityMapping.toInt
import com.maximvs.mydiploma.databinding.ActivityLocalBinding

class ActivityLocal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLocalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras?.getBundle("bundle")

        if (bundle != null) {
            binding.textViewLocal1.text = bundle.getString("b2").toString()
            binding.textViewLocal2.text = bundle.getString("b3").toString()
            binding.textViewLocal3.text = bundle.getString("b4").toString()
            binding.textViewLocal4.text = bundle.getString("b5").toString()
        }

        fun image () {
            Glide
                .with(this) //передается контекст из айтемвью
                .load("${ApiConstants.BASE_URL_API}/${bundle?.getString("b1").toString()}${ApiConstants.URL_CONFIG}") //Указываем, что будем загружать
                //.centerCrop() //Масштабируем с учетом пропорций и отрезаем все, что не влезло
                .placeholder(R.drawable.ic_round_loop_24)//Картинка, которая будет отображаться, пока картинка не загрузится
                .error(R.drawable.ic_round_mobiledata_off_24)//Картинка, которая будет показана в случае ошибки загрузки
                .into(binding.imageViewLocal) //Указываем, куда будем загружать
        }

        image()

    }
}

private fun ImageView.setImageResource() {

}


