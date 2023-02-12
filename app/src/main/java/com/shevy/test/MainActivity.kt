package com.shevy.test

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.shevy.test.data.model.Post
import com.shevy.test.data.remote.ApiService
import com.shevy.test.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.*


class MainActivity : AppCompatActivity() {

    private lateinit var mResponseTv: TextView
    private lateinit var mApiService: ApiService

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }

        val titleEt = binding.etTitle
        val bodyEt = binding.etBody
        val submitBtn: Button = binding.btnSubmit
        mResponseTv = binding.tvResponse

        mApiService = ApiService.getApiService()

        submitBtn.setOnClickListener {
            val title = titleEt.text.toString().trim { it <= ' ' }
            val body = bodyEt.text.toString().trim { it <= ' ' }
            if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)) {
                sendPost(title, body)
            }
        }
    }

    private fun sendPost(title: String, body: String) {
        mApiService.savePost(title, body, 1).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    showResponse(response.body().toString());
                    Log.i("TestTAG", "post submitted to API." + response.body().toString())
                }
            }
            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.i("TestTAG", "Unable to submit post to API.")
            }
        })
    }

    fun showResponse(response: String?) {
        if (mResponseTv.visibility == View.GONE) {
            mResponseTv.visibility = View.VISIBLE
        }
        mResponseTv.text = response
    }


}