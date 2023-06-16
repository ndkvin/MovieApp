package com.android.newsapp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.newsapp.ui.theme.black
import com.android.newsapp.ui.theme.orange
import com.android.newsapp.ui.theme.white

data class CategoryData(
    val id: Int,
    val label: String,
    val value: String,
    val isActive: Boolean
)

val ListCategoryData = listOf(
    CategoryData(
        id = 0,
        label = "Art",
        value = "art",
        isActive = false
    ),
    CategoryData(
        id = 1,
        label = "Entertain",
        value = "entertainment",
        isActive = false
    ),
    CategoryData(
        id = 2,
        label = "Sightings",
        value = "sightings",
        isActive = false
    ),
    CategoryData(
        id = 3,
        label = "Food",
        value = "food",
        isActive = false
    ),
    CategoryData(
        id = 4,
        label = "Shopping",
        value = "shopping",
        isActive = false
    ),
)

@Composable
fun CategoryCard(
    categoryData: CategoryData = CategoryData(
        id = 0,
        label = "Art",
        value = "art",
        isActive = true
    ),
    onClick : (Int) -> Unit,
) {
    Card(
        modifier = Modifier
            .height(40.dp)
            .clickable {
                onClick(categoryData.id)
            },
        colors = if (categoryData.isActive) CardDefaults.cardColors(
            containerColor = orange,
        ) else CardDefaults.cardColors(
            containerColor = white,
        ),
        shape = RoundedCornerShape(18.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = categoryData.label,
                color = if (categoryData.isActive) white else black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun CategoryCardPreview() {
    CategoryCard(
        categoryData = CategoryData(
            id = 0,
            label = "Art",
            value = "art",
            isActive = true
        ),
        onClick = { _ -> }
    )
}
