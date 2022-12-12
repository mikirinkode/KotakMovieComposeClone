package com.mikirinkode.kotakmoviecompose.model

data class Movie(
    val id: Int,
    val title: String?,
    val releaseDate: String?,
    val overview: String?,
    val tagline: String?,
    val genres: String?,
    val runtime: Int?,
    val voteAverage: Double,
    val posterPath: String?,
    val backdropPath: String?,
    var isOnPlaylist: Boolean = false,
    var isTvShow: Boolean = false
)

object DummyData {
    fun getDummyMovieList(): List<Movie> {
        return listOf<Movie>(
            Movie(1, "Alita: Battle Angel but with more long title", "January 31, 2019", "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "An angel falls. A warrior rises.", "Action, Science Fiction, Adventure", 122, 7.2, "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg", "https://www.themoviedb.org/t/p/original/vPDuinnoNqWiLVzNNyNj2zdB5VS.jpg", false, false),
            Movie(2, "Bohemian Rhapshody", "October 24, 2018", "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.", "Fearless lives forever", "Music, Drama, History", 135, 8.0, "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg", "https://www.themoviedb.org/t/p/original/93xA62uLd5CwMOAs37eQ7vPc1iV.jpg", false, false),
            Movie(3, "", "", "", "", "", 0, 0.0, "", "", false, false),
            Movie(4, "", "", "", "", "", 0, 0.0, "", "", false, false),
            Movie(5, "", "", "", "", "", 0, 0.0, "", "", false, false),
            Movie(6, "", "", "", "", "", 0, 0.0, "", "", false, false),
            Movie(7, "", "", "", "", "", 0, 0.0, "", "", false, false),
            Movie(8, "", "", "", "", "", 0, 0.0, "", "", false, false),
            Movie(9, "", "", "", "", "", 0, 0.0, "", "", false, false),
            Movie(10, "", "", "", "", "", 0, 0.0, "", "", false, false),
        )
    }
    fun getDummyTvShowList(): List<Movie> {
        return listOf<Movie>(
            Movie(11, "", "", "", "", "", 0, 0.0, "", "", false, true),
            Movie(13, "", "", "", "", "", 0, 0.0, "", "", false, true),
            Movie(14, "", "", "", "", "", 0, 0.0, "", "", false, true),
            Movie(12, "", "", "", "", "", 0, 0.0, "", "", false, true),
            Movie(15, "", "", "", "", "", 0, 0.0, "", "", false, true),
            Movie(16, "", "", "", "", "", 0, 0.0, "", "", false, true),
            Movie(17, "", "", "", "", "", 0, 0.0, "", "", false, true),
            Movie(18, "", "", "", "", "", 0, 0.0, "", "", false, true),
            Movie(19, "", "", "", "", "", 0, 0.0, "", "", false, true),
            Movie(20, "", "", "", "", "", 0, 0.0, "", "", false, true),
        )
    }
}