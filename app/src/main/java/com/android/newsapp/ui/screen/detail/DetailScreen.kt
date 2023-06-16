package com.android.newsapp.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.android.newsapp.R
import com.android.newsapp.data.model.response.GetDetailSeries
import com.android.newsapp.ui.theme.black
import com.android.newsapp.ui.theme.grey
import com.android.newsapp.ui.theme.white
import com.android.newsapp.util.Result

@Composable
fun DetailScreen(
    navController: NavController = rememberNavController(),
    id: Int? = null,
    detailViewModel : DetailViewModel = hiltViewModel()
) {
    var loading = detailViewModel.loading.collectAsState().value

    var series  = detailViewModel.series.collectAsState().value;
    var seriesData = detailViewModel.seriesData.collectAsState().value;

    when (series) {
        is Result.Empty -> {
            detailViewModel.getDetailSeries(id ?: 0)
        }

        is Result.Error -> {
            detailViewModel.getDetailSeries(id ?: 0)
        }

        else -> {

        }

    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Row(
                modifier = Modifier
                    .padding(start = 5.dp, top = 15.dp)
                    .clickable {
                        navController.popBackStack()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.back
                    ),
                    modifier = Modifier
                        .height(18.dp),
                    contentDescription = "Back Button"
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Detail Screen",
                    color = black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = white,
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp),
                ) {
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = seriesData?.tvShow?.genres?.get(0) ?: "",
                        color = grey,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = seriesData?.tvShow?.name ?: "",
                        color = black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    AsyncImage(
                        model = seriesData?.tvShow?.imageThumbnailPath ?: "",
                        contentDescription = "Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .clip(RoundedCornerShape(14.dp)),
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text =  seriesData?.tvShow?.description ?: "",
                        color = grey,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}