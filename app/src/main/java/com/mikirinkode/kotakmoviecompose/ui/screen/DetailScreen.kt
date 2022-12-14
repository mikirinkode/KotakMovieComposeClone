package com.mikirinkode.kotakmoviecompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mikirinkode.kotakmoviecompose.R
import com.mikirinkode.kotakmoviecompose.model.DummyData
import com.mikirinkode.kotakmoviecompose.ui.components.MovieItem
import com.mikirinkode.kotakmoviecompose.ui.theme.KotakMovieComposeTheme
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun DetailScreen(
    movieId: Int,
    navigateBack: () -> Unit,
    navigateToTrailerScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    val gradient = Brush.verticalGradient(
        0f to MaterialTheme.colors.background,
        500f to Color.Transparent,
        1000f to MaterialTheme.colors.background
    )

    val state = rememberCollapsingToolbarScaffoldState()

    Box() {
        CollapsingToolbarScaffold(
            modifier = modifier.fillMaxSize(),
            state = state,
            toolbarModifier = Modifier.background(MaterialTheme.colors.secondaryVariant),
            enabled = true,
            scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
            toolbar = {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.poster_alita),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .parallax(0.5f)
                        .fillMaxWidth()
                        .height(200.dp)
                        .graphicsLayer {
                            // change alpha of image as the toolbar expands
                            alpha = state.toolbarState.progress
                        }
                )

                Box(
                    Modifier
                        .parallax(0.5f)
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colors.background,
                                Color.Transparent,
                                MaterialTheme.colors.background
                            )
                        ))
                )
            }
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    DetailMovieContent()
                }
//            items(DummyData.getDummyMovieList()) { item ->
//                MovieItem(
//                    imageUrl = item.posterPath ?: "",
//                    title = item.title ?: "",
//                    releaseDate = item.releaseDate ?: "",
//                    rating = item.voteAverage
//                )
//            }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = navigateBack) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = stringResource(
                        R.string.back_button
                    ),
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
            Text(
                text = "Category: MOVIE",
                color = Color.White,
            )
        }
    }

}

@Composable
fun DetailMovieContent(
//    title: String,
//    posterUrl: String,
//    genre: String,
//    runtime: Int,
//    voteAverage: Double,
//    releaseDate: String,
//    tagline: String,
//    overview: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        backgroundColor = MaterialTheme.colors.secondaryVariant,
        modifier = modifier
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Doctor Strange in the Multiverse of Madness",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.poster_alita),
                    contentDescription = null, // TODO: CHANGE LATER
                    modifier = Modifier
                        .size(width = 140.dp, height = 210.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(color = MaterialTheme.colors.background)
                )
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically),
                ) {
                    // 3 button
                    DetailAdditionalButton(
                        iconId = R.drawable.ic_play_trailer,
                        iconDesc = stringResource(R.string.play_trailer_button),
                        buttonText = stringResource(R.string.play_trailer),
                        onClick = { /*TODO*/ })
                    DetailAdditionalButton(
                        iconId = R.drawable.ic_add_to_playlist,
                        iconDesc = stringResource(R.string.add_to_playlist_button),
                        buttonText = stringResource(R.string.add_to_playlist),
                        onClick = { /*TODO*/ })
                    DetailAdditionalButton(
                        iconId = R.drawable.ic_share,
                        iconDesc = stringResource(R.string.share_button),
                        buttonText = stringResource(R.string.share),
                        onClick = { /*TODO*/ })
                }
            }
            Text(
                text = "Fantasy, Action, Adventure, blalballba bli bli bli blu bla",
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 24.dp, bottom = 16.dp)
            )
            Spacer(
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = MaterialTheme.colors.onSurface)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                DetailInfoItem(R.drawable.ic_time, "runtime", "2h 6m")
                DetailInfoItem(R.drawable.ic_star_outlined, "vote average", "0.0")
                DetailInfoItem(R.drawable.ic_date, "release date", "04 May 2022")
            }
            Spacer(
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = MaterialTheme.colors.onSurface)
            )
            Text(
                text = "Enter a new dimension of Strange.",
                color = MaterialTheme.colors.onSurface,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(top = 16.dp)
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.overview),
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Lorem Ipsum Sir Dolor Amet",
                color = MaterialTheme.colors.onSurface,
                textAlign = TextAlign.Left,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun DetailInfoItem(
    iconId: Int,
    iconDesc: String,
    data: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = iconDesc,
            tint = MaterialTheme.colors.primary,
            modifier = Modifier
                .size(20.dp)
                .padding(end = 4.dp)
        )
        Text(text = data)
    }
}

@Composable
fun DetailAdditionalButton(
    iconId: Int,
    iconDesc: String,
    buttonText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        Icon(
            painter = painterResource(id = iconId),
            tint = MaterialTheme.colors.primary,
            contentDescription = iconDesc,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = buttonText,
            color = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(start = 8.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun BakGFG() {
    val lazyListState = rememberLazyListState()
    var scrolledY = 0f
    var previousOffset = 0
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Test ToolBar", color = Color.White)
                },
                backgroundColor = Color.Transparent
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    lazyListState,
                ) {
                    item {
                        Image(
                            painter = painterResource(id = R.drawable.poster_alita),
                            contentDescription = "Movie Backdrop",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .graphicsLayer {
                                    scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                                    translationY = scrolledY * 0.5f
                                    previousOffset = lazyListState.firstVisibleItemScrollOffset
                                }
                                .height(240.dp)
                                .fillMaxWidth()
                        )
//                        DetailMovieContent()
                    }

                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DetailContentPreview() {
    KotakMovieComposeTheme {
        DetailMovieContent()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailScreenPreview() {
    KotakMovieComposeTheme {
        DetailScreen(1, {}, {})
    }
}