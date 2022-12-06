package com.shevy.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.shevy.test.databinding.ActivityMainBinding
import com.shevy.test.ui.main.Fragment1
import com.shevy.test.ui.main.Fragment2
import com.shevy.test.ui.main.Fragment3

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }

        binding.btn1.setOnClickListener {
            val f1 = Fragment1()
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.container, f1)
            ft.commit()
        }

        binding.btn2.setOnClickListener {
            val f2 = Fragment2()
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.container, f2)
            ft.commit()
        }

        binding.btn3.setOnClickListener {
            val f3 = Fragment3()
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.container, f3)
            ft.commit()
        }
    }

}