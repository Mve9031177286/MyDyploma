package com.maximvs.mydiploma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.maximvs.mydiploma.databinding.ActivityMainBinding
import android.widget.ScrollView
import com.maximvs.mydiploma.databinding.ActivityTwooBinding

class ActivityTwoo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTwooBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonDevelopments.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@ActivityTwoo, ActivityThree::class.java)
            startActivity(intent)
        })

        binding.buttonHome.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@ActivityTwoo, MainActivity::class.java)
            startActivity(intent)
        })
    }
}