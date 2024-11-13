package com.example.boardingapp.onBoardViews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.boardingapp.data.PageData
import com.example.boardingapp.dataStore.StoreBoarding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardPages(
    item:List<PageData>,
    pagerState:PagerState,
    modifier: Modifier=Modifier,
    navController: NavController,
    store:StoreBoarding
){
    Box (modifier = Modifier){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .padding(60.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    loaderData(
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        item[page].image
                    )

                    Text(
                        text = item[page].description,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }
            PagerIndicator(item.size, pagerState.currentPage)
        }
        Box (modifier = Modifier.align(Alignment.BottomCenter)){
            ButtonFinish(currentPage = pagerState.currentPage,navController,store)
        }
    }
}