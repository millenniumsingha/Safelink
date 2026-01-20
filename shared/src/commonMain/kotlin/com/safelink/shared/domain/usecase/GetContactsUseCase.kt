package com.safelink.shared.domain.usecase

import com.safelink.shared.domain.model.Contact
import com.safelink.shared.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow

class GetContactsUseCase(
    private val repository: ContactRepository
) {
    operator fun invoke(): Flow<List<Contact>> {
        return repository.getContacts()
    }
}
