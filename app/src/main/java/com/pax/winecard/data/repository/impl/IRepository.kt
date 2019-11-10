package com.pax.winecard.data.repository.impl

import com.pax.winecard.data.network.Response
import com.pax.winecard.domain.models.Category
import com.pax.winecard.domain.models.FilterItem
import io.reactivex.Observable

interface IRepository {
    fun getCategories(): Observable<List<Category>>
    fun getFilterItem(
        categoryId: Int,
        filters: HashMap<String, String>
    ): Observable<Response<FilterItem>>
}


