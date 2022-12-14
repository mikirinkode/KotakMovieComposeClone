package com.mikirinkode.kotakmoviecompose.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mikirinkode.kotakmoviecompose.R
import com.mikirinkode.kotakmoviecompose.model.Movie
import com.mikirinkode.kotakmoviecompose.ui.components.MovieListComponent
import com.mikirinkode.kotakmoviecompose.ui.components.StateMessageComponent
import com.mikirinkode.kotakmoviecompose.ui.theme.KotakMovieComposeTheme

@Composable
fun MoviePlaylistScreen(
    modifier: Modifier = Modifier
) {
    val dummyList = listOf<Movie>()
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MoviePlaylistPreview() {
    KotakMovieComposeTheme {
        MoviePlaylistScreen()
    }
}