package com.safelink.shared.domain.usecase

import com.safelink.shared.domain.repository.ContactRepository

class DeleteContactUseCase(
    private val repository: ContactRepository
) {
    suspend operator fun invoke(id: Long) {
        repository.deleteContact(id)
    }
}
