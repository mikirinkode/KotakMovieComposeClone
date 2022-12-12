package com.mikirinkode.kotakmoviecompose.ui.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikirinkode.kotakmoviecompose.R
import com.mikirinkode.kotakmoviecompose.ui.theme.KotakMovieComposeTheme

@Composable
fun MovieItem(
    image: Int,
    title: String,
    releaseDate: String,
    rating: Double,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16f),
        backgroundColor = MaterialTheme.colors.secondaryVariant,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp),
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "$title poster",
                modifier = Modifier
                    .size(width = 100.dp, height = 150.dp)
                    .clip(RoundedCornerShape(16f))
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.CenterVertically),
                modifier = Modifier
                    .height(150.dp)
                    .padding(start = 8.dp),
            ) {
                Text(
                    text = releaseDate,
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Star,
                        contentDescription = stringResource(R.string.rating_icon),
                        tint = MaterialTheme.colors.primary
                    )
                    Text(
                        text = rating.toString()
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MovieItemPreview() {
    KotakMovieComposeTheme {
        MovieItem(
            R.drawable.poster_alita,
            "Alita Battle Angle",
            "2019",
            8.0
        )
    }
}