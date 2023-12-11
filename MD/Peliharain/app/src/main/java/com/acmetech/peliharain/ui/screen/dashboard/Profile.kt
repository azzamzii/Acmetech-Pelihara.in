package com.acmetech.peliharain.ui.screen.dashboard

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acmetech.peliharain.R
import com.acmetech.peliharain.ui.theme.BluePrimary
import com.acmetech.peliharain.ui.theme.PinkPrimary
import com.acmetech.peliharain.util.FunctionalityNotAvailablePopup
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Profile(
    logout: () -> Unit,
    modifier: Modifier = Modifier,
    onPetFormClick: () -> Unit,
) {

    val user = FirebaseAuth.getInstance().currentUser
    val email = user?.email
    val context = LocalContext.current
    val firebaseAuth = FirebaseAuth.getInstance()

    Column(

        modifier = modifier
            .wrapContentSize()
            .padding(24.dp)
    ) {

        Text(
            text = "Data Pet",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = BluePrimary
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Transparent),
            shape = RoundedCornerShape(16.dp),
        ) {
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(15.dp)) // Menggunakan borderRadius di sini
                    .background(BluePrimary.copy(alpha = 0.6f))
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pet),
                        contentDescription = "",
//                        modifier = Modifier
//                            .height(150.dp)
//                            .width(150.dp)
//                            .clip(shape = RoundedCornerShape(10.dp))
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Column() {

                        androidx.compose.material3.Text(
                            text = "Detail Pet", style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraLight
                            )
                        )

                        androidx.compose.material3.Text(
                            text = "Anjing", style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Spacer(modifier = Modifier.height(15.dp))
                        androidx.compose.material3.Text(
                            text = "Email", style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraLight
                            )
                        )
                        androidx.compose.material3.Text(
                            text = email ?: "",
                            style = TextStyle(
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        androidx.compose.material3.Text(
                            text = "Pet Birth", style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraLight
                            )
                        )
                        androidx.compose.material3.Text(
                            text = "<Pet Birth>", style = TextStyle(
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        androidx.compose.material3.Text(
                            text = "Home Address", style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraLight
                            )
                        )
                        androidx.compose.material3.Text(
                            text = "<Address Here>",
                            maxLines = 1,
                            style = TextStyle(
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )

                        )

                    }

                }
            }

        }
        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color.Transparent),
            shape = RoundedCornerShape(16.dp),
        ) {
            Box(
                Modifier
                    .background(BluePrimary.copy(0.6f), shape = RoundedCornerShape(16.dp))
                    .height(120.dp)
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    androidx.compose.material3.Text(
                        text = "Bio", style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    androidx.compose.material3.Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipi scing elit. Tortor turpis sodales nulla velit. Nunc cum vitae, rhoncus leo id. Volutpat  Duis tinunt pretium luctus pulvinar pretium.",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Light
                        )
                    )

                }
            }

        }

        Spacer(modifier = Modifier.height(30.dp))
        Box(modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp)) {
            androidx.compose.material.Button(
                onClick = {
                    try {
                        if (user != null) {
                            firebaseAuth.signOut()
                            logout()
                            Toast.makeText(context, "Logout Berhasil", Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: Exception) {

                        Toast.makeText(context, "Sign Out Error", Toast.LENGTH_SHORT).show()
                    }
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = buttonColors(
                    backgroundColor = PinkPrimary.copy(0.8f) // Warna latar belakang tombol
                )
            ) {
                androidx.compose.material3.Text(
                    text = "Logout",
                    style = TextStyle(
                        color = Color.White, // Warna teks tombol
                        fontWeight = FontWeight.Bold, // Teks bold
                        fontSize = 20.sp // Ukuran teks 16sp
                    )
                )
            }
        }

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
//            onClick = {
//                functionalityNotAvailablePopupShown = true
//            },
            onClick = onPetFormClick,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(bottom = 8.dp),
            colors = buttonColors(
                backgroundColor = BluePrimary
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = PinkPrimary,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                androidx.compose.material3.Text(
                    text = "Add Data Pet Kamu",
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

@Preview("light theme", showBackground = true)
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
fun ProfilePreview() {
    Profile(
        logout = {},
        onPetFormClick = {}

    )
}
