package com.pax.winecard.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class BaseModel(
    @field:SerializedName("id")
    open var id: Int? = null,
    @field:SerializedName("name")
    open var name: String? = null
) : Serializable
