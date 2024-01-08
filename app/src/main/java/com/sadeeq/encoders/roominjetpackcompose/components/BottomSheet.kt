package com.sadeeq.encoders.roominjetpackcompose.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sadeeq.encoders.roominjetpackcompose.entity.UserEnitity


@Composable
fun showBottonsheet(userEnitity: UserEnitity) {

    var showSheet by remember { mutableStateOf(false) }

    if (showSheet) {
        BottomSheet(userEnitity) {
            showSheet = false
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            showSheet = true
        }) {
            Text(text = "Show BottomSheet")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(userEnitity: UserEnitity, onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        UserNameMobileNumber(userEntity = userEnitity, closeBottonsheet = { onDismiss() })
    }
}


@Composable
fun UserNameMobileNumber(userEntity: UserEnitity, closeBottonsheet: () -> Unit) {
    var username by remember { mutableStateOf(userEntity.name) }
    var mobileNumber by remember { mutableStateOf(userEntity.mobileNumber) }

    Column {
        Row(
            modifier = Modifier.fillMaxWidth().
            padding(top = 15.dp),
            horizontalArrangement = Arrangement.Absolute.Center
        ) {
            Text(text = "Update User Information")
        }
        Row(
            modifier = Modifier.padding(
                top = 25.dp,
                start = 15.dp,
                end = 15.dp
            )
        ) {

            UserName (userEntity = userEntity,  { username = it })
        }
        Row(
            modifier = Modifier.padding(
                top = 15.dp,
                start = 15.dp,
                end = 15.dp
            )
        ) {
            MobileNumber (userEntity = userEntity) {
                mobileNumber = it
            }
        }
        Row(
            modifier = Modifier.padding(bottom = 25.dp, top = 35.dp)
        ) {
            UpdateButton(closeBottonsheet,userEntity, hiltViewModel(), username, mobileNumber)
            { enteredUsername, enteredPassword ->
            }
        }

    }
    
}
