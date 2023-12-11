package com.acmetech.peliharain.ui.screen.dashboard

import android.content.res.Configuration
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acmetech.peliharain.R
import com.acmetech.peliharain.model.PetCollectionCat
import com.acmetech.peliharain.model.PetCollectionDog
import com.acmetech.peliharain.model.SnackRepo
import com.acmetech.peliharain.ui.components.DestinationBar
import com.acmetech.peliharain.ui.components.Divider
import com.acmetech.peliharain.ui.components.PeliharainSurface
import com.acmetech.peliharain.ui.components.SnackCollection
import com.acmetech.peliharain.ui.components.SnackCollectionAnjing
import com.acmetech.peliharain.ui.theme.BluePrimary
import com.acmetech.peliharain.ui.theme.PeliharainTheme
import com.acmetech.peliharain.ui.theme.PinkPrimary
import com.acmetech.peliharain.util.FunctionalityNotAvailablePopup

@Composable
fun Feed(
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
    onPetCareClick: () -> Unit,
) {
    val snackCollectionsCat = remember { SnackRepo.getCats() }
    val snackCollectionsAnjing = remember { SnackRepo.getDogs() }
    Feed(
        snackCollectionsCat,
        snackCollectionsAnjing,
        onPetCareClick,
        onSnackClick,
        modifier
    )
}

@Composable
private fun Feed(
    petCollectionCats: List<PetCollectionCat>,
    snackCollectionsAnjing: List<PetCollectionDog>,
    onPetCareClick: () -> Unit,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {

    PeliharainSurface(modifier = modifier.fillMaxSize()) {
        Column() {

            DestinationBar()

            PetCareCollectionList(petCollectionCats, snackCollectionsAnjing, onSnackClick)

        }

        //OVERLAY BUTTON PETCARE
        var functionalityNotAvailablePopupShown by remember { mutableStateOf(false) }
        if (functionalityNotAvailablePopupShown) {
            FunctionalityNotAvailablePopup { functionalityNotAvailablePopupShown = false }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
//                onClick = {
//                    functionalityNotAvailablePopupShown = true
//                },
                onClick = onPetCareClick,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(bottom = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = BluePrimary
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Place,
                        contentDescription = null,
                        tint = PinkPrimary,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "PetCare",
                        style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    )
                }
            }
        }


    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun PetCareCollectionList(
    petCollectionCats: List<PetCollectionCat>,
    petCollectionsAnjing: List<PetCollectionDog>,

    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {

    Box(modifier) {
        LazyColumn {

            item {
                Box(modifier = modifier.padding(8.dp)) {
                    Image(
                        painter = painterResource(R.drawable.spo),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.Crop
                    )
                }

                //FilterBar(filters, onShowFilters = { filtersVisible = true })

            }
            itemsIndexed(petCollectionCats) { index, snackCollection ->
                if (index == 1) {
                    Divider(thickness = 2.dp)
                }

                SnackCollection(
                    petCollectionCat = snackCollection,
                    onSnackClick = {
                        onSnackClick(it)
                    },
                    index = index,
                    viewModel = FeedViewModel()
                )

            }
            itemsIndexed(petCollectionsAnjing) { index, snackCollectionAnjing ->
                if (index == 1) {
                    Divider(thickness = 2.dp)
                }

                SnackCollectionAnjing(
                    snackCollection = snackCollectionAnjing,
                    onSnackClick = {
                        onSnackClick(it)
                    },
                    index = index,
                    viewModel = FeedViewModel()
                )
            }


        }

        }
    }



@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
fun HomePreview() {
    PeliharainTheme {
        Feed(onSnackClick = { },onPetCareClick = { })
    }
}
