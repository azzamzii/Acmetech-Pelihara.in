package com.acmetech.peliharain.ui.components.Pet

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.acmetech.peliharain.R
import com.acmetech.peliharain.ui.navigation.HOME_GRAPH_ROUTE
import com.acmetech.peliharain.ui.theme.BluePrimary


@Composable

fun PetFormPage(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        val pet_name = remember { mutableStateOf(TextFieldValue()) }
        val pet_age = remember { mutableStateOf(TextFieldValue()) }
        val pet_kind = remember { mutableStateOf(TextFieldValue()) }
        val pet_gender = remember { mutableStateOf(TextFieldValue()) }



        Box(contentAlignment = Alignment.Center, modifier = Modifier.height(180.dp)) {
            Image(
                painter = painterResource(id = R.drawable.logologin),
                contentDescription = "logo1",
                modifier = Modifier.size(width = 200.dp, height = 200.dp)
            )
        }


        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Daftarkan Hewan Peliharaanmu!",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = "Peliharaanmu prioritas kami!",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.width(323.dp),
                shape = RoundedCornerShape(25),
                label = { Text(text = "Nama Hewanmu") },
                value = pet_name.value,
                onValueChange = { pet_name.value = it })

            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.width(323.dp),
                shape = RoundedCornerShape(25),
                label = { Text(text = "Anjing / Kucing") },
                value = pet_kind.value,
                onValueChange = { pet_kind.value = it })

            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.width(323.dp),
                shape = RoundedCornerShape(25),
                label = { Text(text = "Usia Hewanmu") },
                value = pet_age.value,
                onValueChange = { pet_age.value = it })

            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.width(323.dp),
                shape = RoundedCornerShape(25),
                label = { Text(text = "Gender") },
                value = pet_gender.value,
                onValueChange = { pet_gender.value = it })
            



            Spacer(modifier = Modifier.height(20.dp))
        }


        Box(modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp)) {
            Button(
                onClick = {
                    navController.navigate(HOME_GRAPH_ROUTE) {
                        popUpTo(HOME_GRAPH_ROUTE) { inclusive = true }
                    }
                    Toast.makeText(
                        context,
                        "Under Development \uD83D\uDE0A",
                        Toast.LENGTH_LONG
                    ).show()
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = BluePrimary // Warna latar belakang tombol
                )
            ) {
                androidx.compose.material3.Text(
                    text = "Daftar",
                    style = TextStyle(
                        color = Color.White, // Warna teks tombol
                        fontWeight = FontWeight.Bold, // Teks bold
                        fontSize = 20.sp // Ukuran teks 16sp
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

    }
}
@Preview(showBackground = true)
@Composable
fun PetFormPagePreview() {
    PetFormPage(navController = rememberNavController())
}
