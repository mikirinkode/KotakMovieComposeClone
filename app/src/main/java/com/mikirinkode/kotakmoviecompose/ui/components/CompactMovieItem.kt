package com.mikirinkode.kotakmoviecompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mikirinkode.kotakmoviecompose.R
import com.mikirinkode.kotakmoviecompose.ui.theme.KotakMovieComposeTheme

@Composable
fun CompactMovieItem(
    imageUrl: String,
    rating: Double,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16f),
        backgroundColor = MaterialTheme.colors.secondaryVariant,
        modifier = modifier
            .padding(16.dp)
            .wrapContentSize()
    ) {
        Box(modifier = Modifier){
            AsyncImage(
                model = imageUrl,
                contentDescription = "movie poster",
                modifier = Modifier
                    .size(width = 100.dp, height = 150.dp)
                    .clip(RoundedCornerShape(16f))
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp)
                    .background(color = MaterialTheme.colors.background, shape = RoundedCornerShape(16f))
                    .padding(4.dp)
                    .align(Alignment.BottomCenter),
            ) {
                Icon(
                    imageVector = Icons.Rounded.Star,
                    contentDescription = stringResource(R.string.rating_icon),
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .size(15.dp)
                )
                Text(
                    text = rating.toString(),
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CompactMovieItemPreview() {
    KotakMovieComposeTheme {
        CompactMovieItem(
            "",
            8.0
        )
    }
}