package com.sadeeq.encoders.roominjetpackcompose.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sadeeq.encoders.roominjetpackcompose.R
import com.sadeeq.encoders.roominjetpackcompose.entity.UserEnitity
import com.sadeeq.encoders.roominjetpackcompose.viewmodel.ViewModel


@Composable
fun UserCell(userEnitity: UserEnitity, viewModel: ViewModel) {
    val context = LocalContext.current
    var showSheet by remember { mutableStateOf(false) }
    if (showSheet) {
        BottomSheet(userEnitity) {
            showSheet = false
        }
    }

    Card(
        colors = CardDefaults.cardColors(
            colorResource(id = R.color.white)
        ),
        border = BorderStroke(1.dp, color = Color.Blue),
        modifier = Modifier
            .padding(top = 10.dp, start = 10.dp, end = 10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Row(modifier = Modifier
            .padding(all = 20.dp)
            .fillMaxWidth()
            .clickable {
                Toast.makeText(
                    context, "Username: ${userEnitity.name}\nPassword: ${userEnitity.mobileNumber}", Toast.LENGTH_SHORT
                ).show()
            }) {

            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = userEnitity.name,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = userEnitity.mobileNumber,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall,
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp
                )
            }

            Column {
                Spacer(modifier = Modifier.height(10.dp))
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = Color.Red,
                    modifier = Modifier.clickable {
                        viewModel.deleteData(userEnitity)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null,
                    tint = Color.Red,
                    modifier = Modifier.clickable {
                        showSheet = true
                    }
                )
            }

        }
    }

}

@Preview
@Composable
fun userPreview() {
    UserCell(
        UserEnitity(name = "Sadeq", mobileNumber = "123"),
        hiltViewModel()
    )
}