package com.safelink.shared.domain.service

import com.safelink.shared.domain.model.Contact
import platform.Foundation.NSLog

class IosMessagingService : MessagingService {
    override suspend fun sendSms(contact: Contact, message: String) {
        // Stub: In real app, use MFMessageComposeViewController
        NSLog("Simulating SMS to ${contact.phoneNumber}: $message")
    }
}
