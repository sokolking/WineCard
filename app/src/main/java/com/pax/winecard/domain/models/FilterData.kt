package com.pax.winecard.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FilterData(
    @field:SerializedName("qty")
    var qty: Int? = null
) : Serializable, BaseModel()
