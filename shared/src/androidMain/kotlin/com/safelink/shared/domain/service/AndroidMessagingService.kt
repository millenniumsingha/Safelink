package com.safelink.shared.domain.service

import android.content.Context
import android.telephony.SmsManager
import com.safelink.shared.domain.model.Contact

class AndroidMessagingService(private val context: Context) : MessagingService {
    override suspend fun sendSms(contact: Contact, message: String) {
        try {
            val smsManager = context.getSystemService(SmsManager::class.java)
            smsManager.sendTextMessage(contact.phoneNumber, null, message, null, null)
        } catch (e: Exception) {
            e.printStackTrace()
            // In a real app, handle permission errors or fallback
        }
    }
}
