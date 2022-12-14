package com.mikirinkode.kotakmoviecompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mikirinkode.kotakmoviecompose.R
import com.mikirinkode.kotakmoviecompose.model.DummyData
import com.mikirinkode.kotakmoviecompose.model.Movie
import com.mikirinkode.kotakmoviecompose.ui.components.CompactMovieItem
import com.mikirinkode.kotakmoviecompose.ui.components.TrendingMovieItem
import com.mikirinkode.kotakmoviecompose.ui.theme.KotakMovieComposeTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit
) {
    val movieList = DummyData.getDummyMovieList()
    val tvList = DummyData.getDummyTvShowList()
    HomeContent(
        movieList,
        movieList,
        tvList,
        navigateToDetail
    )
}

@Composable
fun HomeContent(
    trendingList: List<Movie>,
    upcomingMovieList: List<Movie>,
    topRatedTvList: List<Movie>,
    navigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.menu_home))
                },
                backgroundColor = MaterialTheme.colors.secondaryVariant
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier.padding(innerPadding)
        ) {
            item {
                SectionTitle(title = stringResource(R.string.trending_this_week))
                LazyRow(
                    modifier = Modifier,
                    contentPadding = PaddingValues(end = 16.dp)
                ) {
                    items(trendingList) { movie ->
                        TrendingMovieItem(
                            imageUrl = movie.backdropPath ?: "",
                            title = movie.title ?: "",
                            rating = movie.voteAverage,
                            onClick = {
                                navigateToDetail(movie.id)
                            }
                        )
                    }
                }

                SectionTitle(title = stringResource(R.string.upcoming_movies))
                LazyRow(
                    modifier = Modifier,
                    contentPadding = PaddingValues(end = 16.dp)
                ) {
                    items(upcomingMovieList) { movie ->
                        CompactMovieItem(
                            imageUrl = movie.posterPath ?: "",
                            rating = movie.voteAverage
                        )
                    }
                }

                SectionTitle(title = stringResource(R.string.top_rated_tv_shows))
                LazyRow(
                    modifier = Modifier,
                    contentPadding = PaddingValues(end = 16.dp)
                ) {
                    items(topRatedTvList) { movie ->
                        CompactMovieItem(
                            imageUrl = movie.posterPath ?: "",
                            rating = movie.voteAverage
                        )
                    }
                }
            }
        }
    }

}

@Composable
fun SectionTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        fontSize = 16.sp,
        color = Color.White,
        modifier = modifier
            .padding(start = 16.dp, top = 16.dp)
    )
}

@Preview(showSystemUi = true, showBackground = true, backgroundColor = 0xFF0E1621)
@Composable
fun HomeScreenPreview() {
    KotakMovieComposeTheme {
        HomeScreen(navigateToDetail = {})
    }
}