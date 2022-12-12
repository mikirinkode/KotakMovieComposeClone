package com.mikirinkode.kotakmoviecompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
) {
    val dummyList = DummyData.getDummyMovieList()
    HomeContent(
        dummyList,
        dummyList,
        dummyList,
    )
}

@Composable
fun HomeContent(
    trendingList: List<Movie>,
    upcomingMovieList: List<Movie>,
    topRatedTvList: List<Movie>,
    modifier: Modifier = Modifier
) {
    val testList = listOf<String>(
        "Lorem Ipsum Sir Dolor Amet apakah bisa lebih panjang",
        "Lorem Ipsum",
        "Lorem Ipsum",
        "Lorem Ipsum",
    )
    Column(
        modifier = modifier
    ) {
        LazyRow(){
            items(testList) {item ->
                Card(
                    backgroundColor = MaterialTheme.colors.secondaryVariant,
                    shape = RoundedCornerShape(16f),
                    modifier = modifier
                        .padding(top = 16.dp, start = 16.dp)
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = modifier.fillMaxWidth()
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.poster_alita),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = modifier
                                .size(width = 320.dp, height = 180.dp)
                                .aspectRatio(16f / 9f)
                        )

                        Row(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .width(320.dp)
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = item,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 8.dp)
                            )
                            Row(
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Star,
                                    contentDescription = stringResource(R.string.rating_icon),
                                    tint = MaterialTheme.colors.primary
                                )
                            }
                        }
                    }
                }
            }
        }
        LazyRow(
            modifier = Modifier
        ){
            items(trendingList) { movie ->
                TrendingMovieItem(imageUrl = movie.backdropPath ?: "", title = movie.title ?: "", rating = movie.voteAverage)
            }
        }

        LazyRow(
        ){
            items(upcomingMovieList){ movie ->
                CompactMovieItem(imageUrl = movie.posterPath ?: "", rating = movie.voteAverage)
            }
        }

        LazyRow(
        ){
            items(topRatedTvList){ movie ->
                CompactMovieItem(imageUrl = movie.posterPath ?: "", rating = movie.voteAverage)
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreenPreview() {
    KotakMovieComposeTheme {
        HomeScreen()
    }
}