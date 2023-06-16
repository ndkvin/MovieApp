package com.android.newsapp.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.newsapp.data.model.response.GetAllSeries
import com.android.newsapp.data.model.response.TvShowsItem
import com.android.newsapp.data.repository.SeriesRepository
import com.android.newsapp.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val seriesRepository: SeriesRepository,
) : ViewModel() {
    var loading = MutableStateFlow(false)
    var series = MutableStateFlow(listOf<TvShowsItem?>(null))

    init {
        getAllSeries()
    }

    fun getAllSeries() {
        viewModelScope.launch {
            loading.value = true
            val response = seriesRepository.getAllSeries()
            if (response is Result.Success) {
                 series.value  = response?.data?.tvShows!!
            }
            loading.value = false
        }
    }

    fun searchSeries(keyword: String) {
        viewModelScope.launch {
            loading.value = true
            val response = seriesRepository.searchSeries(keyword)
            if (response is Result.Success) {
                 series.value  = response?.data?.tvShows!!
            }
            loading.value = false
        }
    }


}