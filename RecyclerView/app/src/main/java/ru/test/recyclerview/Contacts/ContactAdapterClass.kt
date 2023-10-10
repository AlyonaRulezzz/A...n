package ru.test.recyclerview.Contacts

import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.test.recyclerview.R
import ru.test.recyclerview.databinding.ContactItemLayoutBinding

class ContactAdapterClass(private val contactDataList: ArrayList<ContactDataClass>) :
    RecyclerView.Adapter<ContactAdapterClass.ContactViewHolderClass>() {

    class ContactViewHolderClass(private val binding: ContactItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val rvContactId = binding.contactId
        val rvContactName = binding.contactName
        val rvContactSurname = binding.contactSurname
        val rvContactPhone = binding.contactPhone
        val rvContactIsChecked = binding.contactIsChecked
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolderClass {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.contact_item_layout, parent, false)
        val binding = ContactItemLayoutBinding.bind(item)
        return ContactViewHolderClass(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolderClass, position: Int) {
        val currentItem = contactDataList[position]
        holder.apply {
            rvContactId.text = currentItem.contactId.toString()
            rvContactName.text = SpannableStringBuilder(currentItem.contactName)
            rvContactSurname.text = SpannableStringBuilder(currentItem.contactSurname)
            rvContactPhone.text = SpannableStringBuilder(currentItem.contactPhone.toString())
            rvContactIsChecked.isChecked = currentItem.contactIsChecked

        }
    }

    override fun getItemCount(): Int {
        return contactDataList.size
    }
}