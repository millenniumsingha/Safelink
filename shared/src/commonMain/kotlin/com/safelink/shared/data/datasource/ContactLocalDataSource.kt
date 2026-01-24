package com.safelink.shared.data.datasource

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.safelink.shared.cache.SafeLinkDatabase
import com.safelink.shared.domain.model.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ContactLocalDataSource(db: SafeLinkDatabase) {
    private val queries = db.contactQueries

    fun getContacts(): Flow<List<Contact>> {
        return queries.getContacts()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { entities ->
                entities.map { entity ->
                    Contact(
                        id = entity.id,
                        name = entity.name,
                        phoneNumber = entity.phoneNumber,
                        isEmergencyContact = entity.isEmergencyContact
                    )
                }
            }
    }

    suspend fun insertContact(contact: Contact) {
        queries.insertContact(
            id = contact.id,
            name = contact.name,
            phoneNumber = contact.phoneNumber,
            isEmergencyContact = contact.isEmergencyContact
        )
    }

    suspend fun deleteContact(id: Long) {
        queries.deleteContactById(id)
    }
}
