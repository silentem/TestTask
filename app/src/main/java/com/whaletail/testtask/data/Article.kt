package com.whaletail.testtask.data

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Article(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: Long?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("content")
    var content: String?,
    @SerializedName("content_type")
    var contentType: String?,
    @SerializedName("content_url")
    var contentUrl: String?,
    @SerializedName("img_url")
    var imgUrl: String?,
    @SerializedName("language")
    var language: String?,
    @SerializedName("date_created")
    var dateCreated: Long?,
    @SerializedName("status")
    var status: String?,
    @SerializedName("content_formatted")
    var contentFormatted: String?
)