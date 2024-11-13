package com.example.boardingapp.ViewModel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.boardingapp.R
import com.example.boardingapp.data.PageData
import com.example.boardingapp.dataStore.StoreBoarding
import com.example.boardingapp.onBoardViews.OnBoardPages
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class )
@Composable
fun MainViewBoarding(navController: NavController,store:StoreBoarding){
    val items=ArrayList<PageData>()

    items.add(PageData(R.raw.welcome,"Bienvenidos","Bienvenidos a la aplicacion para mostrar el uso de"))
    items.add(PageData(R.raw.mid,"Uso de onboarding","Esta es la segunda pagina dle boarding mostrando una descripcion"))
    items.add(PageData(R.raw.done,"Fin de boarding","Esta es la pagina final del boarding y ya debe aparecer e boton"))

    val pagerState= rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop =  false,
        initialPage = 0
    )
    OnBoardPages(
        item = items, pagerState = pagerState, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                Color.White
            ),navController,store
    )
}

