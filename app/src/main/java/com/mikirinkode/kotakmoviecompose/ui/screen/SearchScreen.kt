package com.mikirinkode.kotakmoviecompose.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mikirinkode.kotakmoviecompose.model.DummyData
import com.mikirinkode.kotakmoviecompose.model.Movie
import com.mikirinkode.kotakmoviecompose.ui.components.MovieItem
import com.mikirinkode.kotakmoviecompose.ui.theme.KotakMovieComposeTheme

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier
) {
    val dummyList = DummyData.getDummyMovieList()
    Scaffold(
        topBar = {
            SearchBar()
        }
    ) { innerPadding ->
        if (dummyList.isNotEmpty()){
            SearchResultContent(dummyList, modifier = modifier.padding(innerPadding))
        } else {
            EmptyResultMessage()
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    var inputValue by remember {
        mutableStateOf("")
    }
    TextField(
        value = inputValue,
        textStyle = TextStyle(
            color = Color.White
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        trailingIcon = {
            if (inputValue.isNotEmpty()) {
                IconButton(onClick = { inputValue = "" }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        tint = MaterialTheme.colors.onSurface,
                        contentDescription = "Close Button",
                    )
                }
            }
        },
        placeholder = {
            Text(text = "Search")
        },
        onValueChange = { newValue ->
            inputValue = newValue
        },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        modifier = modifier
            .background(MaterialTheme.colors.secondaryVariant)
            .padding(8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)),
    )
}

@Composable
fun SearchResultContent(
    list: List<Movie>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) { item ->
            MovieItem(
                imageUrl = item.posterPath ?: "",
                title = item.title ?: "",
                releaseDate = item.releaseDate ?: "",
                rating = item.voteAverage
            )
        }
    }
}

@Composable
fun EmptyResultMessage(
    modifier: Modifier = Modifier
) {
    Card() {
        
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchScreenPreview() {
    KotakMovieComposeTheme {
        SearchScreen()
    }
}