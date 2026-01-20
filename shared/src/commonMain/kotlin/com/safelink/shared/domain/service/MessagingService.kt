package com.safelink.shared.domain.service

import com.safelink.shared.domain.model.Contact

interface MessagingService {
    suspend fun sendSms(contact: Contact, message: String)
}
