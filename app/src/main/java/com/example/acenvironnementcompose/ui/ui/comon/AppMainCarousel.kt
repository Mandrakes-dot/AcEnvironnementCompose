package com.example.acenvironnementcompose.ui.ui.comon

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppMainCarousel(
    titleCardDevis:String,
    titleCardArchives: String,
    titleCardModifyUser: String,
    titleCardAddClient: String,
    onClickGoToCreateDevis:()->Unit,
    onClickGoToArchives:()->Unit,
    onClickModifyUser:()->Unit,
    onClickGoToAddClient:()->Unit,
    iconDevis: ImageVector,
    iconArchives:ImageVector,
    iconModifyUser:ImageVector,
    iconAddClient: ImageVector
){
    val itemsList = listOf(
        Triple(titleCardDevis,  onClickGoToCreateDevis,iconDevis),
        Triple(titleCardArchives,  onClickGoToArchives,iconArchives),
        Triple(titleCardModifyUser,  onClickModifyUser,iconModifyUser),
        Triple(titleCardAddClient, onClickGoToAddClient,iconAddClient)
    )


    val infiniteList = List(100) { itemsList[it % itemsList.size] }

    val state = rememberLazyListState()

    LaunchedEffect(Unit) {
        state.animateScrollToItem(infiniteList.size / 2)
    }

    LazyRow (
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        state = state,
        flingBehavior = rememberSnapFlingBehavior(lazyListState = state)
        ) {
        items(infiniteList){ item ->
            AppOutlinedCard(
                onClick = item.second,
                textContent = item.first,
                icon = item.third
            )
        }
    }
}