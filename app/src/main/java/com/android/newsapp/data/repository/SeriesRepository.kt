package com.android.newsapp.data.repository

import com.android.newsapp.data.api.ApiSeriesInterface
import com.android.newsapp.data.model.response.GetAllSeries
import com.android.newsapp.data.model.response.GetDetailSeries
import javax.inject.Inject
import com.android.newsapp.util.Result

class SeriesRepository @Inject constructor(
    private val apiSeriesInterface: ApiSeriesInterface
) {
    suspend fun getAllSeries() : Result<GetAllSeries> {
        return try {
            return Result.Success(apiSeriesInterface.getAllSeries())
        } catch (e : Exception) {
            return Result.Error(e.message.toString())
        }
    }

    suspend fun getDetailSeries(id : Int) : Result<GetDetailSeries> {
        return try {
            return Result.Success(apiSeriesInterface.getDetailSeries(id))
        } catch (e : Exception) {
            return Result.Error(e.message.toString())
        }
    }

    suspend fun searchSeries(keyword : String = "") : Result<GetAllSeries> {
        return try {
            return Result.Success(apiSeriesInterface.searchSeries(keyword.lowercase()))
        } catch (e : Exception) {
            return Result.Error(e.message.toString())
        }
    }
}