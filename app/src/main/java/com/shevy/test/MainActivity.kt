package com.shevy.test

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.shevy.test.databinding.ActivityMainBinding
import com.shevy.test.services.MyService
import com.shevy.test.ui.main.Fragment1
import com.shevy.test.ui.main.Fragment2
import com.shevy.test.ui.main.Fragment3

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }

        binding.apply {
            btnStart.setOnClickListener {
                startService(Intent(this@MainActivity, MyService::class.java))
            }

            btnStop.setOnClickListener {
                stopService(Intent(this@MainActivity,MyService::class.java))
            }
        }
    }

}