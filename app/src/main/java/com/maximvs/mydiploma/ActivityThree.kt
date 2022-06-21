package com.maximvs.mydiploma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.maximvs.mydiploma.databinding.ActivityMainBinding
import com.maximvs.mydiploma.databinding.ActivityThreeBinding

class ActivityThree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonDevelopments.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@ActivityThree, ActivityTwoo::class.java)
            startActivity(intent)
        })

        binding.buttonHome.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@ActivityThree, MainActivity::class.java)
            startActivity(intent)
        })
    }
}