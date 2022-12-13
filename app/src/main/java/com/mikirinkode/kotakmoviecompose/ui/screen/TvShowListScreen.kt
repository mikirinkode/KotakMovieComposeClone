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
fun TvShowListScreen(
    modifier: Modifier = Modifier
) {
    val dummyList = DummyData.getDummyTvShowList()
    var showMenu by remember {
        mutableStateOf(false)
    }

    var selected by remember {
        mutableStateOf("Popular")
    }

    val dropdownMenuItems = listOf("Popular", "Newest Release", "Oldest Release", "Best Vote", "Random")

    Column(
        modifier = modifier
    ) {
        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.menu_tv_show))
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


@Preview
@Composable
fun TvShowListScreenPreview() {
    KotakMovieComposeTheme {
        MovieListScreen()
    }
}