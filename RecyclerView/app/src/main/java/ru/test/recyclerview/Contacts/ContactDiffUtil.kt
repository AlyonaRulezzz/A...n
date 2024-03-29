package ru.test.recyclerview.contacts

import androidx.recyclerview.widget.DiffUtil

class ContactDiffUtil(private val oldContactList: MutableList<ContactDataClass>,
                      private val newContactList: List<ContactDataClass>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int  = oldContactList.size

    override fun getNewListSize(): Int = newContactList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldContactList[oldItemPosition] == newContactList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldContactList[oldItemPosition].contactId != newContactList[newItemPosition].contactId -> false
            oldContactList[oldItemPosition].contactName != newContactList[newItemPosition].contactName -> false
            oldContactList[oldItemPosition].contactSurname != newContactList[newItemPosition].contactSurname -> false
            oldContactList[oldItemPosition].contactPhone != newContactList[newItemPosition].contactPhone -> false
            oldContactList[oldItemPosition].contactIsChecked != newContactList[newItemPosition].contactIsChecked -> false
            else -> true
        }
    }
}