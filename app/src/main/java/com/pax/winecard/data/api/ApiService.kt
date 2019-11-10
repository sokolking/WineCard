package com.pax.winecard.data.api

import com.pax.winecard.data.network.Response
import com.pax.winecard.domain.models.Category
import com.pax.winecard.domain.models.FilterItem
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {

    @GET("category/list")
    fun getCategories(): Observable<List<Category>>

    @GET("category/filter_values")
    fun getFilterItem(
        @Query("category_id") categoryId: Int,
        @QueryMap data: HashMap<String, String>
    ): Observable<Response<FilterItem>>
}
