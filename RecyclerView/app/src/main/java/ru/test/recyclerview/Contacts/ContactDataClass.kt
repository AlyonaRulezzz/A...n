package ru.test.recyclerview.Contacts

import android.provider.ContactsContract

data class ContactDataClass(var contactId: Int, var contactName: String,
                            var contactSurname: String, var contactPhone: ContactsContract.CommonDataKinds.Phone,
                            var contactIsChecked: Boolean)
