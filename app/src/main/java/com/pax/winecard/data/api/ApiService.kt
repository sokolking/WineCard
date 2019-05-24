package com.pax.winecard.data.api

import io.reactivex.Observable
import retrofit2.http.POST

interface ApiService {

    @POST("post")
    fun post(): Observable<Any>
}
