package com.shevy.test

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shevy.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }

        title = "Emotional Face"
        supportActionBar?.setBackgroundDrawable(getDrawable(R.color.colorPrimary))

        binding.happyButton.setOnClickListener {
            binding.emotionalFaceView.happinessState = EmotionalFaceView.HAPPY
        }

        binding.sadButton.setOnClickListener{
            binding.emotionalFaceView.happinessState = EmotionalFaceView.SAD
        }
    }
}