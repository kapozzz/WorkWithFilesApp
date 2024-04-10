package com.kapozzz.workwithfiles.screens

import android.annotation.SuppressLint
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kapozzz.workwithfiles.FileProvider

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Composable
//fun SaveImageScreen(
//    fileProvider: FileProvider,
//    onBackClick: () -> Unit
//) {
//
//    val snackbarHostState = remember { SnackbarHostState() }
//
//    val launcher = rememberLauncherForActivityResult(
//        contract =
//        ActivityResultContracts.PickVisualMedia()
//    ) { uri: Uri? ->
//        fileProvider.saveFile(Bit)
//    }
//
//    Scaffold(
//        modifier = Modifier.fillMaxSize(),
//        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
//    ) {
//        val fileName = remember {
//            mutableStateOf("")
//        }
//
//        Box(modifier = Modifier.fillMaxSize()) {
//
//            val statusText = remember {
//                mutableStateOf("")
//            }
//
//            val currentText = remember {
//                mutableStateOf("")
//            }
//
//            Column(
//                modifier = Modifier
//                    .fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 32.dp, vertical = 16.dp),
//                    text = statusText.value,
//                    fontSize = 16.sp,
//                    textAlign = TextAlign.Start
//                )
//
//
//
//
//
//
//                Button(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 32.dp, vertical = 16.dp),
//                    onClick = {
//                        fileProvider.saveFile(currentText.value.toByteArray())?.let {
//                            fileName.value = it
//                            statusText.value = "Image successfully saved :3"
//                        } ?: { statusText.value = " Cannot save image :( " }
//                        Unit
//                    }) {
//                    Text(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(horizontal = 32.dp),
//                        text = "Save image",
//                        fontSize = 26.sp,
//                        textAlign = TextAlign.Center
//                    )
//                }
//                Button(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 32.dp, vertical = 16.dp),
//                    onClick = {
//                        fileProvider.getFromFile(fileName.value)?.let {
//                            currentText.value = String(it)
//                            statusText.value = "Image successfully received :3"
//                        } ?: { statusText.value = " Cannot get image :( " }
//                        Unit
//                    }) {
//                    Text(
//                        text = "Get image",
//                        fontSize = 26.sp,
//                        textAlign = TextAlign.Center
//                    )
//                }
//            }
//
//            IconButton(onClick = { onBackClick() }) {
//                Icon(
//                    modifier = Modifier
//                        .align(Alignment.BottomStart)
//                        .padding(24.dp)
//                        .background(MaterialTheme.colorScheme.onBackground),
//                    imageVector = Icons.Default.ArrowBack,
//                    contentDescription = null,
//                    tint = Color.Black
//                )
//            }
//
//
//        }
//    }
//}