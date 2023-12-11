package com.acmetech.peliharain.ui.screen.chat

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.acmetech.peliharain.R
import com.acmetech.peliharain.data.network.ApiChatBot
import com.acmetech.peliharain.data.response.ChatBotResponse
import com.acmetech.peliharain.ui.components.chat.ChatBotAppBar
import com.acmetech.peliharain.ui.theme.BluePrimary
import com.acmetech.peliharain.ui.theme.PeliharainTheme
import com.acmetech.peliharain.ui.theme.PinkPrimary
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ChatBotScreen(
    modifier: Modifier = Modifier,
    apiChatBot: ApiChatBot,

    ) {
    val chatMessages = remember { mutableStateListOf<ChatBotResponse>() }
    var userInput by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val ChatBubbleShape = RoundedCornerShape(4.dp, 20.dp, 20.dp, 40.dp)
    val ChatBubbleShaperight = RoundedCornerShape(20.dp, 4.dp, 40.dp, 20.dp)
    var isFirstChat by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            ChatBotAppBar(
                modifier = modifier,
                title = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        // Channel name
                        Text(
                            text = "Pelihara.in Bot",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Divider(
                            color = BluePrimary,
                            modifier = Modifier
                                .padding(top = 4.dp, bottom = 4.dp)
                                .width(24.dp)
                                .height(2.dp)

                        )
                    }
                },
            )
        },
    ) { paddingValues ->


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(paddingValues)
        ) {

            // Menampilkan pesan loading saat permintaan sedang berlangsung

            // Tampilan riwayat chat
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                item {
                    if (isFirstChat == true) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Start)
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Surface(
                                color = BluePrimary.copy(alpha = 0.4f),
                                shape = ChatBubbleShape
                            ) {
                                Text(
                                    text = "Selamat datang di Pelihara.in Bot, silahkan bertanya seputar peliharaan kamu \uD83D\uDE0A",
                                    style = MaterialTheme.typography.bodyLarge.copy(color = LocalContentColor.current),
                                    modifier = Modifier.padding(16.dp),
                                )
                            }
                        }
                        isFirstChat = true
                    }
                }

                items(chatMessages) { message ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(
                                if (message.isUserMessage) Alignment.End
                                else Alignment.Start
                            )
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        horizontalArrangement =
                        if (message.isUserMessage) Arrangement.End
                        else Arrangement.Start

                    ) {
                        Surface(
                            color =
                            if (message.isUserMessage) PinkPrimary.copy(alpha = 0.4f)
                            else BluePrimary.copy(alpha = 0.4f),

                            shape =
                            if (message.isUserMessage) ChatBubbleShaperight
                            else ChatBubbleShape
                        ) {
                            Text(
                                text = message.text,
                                style = MaterialTheme.typography.bodyLarge.copy(color = LocalContentColor.current),
                                modifier = Modifier.padding(16.dp),
                            )
                        }

                    }

                }

            }


            Divider(
                color = BluePrimary,
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 4.dp)
                    .fillMaxWidth()
                    .height(2.dp)

            )

            val a11ylabel = stringResource(id = R.string.textfield_desc)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .semantics {
                        contentDescription = a11ylabel
                    },
                horizontalArrangement = Arrangement.End
            ) {
                Surface {
                    Box(
                        modifier = Modifier
                            .height(64.dp)
                            .weight(1f)
                            .align(Alignment.Bottom)
                    ) {
                        var lastFocusState by remember { mutableStateOf(false) }
                        BasicTextField(
                            value = userInput,
                            onValueChange = { userInput = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp)
                                .align(Alignment.CenterStart),
                            maxLines = 1,
                            cursorBrush = SolidColor(LocalContentColor.current),
                            textStyle = LocalTextStyle.current.copy(color = LocalContentColor.current)
                        )

                        val disableContentColor =
                            MaterialTheme.colorScheme.onSurfaceVariant
                        if (userInput.isEmpty() && !lastFocusState) {
                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterStart)
                                    .padding(start = 32.dp),

                                text = stringResource(id = R.string.textfield_hint),
                                style = MaterialTheme.typography.bodyLarge.copy(color = disableContentColor)
                            )
                        }
                    }
                }
            }
            Row(
                modifier = modifier
                    .height(72.dp)
                    .wrapContentHeight()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val disabledContentColor =
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)

                val buttonColors = ButtonDefaults.buttonColors(
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = disabledContentColor
                )

                // Send button
                androidx.compose.material3.Button(
                    modifier = Modifier
                        .height(36.dp)
                        .fillMaxWidth(),
                    enabled = !isLoading,
                    onClick = {
                        if (userInput.isNotEmpty()) {
                            coroutineScope.launch {
                                try {
                                    isLoading = true

                                    val response = apiChatBot.postMessage(userInput)

                                    chatMessages.add(ChatBotResponse(userInput, true))
                                    chatMessages.add(ChatBotResponse(response, false))

                                    userInput = ""
                                } catch (e: Exception) {
                                    Toast.makeText(context, "Server capacity reached. Please retry", Toast.LENGTH_SHORT).show()
                                } finally {
                                    isLoading = false
                                }
                            }
                        } else {
                            Toast.makeText(
                                context,
                                "Field tidak boleh kosong",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }

                    },
                    colors = buttonColors,
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
                    ),
                    contentPadding = PaddingValues(0.dp),
                ) {
                    Text(
                        stringResource(id = R.string.send),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .wrapContentHeight()
                        .align(Alignment.Center)
                )
            }
        }
    }
}


@Preview
@Composable
fun ConversationPreview() {
    PeliharainTheme {
        Surface {
            ChatBotScreen(
                apiChatBot = ApiChatBot(),
            )

        }
    }
}
