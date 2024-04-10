package com.kapozzz.workwithfiles.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kapozzz.workwithfiles.InternalFileProvider

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SaveTextScreen(
    fileProvider: InternalFileProvider,
    onBackClick: () -> Unit
) {

    val snackbarHostState = remember { SnackbarHostState() }

    val saveInCache = remember {
        mutableStateOf(false)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) {

        val savedFileName = remember {
            mutableStateOf("")
        }

        val cachedFileName = remember {
            mutableStateOf("")
        }

        Box(modifier = Modifier.fillMaxSize()) {

            val statusText = remember {
                mutableStateOf("")
            }

            val currentText = remember {
                mutableStateOf("")
            }

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp, vertical = 16.dp),
                    text = statusText.value,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    value = currentText.value,
                    onValueChange = { currentText.value = it },
                    textStyle = TextStyle.Default.copy(
                        fontSize = 30.sp
                    )
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp, vertical = 16.dp),
                    onClick = {
                        fileProvider.saveFile(currentText.value.toByteArray())?.let {
                            if (saveInCache.value) cachedFileName.value = it else savedFileName.value = it
                            statusText.value = "File successfully saved :3"
                        } ?: { statusText.value = " Cannot save file :( " }
                        Unit
                    }) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp),
                        text = "Save text in file",
                        fontSize = 26.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp, vertical = 16.dp),
                    onClick = {
                        fileProvider.getFromFile(
                            if (saveInCache.value) cachedFileName.value else savedFileName.value
                        )?.let {
                            currentText.value = String(it)
                            statusText.value = "File successfully received :3"
                        } ?: { statusText.value = " Cannot get file :( " }
                        Unit
                    }) {
                    Text(
                        text = "Get text from file",
                        fontSize = 26.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 32.dp,
                            end = 32.dp,
                            top = 16.dp
                        ),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(end = 6.dp),
                        text = "Save file in cache?",
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                    Switch(
                        checked = saveInCache.value,
                        onCheckedChange = {
                            saveInCache.value = !saveInCache.value
                            fileProvider.saveInCache = saveInCache.value
                        }
                    )
                }
            }

            IconButton(onClick = { onBackClick() }) {
                Icon(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(24.dp)
                        .background(MaterialTheme.colorScheme.onBackground),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    }
}