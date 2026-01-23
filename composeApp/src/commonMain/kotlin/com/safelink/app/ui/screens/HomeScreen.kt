package com.safelink.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.safelink.app.ui.components.SOSButton
import com.safelink.app.ui.navigation.Routes
import com.safelink.shared.domain.usecase.SendEmergencyAlertUseCase
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {
    val sendEmergencyAlert: SendEmergencyAlertUseCase = koinInject()
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("SafeLink") },
                actions = {
                    IconButton(onClick = { navController.navigate(Routes.Contacts) }) {
                        Icon(Icons.Default.Person, contentDescription = "Contacts")
                    }
                    IconButton(onClick = { navController.navigate(Routes.Settings) }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Press and hold to send alert")
            Spacer(modifier = Modifier.height(32.dp))
            SOSButton(
                onClick = {
                    scope.launch {
                        try {
                            sendEmergencyAlert()
                            // TODO: Show success snackbar
                        } catch (e: Exception) {
                            // TODO: Show error
                        }
                    }
                }
            )
        }
    }
}
