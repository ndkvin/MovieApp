package com.android.newsapp.data.api

import com.android.newsapp.data.model.response.GetAllSeries
import com.android.newsapp.data.model.response.GetDetailSeries
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiSeriesInterface {

    @GET("/api/most-popular")
    suspend fun getAllSeries(): GetAllSeries

    @GET("/api/show-details")
    suspend fun getDetailSeries(
        @Query("q") id: Int = 0,
    ): GetDetailSeries

    @GET("/api/search")
    suspend fun searchSeries(
        @Query("q") keyword: String = "",
    ): GetAllSeries
}