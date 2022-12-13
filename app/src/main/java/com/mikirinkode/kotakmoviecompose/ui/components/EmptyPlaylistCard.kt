package com.mikirinkode.kotakmoviecompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikirinkode.kotakmoviecompose.R
import com.mikirinkode.kotakmoviecompose.ui.theme.KotakMovieComposeTheme

@Composable
fun EmptyPlaylistCard(
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.empty_playlist_illustration),
                contentDescription = stringResource(R.string.empty_playlist_illustration),
                modifier = Modifier.size(width = 200.dp, height = 250.dp)
            )
            Text(
                text = stringResource(R.string.empty_playlist_title),
                fontSize = 24.sp,
                color = MaterialTheme.colors.onSurface,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp)
            )
            Text(
                text = stringResource(R.string.empty_playlist_description),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onSurface,
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun EmptyPlaylistCardPreview() {
    KotakMovieComposeTheme {
        EmptyPlaylistCard()
    }
}