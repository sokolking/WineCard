package com.pax.winecard.data.repository.impl

import io.reactivex.Observable

interface IRepository {
    fun post(): Observable<Any>
}


