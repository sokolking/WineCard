package com.pax.winecard.domain.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Item(

    @field:SerializedName("id")
    val id: Int? = null,
    @field:SerializedName("name")
    val name: String? = null

) : Serializable {
    override fun toString(): String {
        return name!!
    }
}
