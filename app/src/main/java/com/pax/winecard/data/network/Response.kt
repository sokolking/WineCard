package com.pax.winecard.data.network

import com.google.gson.annotations.SerializedName

open class Response<out T>(

    @SerializedName("response")
    val data: T? = null
)
