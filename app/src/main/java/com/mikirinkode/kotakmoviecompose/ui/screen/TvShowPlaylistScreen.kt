package com.mikirinkode.kotakmoviecompose.ui.screen

import androidx.compose.runtime.Composable
import com.mikirinkode.kotakmoviecompose.model.DummyData
import com.mikirinkode.kotakmoviecompose.ui.components.EmptyPlaylistCard
import com.mikirinkode.kotakmoviecompose.ui.components.MovieListComponent

@Composable
fun TvShowPlaylistScreen() {
    val dummyList = DummyData.getDummyMovieList()
    if (dummyList.isNotEmpty()){
        MovieListComponent(list = dummyList)
    } else {
        EmptyPlaylistCard()
    }
}