package com.mikirinkode.kotakmoviecompose.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mikirinkode.kotakmoviecompose.model.DummyData
import com.mikirinkode.kotakmoviecompose.model.Movie
import com.mikirinkode.kotakmoviecompose.ui.components.EmptyPlaylistCard
import com.mikirinkode.kotakmoviecompose.ui.components.MovieListComponent
import com.mikirinkode.kotakmoviecompose.ui.theme.KotakMovieComposeTheme

@Composable
fun MoviePlaylistScreen(
    modifier: Modifier = Modifier
) {
    val dummyList = listOf<Movie>()
    if (dummyList.isNotEmpty()){
        MovieListComponent(list = dummyList)
    } else {
        EmptyPlaylistCard()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MoviePlaylistPreview() {
    KotakMovieComposeTheme {
        MoviePlaylistScreen()
    }
}