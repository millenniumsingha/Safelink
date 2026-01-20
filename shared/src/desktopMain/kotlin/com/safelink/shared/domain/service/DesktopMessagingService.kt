package com.safelink.shared.domain.service

import com.safelink.shared.domain.model.Contact

class DesktopMessagingService : MessagingService {
    override suspend fun sendSms(contact: Contact, message: String) {
        println("Desktop Messaging Stub: Sending SMS to ${contact.phoneNumber}: $message")
    }
}
