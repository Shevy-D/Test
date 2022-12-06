package com.shevy.test.exampledelegate.activities

import android.os.Bundle
import android.util.Log
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
    private val TAG = "LifecycleTest"

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

        Log.i(TAG, "onCreate()")
    }

    override fun finish() {
        super.finish()
        Log.i(TAG, "finish()")
    }

    fun onGenerateButtonClicked(@Suppress("UNUSED_PARAMETER") view: View?) {
        generateNewData()
    }

    private fun generateNewData() {
        adapter.swapData(MockDataFactory.prepareData())
        rv.scrollToPosition(0)
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy()")
    }
}