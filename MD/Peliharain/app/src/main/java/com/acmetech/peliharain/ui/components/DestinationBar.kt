package com.acmetech.peliharain.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.acmetech.peliharain.ui.theme.AlphaNearOpaque
import com.acmetech.peliharain.ui.theme.BluePrimary
import com.acmetech.peliharain.ui.theme.PeliharainTheme

@Composable
fun DestinationBar(modifier: Modifier = Modifier) {
    Column(modifier = modifier.statusBarsPadding()) {
        TopAppBar(
            modifier = modifier.padding(8.dp),
            backgroundColor = PeliharainTheme.colors.uiBackground.copy(alpha = AlphaNearOpaque),
            contentColor = PeliharainTheme.colors.textSecondary,
            elevation = 0.dp
        ) {
            val search = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = search.value,
                onValueChange = { search.value = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
                    .border(3.dp, Color.Gray.copy(alpha = 0.2f), shape = RoundedCornerShape(25.dp))
                    .height(50.dp)
                    .clip(RoundedCornerShape(20.dp)),

                placeholder = { androidx.compose.material3.Text(text = "Search", color = Color.Black, textAlign = TextAlign.Center) },
                leadingIcon = { androidx.compose.material3.Icon(Icons.Filled.Search, contentDescription = "Search") },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Text
                ),
                keyboardActions = KeyboardActions(
                    onDone = { /* handle done action if needed */ }
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = BluePrimary.copy(alpha = 0.4f),
                    cursorColor = Color.Black,
                    focusedIndicatorColor = BluePrimary,
                    unfocusedIndicatorColor = Color.Transparent,
                    textColor = Color.Black
                )
            )
        }
        Divider()
    }
}

@Preview("default")
//@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Preview("large font", fontScale = 2f)
@Composable
fun PreviewDestinationBar() {
    PeliharainTheme {
        DestinationBar()
    }
}
