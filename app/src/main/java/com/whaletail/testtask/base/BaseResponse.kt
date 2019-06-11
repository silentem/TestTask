package com.whaletail.testtask.base

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("isBase64Encoded")
    var isBase64Encoded: Boolean = false,
    @SerializedName("result")
    var result: T,
    @SerializedName("statusCode")
    var statusCode: String = "",
    @SerializedName("headers")
    var headers: Headers? = null
)

data class Headers(
    @SerializedName("Content-Type")
    var contentType: String?
)