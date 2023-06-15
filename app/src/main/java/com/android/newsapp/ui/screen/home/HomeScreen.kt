package com.android.newsapp.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.android.newsapp.ui.navigation.Screen
import com.android.newsapp.ui.theme.black
import com.android.newsapp.ui.theme.grey
import com.android.newsapp.ui.theme.white

@Composable
fun HomeScreen(
    navController: NavController = rememberNavController(),
) {
    LazyColumn {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "News App",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Latest News",
                    color = grey,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = "See All",
                    color = grey,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }

        items(5) {
            Card(
                modifier = Modifier
                    .height(150.dp),
                colors = CardDefaults.cardColors(
                    containerColor = white,
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp)
                        .clickable {
                            navController.navigate(Screen.DetailScreen.route + "/$it")
                        },
                ) {
                    AsyncImage(
                        model = "https://www.simplilearn.com/ice9/free_resources_article_thumb/what_is_image_Processing.jpg",
                        contentDescription = "Image",
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(120.dp)
                            .clip(RoundedCornerShape(14.dp)),
                        contentScale = ContentScale.FillHeight
                    )
                    Spacer(modifier = Modifier.width(14.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start,

                    ) {
                        Text(
                            text = "CNBC",
                            color = grey,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 12.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "The 10 most important things in the world right now",
                            color = black,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 14.sp
                        )

                        Text(
                            text = "The 10 most important things in the world right now",
                            color = grey,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Light,
                            lineHeight = 12.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "20 April 2023",
                            color = grey,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 12.sp
                        )
                    }
                }

            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview()
@Composable
fun PreviewHomePage() {
    HomeScreen()
}