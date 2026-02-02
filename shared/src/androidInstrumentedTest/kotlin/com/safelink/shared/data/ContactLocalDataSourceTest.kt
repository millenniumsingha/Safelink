package com.safelink.shared.data

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.safelink.shared.cache.SafeLinkDatabase
import com.safelink.shared.data.datasource.ContactLocalDataSource
import com.safelink.shared.domain.model.Contact
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ContactLocalDataSourceTest {

    private lateinit var database: SafeLinkDatabase
    private lateinit var dataSource: ContactLocalDataSource

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val driver = AndroidSqliteDriver(SafeLinkDatabase.Schema, context, null) // In-memory
        database = SafeLinkDatabase(driver)
        dataSource = ContactLocalDataSource(database)
    }

    @Test
    fun insertAndRetrieveContact() = runBlocking {
        val contact = Contact(id = 1, name = "Integration Test User", phoneNumber = "9998887777", isEmergencyContact = true)
        
        dataSource.insertContact(contact)
        
        val contacts = dataSource.getContacts().first()
        assertEquals(1, contacts.size)
        assertEquals("Integration Test User", contacts[0].name)
    }
}
