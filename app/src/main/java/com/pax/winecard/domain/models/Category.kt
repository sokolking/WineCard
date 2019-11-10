package com.pax.winecard.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Category(
    @field:SerializedName("category")
    val category: String? = null
) : Serializable, BaseModel()
