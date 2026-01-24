package com.safelink.shared.domain.usecase

import com.safelink.shared.domain.model.Contact
import com.safelink.shared.domain.repository.ContactRepository

class AddContactUseCase(
    private val repository: ContactRepository
) {
    suspend operator fun invoke(contact: Contact) {
        if (contact.name.isBlank()) throw IllegalArgumentException("Contact name cannot be empty")
        if (contact.phoneNumber.isBlank()) throw IllegalArgumentException("Contact phone cannot be empty")
        repository.addContact(contact)
    }
}
