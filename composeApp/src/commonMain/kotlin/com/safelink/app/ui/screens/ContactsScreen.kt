package com.safelink.app.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.safelink.app.ui.components.ContactCard
import com.safelink.app.ui.navigation.Routes
import com.safelink.shared.domain.usecase.DeleteContactUseCase
import com.safelink.shared.domain.usecase.GetContactsUseCase
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsScreen(
    navController: NavController
) {
    val getContacts: GetContactsUseCase = koinInject()
    val deleteContact: DeleteContactUseCase = koinInject()
    val scope = rememberCoroutineScope()
    
    // In a real app, use a ViewModel. Here we collect directly for simplicity in Phase 2.
    val contacts by getContacts().collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Emergency Contacts") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Routes.AddContact) }) {
                Icon(Icons.Default.Add, contentDescription = "Add Contact")
            }
        }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items(contacts) { contact ->
                ContactCard(
                    contact = contact,
                    onDelete = {
                        scope.launch {
                            val id = contact.id ?: return@launch
                            deleteContact(id)
                        }
                    }
                )
            }
        }
    }
}
