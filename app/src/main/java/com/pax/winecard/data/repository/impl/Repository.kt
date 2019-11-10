package com.pax.winecard.data.repository.impl

import com.pax.winecard.app.App
import com.pax.winecard.data.api.ApiService
import com.pax.winecard.data.network.Response
import com.pax.winecard.domain.Constants
import com.pax.winecard.domain.Session
import com.pax.winecard.domain.models.Category
import com.pax.winecard.domain.models.FilterItem
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class Repository : IRepository {

    private val apiService: ApiService

    @Inject
    lateinit var session: Session

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        App.logis.inject(this)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.API_URL)
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    override fun getCategories(): Observable<List<Category>> {
        return apiService.getCategories()
    }

    override fun getFilterItem(
        categoryId: Int,
        filters: HashMap<String, String>
    ): Observable<Response<FilterItem>> {
        return apiService.getFilterItem(categoryId, filters)
    }
}
