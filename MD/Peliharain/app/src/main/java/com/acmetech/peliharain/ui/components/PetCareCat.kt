package com.acmetech.peliharain.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.acmetech.peliharain.R
import com.acmetech.peliharain.data.response.ResponseCatItem
import com.acmetech.peliharain.model.CollectionType
import com.acmetech.peliharain.model.PetCollectionCat
import com.acmetech.peliharain.ui.screen.dashboard.FeedViewModel
import com.acmetech.peliharain.ui.theme.PeliharainTheme
import com.acmetech.peliharain.util.mirroringIcon

private val HighlightCardWidth = 170.dp
private val HighlightCardPadding = 16.dp

// The Cards show a gradient which spans 3 cards and scrolls with parallax.
private val gradientWidth
    @Composable
    get() = with(LocalDensity.current) {
        (3 * (HighlightCardWidth + HighlightCardPadding).toPx())
    }


@Composable
fun SnackCollection(
    petCollectionCat: PetCollectionCat,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
    index: Int = 0,
    highlight: Boolean = true,
    viewModel: FeedViewModel
) {
    val isLoading = viewModel.isLoadingCat.value
    val isErorr = viewModel.isErrorCat.value
    LaunchedEffect(Unit) {
        viewModel.getNewsCat()
    }

    if (isLoading) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .heightIn(min = 56.dp)
                .padding(start = 24.dp)
        ) {
            Text(
                text = petCollectionCat.name,
                style = MaterialTheme.typography.h6,
                color = PeliharainTheme.colors.brand,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
            IconButton(
                onClick = { /* todo */ },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = mirroringIcon(
                        ltrIcon = Icons.Outlined.ArrowForward,
                        rtlIcon = Icons.Outlined.ArrowBack
                    ),
                    tint = PeliharainTheme.colors.brand,
                    contentDescription = null
                )
            }
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(50.dp)
            )
        }


    } else if (isErorr) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .heightIn(min = 56.dp)
                .padding(start = 24.dp)
        ) {
            Text(
                text = petCollectionCat.name,
                style = MaterialTheme.typography.h6,
                color = PeliharainTheme.colors.brand,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
            IconButton(
                onClick = { /* todo */ },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = mirroringIcon(
                        ltrIcon = Icons.Outlined.ArrowForward,
                        rtlIcon = Icons.Outlined.ArrowBack
                    ),
                    tint = PeliharainTheme.colors.brand,
                    contentDescription = null
                )
            }
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Error")
        }
    } else {
        Column(modifier = modifier) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .heightIn(min = 56.dp)
                    .padding(start = 24.dp)
            ) {
                Text(
                    text = petCollectionCat.name,
                    style = MaterialTheme.typography.h6,
                    color = PeliharainTheme.colors.brand,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.Start)
                )
                IconButton(
                    onClick = { /* todo */ },
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Icon(
                        imageVector = mirroringIcon(
                            ltrIcon = Icons.Outlined.ArrowForward,
                            rtlIcon = Icons.Outlined.ArrowBack
                        ),
                        tint = PeliharainTheme.colors.brand,
                        contentDescription = null
                    )
                }
            }
            if (highlight && petCollectionCat.type == CollectionType.Highlight) {
                HighlightedSnacks(
                    index, FeedViewModel(), onSnackClick
                )
            } else {
                Snacks(FeedViewModel(), onSnackClick)
            }
        }
    }

}


