package com.shevy.test.exampledelegate.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shevy.test.R
import com.shevy.test.exampledelegate.MockDataFactory
import com.shevy.test.exampledelegate.adapters.CheckDelegateAdapter
import com.shevy.test.exampledelegate.adapters.ImageDelegateAdapter
import com.shevy.test.exampledelegate.adapters.TextDelegateAdapter
import com.shevy.test.exampledelegate.delegate.CompositeDelegateAdapter

class BaseExampleActivity : AppCompatActivity() {
    private lateinit var rv: RecyclerView

    private val adapter = CompositeDelegateAdapter(
        TextDelegateAdapter(),
        CheckDelegateAdapter(),
        ImageDelegateAdapter(/*findViewById(R.id.ll_root)*/)/*,
        GenerateItemsDelegateAdapter { generateNewData() }*/
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_example)

        rv = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
        adapter.swapData(MockDataFactory.prepareData())
    }

    fun onGenerateButtonClicked(@Suppress("UNUSED_PARAMETER") view: View?) {
        generateNewData()
    }

    private fun generateNewData() {
        adapter.swapData(MockDataFactory.prepareData())
        rv.scrollToPosition(0)
    }
}