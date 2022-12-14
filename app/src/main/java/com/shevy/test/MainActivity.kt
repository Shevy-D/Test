package com.shevy.test

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.shevy.test.databinding.ActivityMainBinding
import com.shevy.test.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val swipeControlTouchListener by lazy {
        SwipeControlTouchListener()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val colorList = listOf(Color.CYAN, Color.GREEN, Color.YELLOW)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, colorList)
        binding.viewPager.adapter = sectionsPagerAdapter

        // apply touch listener on ViewPager RecyclerView
        val recyclerView = binding.viewPager[0] as? RecyclerView
        if (recyclerView != null) {
            recyclerView.addOnItemTouchListener(swipeControlTouchListener)
        } else {
            Log.w(localClassName, "RecyclerView is null, Version changed ?!")
        }

        // finally hookup the radio group
        binding.swipeDirectionRg.setOnCheckedChangeListener { _, checkedId ->
            swipeControlTouchListener.setSwipeDirection(
                when (checkedId) {
                    R.id.allRb -> SwipeDirection.ALL
                    R.id.leftRb -> SwipeDirection.LEFT
                    R.id.rightRb -> SwipeDirection.RIGHT
                    R.id.noneRb -> SwipeDirection.NONE
                    else -> SwipeDirection.ALL
                }
            )
        }
    }
}