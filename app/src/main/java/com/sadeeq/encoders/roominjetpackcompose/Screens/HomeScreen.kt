package com.sadeeq.encoders.roominjetpackcompose.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.sadeeq.encoders.roominjetpackcompose.R
import com.sadeeq.encoders.roominjetpackcompose.components.MobileNumber
import com.sadeeq.encoders.roominjetpackcompose.components.MyButton
import com.sadeeq.encoders.roominjetpackcompose.components.UserCell
import com.sadeeq.encoders.roominjetpackcompose.components.UserName
import com.sadeeq.encoders.roominjetpackcompose.entity.UserEnitity
import com.sadeeq.encoders.roominjetpackcompose.viewmodel.ViewModel


@Composable
fun HomeScreen(viewModel: ViewModel = hiltViewModel()) {
    var username by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }

    val userList: PagedList<UserEnitity>? by viewModel.userListLiveData.observeAsState()


    Column {
        Row(
            modifier = Modifier.padding(
                top = 15.dp,
                start = 15.dp,
                end = 15.dp
            )
        ) {
            UserName (userEntity = UserEnitity(name = "", mobileNumber = ""),  { username = it })
        }
        Row(
            modifier = Modifier.padding(
                top = 15.dp,
                start = 15.dp,
                end = 15.dp
            )
        ) {
            MobileNumber (userEntity = UserEnitity(name = "", mobileNumber = "")) {
                mobileNumber = it
            }
        }
        Row {
            MyButton(hiltViewModel(), username, mobileNumber)
            { enteredUsername, enteredPassword ->
            }
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .background(color = colorResource(id = R.color.white))
        ) {

            items(userList!!.size) { index ->
                UserCell(userList!![index]!!,viewModel)
            }

        }

    }
}