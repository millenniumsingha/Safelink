package com.safelink.shared.domain.service

import android.annotation.SuppressLint

import android.content.Context
import android.telephony.SmsManager
import com.safelink.shared.domain.model.Contact

class AndroidMessagingService(private val context: Context) : MessagingService {
    @SuppressLint("MissingPermission")
    override suspend fun sendSms(contact: Contact, message: String) {
        try {
            val smsManager = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                context.getSystemService(SmsManager::class.java)
            } else {
                @Suppress("DEPRECATION")
                SmsManager.getDefault()
            }
            smsManager.sendTextMessage(contact.phoneNumber, null, message, null, null)
        } catch (e: Exception) {
            e.printStackTrace()
            throw e // Re-throw to let UI handle the error
        }
    }
}
