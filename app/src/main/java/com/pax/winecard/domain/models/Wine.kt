package com.pax.winecard.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Wine(
    @field:SerializedName("price")
    var price: Double? = null,
    @field:SerializedName("description")
    var description: String? = null
) : Serializable, BaseModel()
