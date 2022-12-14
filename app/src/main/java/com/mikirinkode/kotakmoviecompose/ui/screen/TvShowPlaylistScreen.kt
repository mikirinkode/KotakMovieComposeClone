package com.mikirinkode.kotakmoviecompose.ui.screen

import androidx.compose.runtime.Composable
import com.mikirinkode.kotakmoviecompose.R
import com.mikirinkode.kotakmoviecompose.model.DummyData
import com.mikirinkode.kotakmoviecompose.ui.components.MovieListComponent
import com.mikirinkode.kotakmoviecompose.ui.components.StateMessageComponent

@Composable
fun TvShowPlaylistScreen() {
    val dummyList = DummyData.getDummyMovieList()
    if (dummyList.isNotEmpty()){
        MovieListComponent(list = dummyList)
    } else {
        StateMessageComponent(
            drawableId = R.drawable.empty_playlist_illustration,
            drawableDesc = R.string.empty_playlist_illustration,
            imageWidth = 200,
            imageHeight = 250,
            titleStringId = R.string.empty_playlist_title,
            descriptionStringId = R.string.empty_playlist_description
        )
    }
}