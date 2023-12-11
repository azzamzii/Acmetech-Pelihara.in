package com.acmetech.peliharain.ui.screen.authLanding.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.acmetech.peliharain.R
import com.acmetech.peliharain.ui.navigation.HOME_GRAPH_ROUTE
import com.acmetech.peliharain.ui.navigation.REGIST_GRAPH_ROUTE
import com.acmetech.peliharain.ui.theme.BluePrimary
import com.acmetech.peliharain.ui.theme.PinkPrimary
import kotlinx.coroutines.launch

@Composable
fun LoginPage(
    viewModel: SignInViewModel = hiltViewModel(),
    navController: NavController) {

    val scrollState = rememberScrollState()

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val state = viewModel.signInState.collectAsState(initial = null)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        if (state.value?.isLoading == true) {
            CircularProgressIndicator(
                modifier = Modifier.size(48.dp),
                strokeWidth = 4.dp
            )
        }
    }


    Column(
        modifier = Modifier
            .padding(10.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(contentAlignment = Alignment.Center, modifier = Modifier.height(180.dp)) {
            Image(
                painter = painterResource(id = R.drawable.logologin),
                contentDescription = "logo1",
                modifier = Modifier.size(width = 200.dp, height = 200.dp)
            )
        }

        Column(horizontalAlignment = Alignment.Start) {
            androidx.compose.material.Text(
                text = "Halo, Selamat",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            )
            androidx.compose.material.Text(
                text = "Datang Kembali !",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            )
            Spacer(modifier = Modifier.padding(2.dp))
            androidx.compose.material.Text(
                text = "Pelihara.in berupaya menjadi pelopor edukasi",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            )
            androidx.compose.material.Text(
                text = "untuk Hewan Peliharaan anda!",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            )


            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Email")
            OutlinedTextField(
                modifier = Modifier.width(323.dp),
                shape = RoundedCornerShape(25),
                label = { androidx.compose.material.Text(text = "Email") },
                value = email,
                onValueChange = { email = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = PinkPrimary, // Warna garis tepi saat mendapatkan fokus
                    unfocusedBorderColor = BluePrimary // Warna garis tepi saat tidak mendapatkan fokus
                )
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Password")

            OutlinedTextField(
                modifier = Modifier.width(323.dp),
                shape = RoundedCornerShape(25),
                label = { androidx.compose.material.Text(text = "Confirm Password") },
                value = password,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = PinkPrimary, // Warna garis tepi saat mendapatkan fokus
                    unfocusedBorderColor = BluePrimary // Warna garis tepi saat tidak mendapatkan fokus
                ),
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility.value = !passwordVisibility.value
                    }) {
                        Icon(
                            painterResource(id = R.drawable.ic_eye),
                            contentDescription = "",
                            tint = if (passwordVisibility.value) Color.Black else Color.Gray
                        )
                    }
                },

                visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = { password = it })

            Spacer(modifier = Modifier.height(20.dp))
        }


        Box(modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp)) {
            Button(
                onClick = {
                    if (email.isNotEmpty() && password.isNotEmpty()) {
                         scope.launch {
                             viewModel.loginUser(email, password)
                            }
                    } else {
                        Toast.makeText(context, "Field tidak boleh kosong", Toast.LENGTH_SHORT).show()
                    }
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = BluePrimary // Warna latar belakang tombol
                )
            ) {
                Text(
                    text = "Masuk",
                    style = TextStyle(
                        color = Color.White, // Warna teks tombol
                        fontWeight = FontWeight.Bold, // Teks bold
                        fontSize = 20.sp // Ukuran teks 16sp
                    )
                )
            }
        }

        LaunchedEffect(key1 = state.value?.isSuccess) {
            scope.launch {
                if (state.value?.isSuccess?.isNotEmpty() == true) {
                    navController.navigate(HOME_GRAPH_ROUTE){
                        popUpTo(HOME_GRAPH_ROUTE){
                            inclusive = true
                        }
                    }
                }
            }
        }

        LaunchedEffect(key1 = state.value?.isError) {
            scope.launch {
                if (state.value?.isError?.isNotEmpty() == true) {
                    val error = state.value?.isError
                    Toast.makeText(context, "${error}", Toast.LENGTH_LONG).show()
                }
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Belum punya akun?",
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                modifier = Modifier.clickable {
                    navController.navigate(REGIST_GRAPH_ROUTE){
                        popUpTo(REGIST_GRAPH_ROUTE){
                            inclusive = true
                        }
                    }
                },
                text = "Daftar",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = PinkPrimary,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPage(
        navController = rememberNavController()
    )
}