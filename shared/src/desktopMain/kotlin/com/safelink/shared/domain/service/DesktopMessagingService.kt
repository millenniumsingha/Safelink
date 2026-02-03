package com.safelink.shared.domain.service

import com.safelink.shared.domain.model.Contact
import java.awt.Desktop
import java.net.URI
import java.net.URLEncoder
import javax.swing.JOptionPane

class DesktopMessagingService : MessagingService {
    override suspend fun sendSms(contact: Contact, message: String) {
        // Show notification popup
        JOptionPane.showMessageDialog(
            null,
            "🚨 SOS Alert Triggered!\n\n" +
                "Contact: ${contact.name}\n" +
                "Phone: ${contact.phoneNumber}\n\n" +
                "Message: $message\n\n" +
                "Opening email client to send alert...",
            "SafeLink SOS Alert",
            JOptionPane.WARNING_MESSAGE
        )
        
        // Open default email client with pre-composed emergency email
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.MAIL)) {
                val subject = URLEncoder.encode("🚨 EMERGENCY SOS ALERT - SafeLink", "UTF-8").replace("+", "%20")
                val body = URLEncoder.encode(
                    """
                    EMERGENCY SOS ALERT
                    
                    This is an automated emergency alert from SafeLink.
                    
                    Emergency Contact: ${contact.name}
                    Phone Number: ${contact.phoneNumber}
                    
                    Message: $message
                    
                    Please respond immediately or contact emergency services.
                    
                    ---
                    Sent via SafeLink Emergency Alert System
                    """.trimIndent(),
                    "UTF-8"
                ).replace("+", "%20")
                
                // Note: The user needs to add the recipient email in their mail client
                // We can't send to phone numbers via email without an SMS gateway
                val mailUri = URI("mailto:?subject=$subject&body=$body")
                Desktop.getDesktop().mail(mailUri)
            }
        } catch (e: Exception) {
            JOptionPane.showMessageDialog(
                null,
                "Could not open email client: ${e.message}\n\nPlease manually contact ${contact.name} at ${contact.phoneNumber}",
                "Email Error",
                JOptionPane.ERROR_MESSAGE
            )
        }
    }
}
