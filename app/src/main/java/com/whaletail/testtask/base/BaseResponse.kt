package com.whaletail.testtask.base

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("isBase64Encoded")
    var isBase64Encoded: Boolean?,
    @SerializedName("body")
    var body: T?,
    @SerializedName("statusCode")
    var statusCode: String?,
    @SerializedName("headers")
    var headers: Headers?,
    @SerializedName("errorMessage")
    var errorMessage: String?
)

data class Headers(
    @SerializedName("Content-Type")
    var contentType: String?
)