package com.mikirinkode.kotakmoviecompose.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mikirinkode.kotakmoviecompose.model.Movie

@Composable
fun MovieListComponent(
    list: List<Movie>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) { movie ->
            MovieItem(
                imageUrl = movie.posterPath ?: "",
                title = movie.title ?: "",
                releaseDate = movie.releaseDate ?: "",
                rating = movie.voteAverage
            )
        }
    }
}