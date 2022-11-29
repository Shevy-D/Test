package com.shevy.test.exampledelegate.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shevy.test.R
import com.shevy.test.exampledelegate.adapters.ImageDelegateAdapter
import com.shevy.test.exampledelegate.adapters.TextDelegateAdapter
import com.shevy.test.exampledelegate.delegate.CompositeDelegateAdapter

class AdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter)

        startActivity(Intent(this, BaseExampleActivity::class.java))
    }
}