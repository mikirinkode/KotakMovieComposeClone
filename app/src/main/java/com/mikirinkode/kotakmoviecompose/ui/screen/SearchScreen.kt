package com.mikirinkode.kotakmoviecompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikirinkode.kotakmoviecompose.R
import com.mikirinkode.kotakmoviecompose.model.DummyData
import com.mikirinkode.kotakmoviecompose.model.Movie
import com.mikirinkode.kotakmoviecompose.ui.components.MovieItem
import com.mikirinkode.kotakmoviecompose.ui.components.StateMessageComponent
import com.mikirinkode.kotakmoviecompose.ui.theme.KotakMovieComposeTheme

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier
) {
    val dummyList = DummyData.getDummyMovieList()
    Column {
        SearchBar()

        // initial state
        StateMessageComponent(
            drawableId = R.drawable.initial_search_state_illustration,
            drawableDesc = R.string.initial_state_illustration,
            imageWidth = 300,
            imageHeight = 150,
            titleStringId = R.string.initial_search_title,
            descriptionStringId = R.string.initial_search_desc
        )
        //error state
        StateMessageComponent(
            drawableId = R.drawable.ic_error_state,
            drawableDesc = R.string.error_illustration,
            imageWidth = 187,
            imageHeight = 178,
            titleStringId = R.string.error_title,
            descriptionStringId = R.string.error_desc
        )

        // empty state
        StateMessageComponent(
            drawableId = R.drawable.search_empty_result_illustration,
            drawableDesc = R.string.empty_search_result_illustration,
            imageWidth = 200,
            imageHeight = 195,
            titleStringId = R.string.empty_search_result_title,
            descriptionStringId = R.string.empty_search_result_desc
        )
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



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchScreenPreview() {
    KotakMovieComposeTheme {
        SearchScreen()
    }
}