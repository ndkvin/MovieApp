package com.android.newsapp.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.newsapp.data.model.response.GetDetailSeries
import com.android.newsapp.data.repository.SeriesRepository
import com.android.newsapp.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val seriesRepository: SeriesRepository,
) : ViewModel() {
    var loading = MutableStateFlow(false)
    var series = MutableStateFlow<Result<GetDetailSeries>>(Result.Empty)
    var seriesData = MutableStateFlow<GetDetailSeries?>(null)

    fun getDetailSeries(id: Int) {
        viewModelScope.launch {
            loading.value = true
            val response = seriesRepository.getDetailSeries(id)
            series.value = response

            if (response is Result.Success) {
                seriesData.value = response.data
            }
            loading.value = false
        }
    }
}