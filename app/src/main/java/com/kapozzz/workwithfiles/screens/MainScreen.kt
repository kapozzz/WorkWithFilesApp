package com.kapozzz.workwithfiles.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            text = "File saving methods",
            textAlign = TextAlign.Center,
            fontSize = 36.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
        TextButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary),
            onClick = {
                navController.navigate("textScreen")
            }) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Save text",
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        TextButton(
            modifier = Modifier
                .padding(top = 16.dp)
                .background(MaterialTheme.colorScheme.primary),
            onClick = {
                navController.navigate("imageScreen")
            }) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Save image",
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}