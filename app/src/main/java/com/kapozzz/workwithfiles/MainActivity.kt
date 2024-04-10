package com.kapozzz.workwithfiles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kapozzz.workwithfiles.screens.MainScreen
import com.kapozzz.workwithfiles.screens.SaveTextScreen
import com.kapozzz.workwithfiles.ui.theme.WorkWithFilesTheme

class MainActivity : ComponentActivity() {

    private lateinit var internalFileProvider: InternalFileProvider
//    private lateinit var sharedFileProvider: SharedFileProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val internalFileProvider = InternalFileProvider(applicationContext).also {
            it.showAllFiles()
            it.clearOldestFiles()
        }

        setContent {

            val navController = rememberNavController()

            WorkWithFilesTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    NavHost(navController = navController, startDestination = "mainScreen") {
                        composable(route = "mainScreen") {
                            MainScreen(navController = navController)
                        }

                        composable(route = "textScreen") {
                            SaveTextScreen(
                                fileProvider = internalFileProvider,
                                onBackClick = {
                                    navController.popBackStack()
                                }
                            )
                        }

                        composable("imageScreen") {
//                            SaveImageScreen(
//                                fileProvider = internalFileProvider,
//                                onBackClick = {
//                                    navController.popBackStack()
//                                }
//                            )
                        }
                    }
                }
            }
        }
    }
}





















