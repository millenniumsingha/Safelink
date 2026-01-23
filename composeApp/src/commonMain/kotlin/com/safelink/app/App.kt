package com.safelink.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.safelink.app.ui.navigation.Routes
import com.safelink.app.ui.theme.SafeLinkTheme
import org.koin.compose.KoinContext

@Composable
fun App() {
    KoinContext {
        SafeLinkTheme {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = Routes.Home) {
                composable(Routes.Home) {
                    com.safelink.app.ui.screens.HomeScreen(navController)
                }
                composable(Routes.Contacts) {
                    com.safelink.app.ui.screens.ContactsScreen(navController)
                }
                composable(Routes.AddContact) {
                    com.safelink.app.ui.screens.AddContactScreen(navController)
                }
                composable(Routes.Settings) {
                    com.safelink.app.ui.screens.SettingsScreen(navController)
                }
            }
        }
    }
}
