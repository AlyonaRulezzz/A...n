package ru.test.recyclerview.countries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.test.recyclerview.R
import ru.test.recyclerview.databinding.CountryItemLayoutBinding

class CountryAdapterClass(private val countryDataList: ArrayList<CountryDataClass>) :
    RecyclerView.Adapter<CountryAdapterClass.CountryViewHolderClass>() {

    class CountryViewHolderClass(private val binding: CountryItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
        val rvCountryFlag = binding.ivCountryFlag
        val rvCountryName = binding.tvCountryName
        val rvCountryId = binding.tvCountryId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolderClass {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.country_item_layout, parent, false)
        val binding = CountryItemLayoutBinding.bind(item)
        return CountryViewHolderClass(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolderClass, position: Int) {
        val currentItem = countryDataList[position]
        holder.rvCountryFlag.setImageResource(currentItem.countryDataImage)
        holder.rvCountryName.text = currentItem.countryDataName
        holder.rvCountryId.text = currentItem.countryDataId.toString()
    }

    override fun getItemCount(): Int {
        return countryDataList.size
    }
}