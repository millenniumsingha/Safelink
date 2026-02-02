package com.safelink.shared.domain

import com.safelink.shared.domain.model.Contact
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ContactTest {

    @Test
    fun `contact with valid phone should be valid`() {
        val contact = Contact(id = 1, name = "Test User", phoneNumber = "1234567890", isEmergencyContact = true)
        assertTrue(contact.phoneNumber.length >= 10, "Phone number should be at least 10 digits")
    }

    @Test
    fun `contact defaults check`() {
        val contact = Contact(id = 2, name = "Partial", phoneNumber = "555", isEmergencyContact = true)
        assertTrue(contact.isEmergencyContact, "Emergency contact should be true when set") 
    }
}