@Composable
private fun HighlightedSnacks(
    index: Int,
    //snacks: List<Snack>,
    viewModel: FeedViewModel,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    try {
        viewModel.getNewsCat()
    } catch (e: Exception) {
        // Tangani kesalahan atau lakukan tindakan yang sesuai
        Log.e("TAG", "Error while fetching news: ${e.message}")
    }

    val scroll = rememberScrollState(0)
    val gradient = when ((index / 2) % 2) {
        0 -> PeliharainTheme.colors.gradient6_1
        else -> PeliharainTheme.colors.gradient6_2
    }
    // The Cards show a gradient which spans 3 cards and scrolls with parallax.
    val gradientWidth = with(LocalDensity.current) {
        (6 * (HighlightCardWidth + HighlightCardPadding).toPx())
    }
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(start = 24.dp, end = 24.dp)
    ) {

        itemsIndexed(viewModel.catListResponse) { index, snack ->
            HighlightSnackItem(
                snack,
                onSnackClick,
                index,
                gradient,
                gradientWidth,
                scroll.value
            )
        }
    }
}

@Composable
private fun Snacks(
    viewModel: FeedViewModel,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    var isLoading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        try {
            isLoading = true
            viewModel.getNewsCat()
            isLoading = false
        } catch (e: Exception) {
            error = true
            Log.e("TAG", "Error while fetching news: ${e.message}")
        }
    }

    if (isLoading) {
        // Tampilkan indikator loading
        CircularProgressIndicator(
            modifier = Modifier
                .size(50.dp)
        )
    } else if (error) {
        // Tampilkan pesan kesalahan
        Text(
            text = "Failed to load news",
            color = Color.Red,
            modifier = Modifier.padding(16.dp)
        )
    } else {
        LazyRow(
            modifier = modifier,
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
        ) {
            items(viewModel.catListResponse) { snack ->
                SnackItem(snack, onSnackClick)
            }
        }
    }
}

@Composable
fun SnackItem(
    snack: ResponseCatItem,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    PeliharainSurface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.padding(
            start = 4.dp,
            end = 4.dp,
            bottom = 8.dp
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable(onClick = {
                    snack.idCat?.let {
                        onSnackClick(
                            it
                        )
                    }
                })
                .padding(8.dp)
        ) {
            SnackImage(
                imageUrl = snack.imageUrl.toString(),
                elevation = 4.dp,
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )
            Text(
                text = snack.content.toString(),
                style = MaterialTheme.typography.subtitle1,
                color = PeliharainTheme.colors.textSecondary,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
private fun HighlightSnackItem(
    snack: ResponseCatItem,
    onSnackClick: (Long) -> Unit,
    index: Int,
    gradient: List<Color>,
    gradientWidth: Float,
    scroll: Int,
    modifier: Modifier = Modifier
) {
    val left = index * with(LocalDensity.current) {
        (HighlightCardWidth + HighlightCardPadding).toPx()
    }
    Card(
        modifier = modifier
            .size(
                width = 170.dp,
                height = 250.dp
            )
            .padding(bottom = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .clickable(onClick = { onSnackClick(snack.idCat!!) })
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .height(160.dp)
                    .fillMaxWidth()
            ) {
                val gradientOffset = left - (scroll / 3f)
                Box(
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .offsetGradientBackground(gradient, gradientWidth, gradientOffset)

                )
                SnackImage(
                    imageUrl = snack.imageUrl.toString(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .align(Alignment.BottomCenter)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = snack.title.toString(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h6,
                color = PeliharainTheme.colors.textSecondary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = snack.content.toString(),
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                color = PeliharainTheme.colors.textHelp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun SnackImage(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp
) {
    PeliharainSurface(
        color = Color.LightGray,
        elevation = elevation,
        shape = CircleShape,
        modifier = modifier
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = contentDescription,
            placeholder = painterResource(R.drawable.pet),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview("default")
@Preview("dark theme", uiMode = UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
fun SnackCardPreview() {
    PeliharainTheme {
        val snack = ResponseCatItem(
            idCat = 1,
            content = "Kucing",
            title = "Kucing adalah hewan yang lucu",
            imageUrl = "https://cdn2.thecatapi.com/images/MTYwODQwMg.jpg"
        )
        HighlightSnackItem(
            snack = snack,
            onSnackClick = { },
            index = 0,
            gradient = PeliharainTheme.colors.gradient6_1,
            gradientWidth = gradientWidth,
            scroll = 0
        )
    }
}
