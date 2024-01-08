package com.sadeeq.encoders.roominjetpackcompose.components

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sadeeq.encoders.roominjetpackcompose.R
import com.sadeeq.encoders.roominjetpackcompose.entity.UserEnitity
import com.sadeeq.encoders.roominjetpackcompose.viewmodel.ViewModel

@Composable
fun MyButton(
    viewModel: ViewModel = hiltViewModel(),
    username: String,
    mobileNumber: String,
    onClick: (String, String) -> Unit
) {
    val context = LocalContext.current

    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.purple_200)
        ), onClick = {
            if (username.isEmpty()) {
                Toast.makeText(context, "Username: is Empty", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.insertData(UserEnitity(name = username, mobileNumber = mobileNumber))
                Toast.makeText(
                    context, "Username: $username\nPassword: $mobileNumber", Toast.LENGTH_SHORT
                ).show()

            }
        },

        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(10.dp)
            .border(1.dp, MaterialTheme.colorScheme.primaryContainer, CircleShape)
    ) {


        Spacer(Modifier.padding(10.dp))
        Text(
            "Save User", style = MaterialTheme.typography.titleSmall.copy(color = Color.White)
        )
    }

}

@Composable
@Preview
fun showButton() {

}
