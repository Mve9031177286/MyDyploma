package com.maximvs.mydiploma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.maximvs.mydiploma.databinding.ActivityFavourBinding

class ActivityFavour : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFavourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageButtonFavour.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@ActivityFavour, MainActivity::class.java)
            startActivity(intent)
        })
    }
}