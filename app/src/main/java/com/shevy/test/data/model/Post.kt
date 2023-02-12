package com.shevy.test.data.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String,
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int
) {
    override fun toString(): String {
        return "Post{title=$title\", body=$body\", userId=$userId, id=$id}"
    }
}

