package com.mikirinkode.kotakmoviecompose.ui.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Search: Screen("search")
    object Movie: Screen("movie")
    object TvShow: Screen("tvshow")
    object Playlist: Screen("playlist")
    object MoviePlaylist: Screen("movieplaylist")
    object TvShowPlaylist: Screen("tvshowplaylist")
    object Detail: Screen("detail")
    object Trailer: Screen("trailer")
}