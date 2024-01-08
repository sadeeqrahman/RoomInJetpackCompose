package com.sadeeq.encoders.roominjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.sadeeq.encoders.roominjetpackcompose.entity.UserEnitity


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobileNumber(userEntity: UserEnitity, onValueChange: (String) -> Unit) {
    var text by remember { mutableStateOf(userEntity.mobileNumber) }
    var isFocused by remember { mutableStateOf(false) }

    TextField(value = text, onValueChange = { newText ->
        text = newText
        onValueChange(newText)
    }, singleLine = true, colors = TextFieldDefaults.textFieldColors(
        containerColor = Color.White,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        cursorColor = Color.Black,
    ), keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Number,
        imeAction = ImeAction.Done
    ), leadingIcon = {
        Icon(
            imageVector = Icons.Default.Call,
            contentDescription = null,
            tint = if (isFocused) Color.Green else Color.Red
        )
    },
        placeholder = {
            MyPlaceholderText("Enter username")
        },

        trailingIcon = {
            if (text.isNotEmpty()) {
                Icon(imageVector = Icons.Default.Clear,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.clickable {
                        text = ""
                        onValueChange("")
                    })
            }
        }, modifier = Modifier
            .focusModifier()
            .onFocusChanged {
                isFocused = it.isFocused
            }
            .padding(2.dp)
            .fillMaxWidth()
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary, CircleShape)
            .border(1.dp, if (isFocused) Color.Green else Color.Red, CircleShape))
}

