package ru.test.recyclerview.Countries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.test.recyclerview.R

class CountryAdapterClass(private val countryDataList: ArrayList<CountryDataClass>) :
    RecyclerView.Adapter<CountryAdapterClass.CountryViewHolderClass>() {

    class CountryViewHolderClass(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
        val rvCountryFlag = itemView.findViewById<ImageView>(R.id.iv_country_flag)
        val rvCountryName = itemView.findViewById<TextView>(R.id.tv_country_name)
        val rvCountryId = itemView.findViewById<TextView>(R.id.tv_country_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolderClass {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return CountryViewHolderClass(item)
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