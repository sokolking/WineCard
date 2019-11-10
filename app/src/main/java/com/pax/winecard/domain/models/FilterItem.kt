package com.pax.winecard.domain.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FilterItem(

    @SerializedName(value = "code")
    @Expose
    val code: String? = null,

    @SerializedName(value = "data")
    @Expose
    val filterData: List<FilterData>? = null

) : Serializable
