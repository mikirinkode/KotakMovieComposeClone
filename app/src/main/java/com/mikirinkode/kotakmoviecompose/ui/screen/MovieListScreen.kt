package com.mikirinkode.kotakmoviecompose.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mikirinkode.kotakmoviecompose.R
import com.mikirinkode.kotakmoviecompose.model.DummyData
import com.mikirinkode.kotakmoviecompose.model.Movie
import com.mikirinkode.kotakmoviecompose.ui.components.MovieItem
import com.mikirinkode.kotakmoviecompose.ui.components.MovieListComponent
import com.mikirinkode.kotakmoviecompose.ui.theme.KotakMovieComposeTheme

@Composable
fun MovieListScreen(modifier: Modifier = Modifier) {
    val dummyList = DummyData.getDummyMovieList()
    var showMenu by remember {
        mutableStateOf(false)
    }

    var selected by remember {
        mutableStateOf("Popular")
    }

    val dropdownMenuItems = listOf("Popular", "Newest Release", "Oldest Release", "Best Vote", "Random")

    Column {
        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.menu_movie))
            },
            actions = {
                IconButton(onClick = { showMenu = !showMenu }) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "More Menu"
                    )
                }
                DropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false },
                    modifier = Modifier
                        .align(Alignment.Bottom)
                ) {
                    for (item in dropdownMenuItems){
                        MyDropDownItem(selected = selected, title = item, onClick = {
                            selected = item
                            showMenu = false})
                    }
                }
            },
            backgroundColor = MaterialTheme.colors.secondaryVariant
        )
        MovieListComponent(list = dummyList)
    }
}



@Composable
fun MyDropDownItem(
    selected: String,
    title: String,
    onClick: () -> Unit
) {
    DropdownMenuItem(onClick = onClick) {
        Text(
            text = title,
            color = if (selected == title) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface
        )
    }
}


@Preview
@Composable
fun MovieListScreenPreview() {
    KotakMovieComposeTheme {
        MovieListScreen()
    }
}