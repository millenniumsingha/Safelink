package com.safelink.shared.data.repository

import com.safelink.shared.data.datasource.ContactLocalDataSource
import com.safelink.shared.domain.model.Contact
import com.safelink.shared.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow

class ContactRepositoryImpl(
    private val dataSource: ContactLocalDataSource
) : ContactRepository {
    override fun getContacts(): Flow<List<Contact>> {
        return dataSource.getContacts()
    }

    override suspend fun addContact(contact: Contact) {
        dataSource.insertContact(contact)
    }

    override suspend fun deleteContact(id: Long) {
        dataSource.deleteContact(id)
    }
}
