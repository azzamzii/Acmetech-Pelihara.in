package com.acmetech.peliharain.ui.components.Pet

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.acmetech.peliharain.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PetShopPage(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Pet Shops") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // List of Pet Shops
            PetShopList(
                petShops = listOf(
                    PetShop(
                        name = "PetShop 1",
                        rating = 4.5f,
                        description = "PetShop 1 Description",
                        imageResId = R.drawable.pet,
                        jamBuka = "08.00 - 17.00"
                    ),
                    PetShop(
                        name = "PetShop 2",
                        rating = 3.8f,
                        description = "PetShop 2 Description",
                        imageResId = R.drawable.pet,
                        jamBuka = "08.00 - 17.00"
                    ),
                    PetShop(
                        name = "PetShop 3",
                        rating = 4.9f,
                        description = "PetShop 3 Description",
                        imageResId = R.drawable.pet,
                        jamBuka = "08.00 - 17.00"
                    )
                )
            )
        }
    }
}






@Composable
fun PetShopList(petShops: List<PetShop>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(petShops) { petShop ->
            PetShopItem(petShop = petShop)
        }
    }
}

@Composable
fun PetShopItem(petShop: PetShop) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .aspectRatio(1f)
        ) {
            Image(
                painter = painterResource(id = petShop.imageResId),
                contentDescription = "Pet Shop Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .fillMaxSize(),


            ) {
            Text(text = petShop.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.width(200.dp))
            Icon(
                Icons.Default.Star,
                contentDescription = null,
                tint = Color.Yellow,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = petShop.rating.toString(), fontWeight = FontWeight.Bold)
        }

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Text(text = petShop.description)
            Text(text = petShop.jamBuka)

        }

    }
}


@Preview(showBackground = true)
@Composable
fun PetShopPreview() {
    PetShopPage(
        navController = NavController(LocalContext.current)
    )
}

data class PetShop(
    val name: String,
    val rating: Float,
    val description: String,
    val imageResId: Int,
    val jamBuka: String
)

