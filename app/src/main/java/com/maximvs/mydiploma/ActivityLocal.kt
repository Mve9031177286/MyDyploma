package com.maximvs.mydiploma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.maximvs.mydiploma.databinding.ActivityLocalBinding
import com.maximvs.mydiploma.databinding.ActivityMainBinding

class ActivityLocal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLocalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* val item = intent.getSerializableExtra("item") as Data
        binding.apply {
            val d: Int = item.image_id.toInt()
            imageViewLocal.setImageResource(d)
            textViewLocal1.text = item.title
            textViewLocal2.text = item.artist_display
        } */
    }
}


