package ru.test.recyclerview.contacts

import android.provider.ContactsContract

data class ContactDataClass(var contactId: Int, var contactName: String,
                            var contactSurname: String, var contactPhone: String,
//                            var contactPhone: ContactsContract.CommonDataKinds.Phone,
                            var contactIsChecked: Boolean)
