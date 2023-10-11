package ru.test.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.test.recyclerview.contacts.ContactAdapterClass
import ru.test.recyclerview.contacts.ContactDataClass
import ru.test.recyclerview.databinding.ActivityContactBinding

class ContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactBinding
    private lateinit var contactRecyclerView: RecyclerView
    private lateinit var contactDataList: MutableList<ContactDataClass>
    private lateinit var contactDataListBeforeChanges: MutableList<ContactDataClass>
    private val contactAdapter by lazy { ContactAdapterClass(contactDataList, contactDataListBeforeChanges) }

    private val contactIdList = mutableListOf(1, 2, 3)

    private val contactNameList = mutableListOf("Мария", "Максим", "Марина")
    private val contactSurnameList = mutableListOf("Марьина", "Максимов", "Маринина")
    private val contactPhoneList = mutableListOf("89990000001", "89990000002", "89990000003")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contactRecyclerView = binding.rvContact
        contactRecyclerView.layoutManager = LinearLayoutManager(this)

        contactDataList = mutableListOf()
        getData()
        contactDataListBeforeChanges = contactDataList.toMutableList()

        contactRecyclerView.adapter = contactAdapter

        binding.btnContactAdd.setOnClickListener {
            addContact()
            contactAdapter.setData(contactDataList)
        }

        binding.btnContactDelete.setOnClickListener {
            deleteContacts()
            contactAdapter.setData(contactDataList)
        }

    }

    private fun getData() {
        for (i in contactIdList.indices) {
            val contactDataClass = ContactDataClass(contactIdList[i], contactNameList[i], contactSurnameList[i],
                contactPhoneList[i], false)
            contactDataList.add(contactDataClass)
        }
    }

    fun goToMainActivity(view: View) {
        // Завершаем текущую активность и возвращаемся к предыдущей
        finish()
    }

    private fun addContact() {
        contactIdList.add(contactIdList.last() + 1)
        val newContact = ContactDataClass(contactIdList.last(), binding.etContactAddName.text.toString(),
            binding.etContactAddSurname.text.toString(), binding.etContactAddPhone.text.toString(),
            false)
        contactDataList.add(newContact)
        contactRecyclerView.smoothScrollToPosition(contactRecyclerView.bottom)
        println(contactDataList[2])
    }

    private fun deleteContacts() {
        contactDataList.removeAll { it.contactIsChecked }
//        println(contactDataListBeforeChanges.last())
//        println(contactDataList.last())
    }
}