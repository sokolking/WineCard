package com.pax.winecard.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Food(
    @field:SerializedName("description")
    var description: String? = null
) : Serializable, BaseModel()
