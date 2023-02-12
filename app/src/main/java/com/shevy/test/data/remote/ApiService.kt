package com.shevy.test.data.remote

import com.shevy.test.data.model.Post
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @POST("/posts")
    @FormUrlEncoded
    fun savePost(
        @Field("title") title: String,
        @Field("body") body: String,
        @Field("userId") userId: Long
    ): Call<Post>

    companion object {
        val BASE_URL = "http://jsonplaceholder.typicode.com/"
        fun getApiService(): ApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}