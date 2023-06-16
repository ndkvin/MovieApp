package com.android.newsapp.data.api

import com.android.newsapp.data.model.response.GetAllSeries
import com.android.newsapp.data.model.response.GetDetailSeries
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiSeriesInterface {

    @GET("/api/most-popular")
    suspend fun getAllSeries(
        @Query("q") keyword: String = "",
    ): GetAllSeries

    @GET("/api/show-details")
    suspend fun getDetailSeries(
        @Query("q") keyword: Int = 0,
    ): GetDetailSeries
}