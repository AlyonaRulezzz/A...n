package ru.test.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.test.recyclerview.Countries.CountryAdapterClass
import ru.test.recyclerview.Countries.CountryDataClass

class MainActivity : AppCompatActivity() {

    private lateinit var countryRecyclerView: RecyclerView
    private lateinit var countryDataList: ArrayList<CountryDataClass>

    val countryIdList = IntArray(31) { it + 1 }

    val countryFlagList = arrayOf(
        R.drawable.afganistan,
        R.drawable.albania,
        R.drawable.andorra,
        R.drawable.austria,
        R.drawable.australia,
        R.drawable.argentina,
        R.drawable.bahrain,
        R.drawable.belarus,
        R.drawable.brasil,
        R.drawable.canada,
        R.drawable.cape_verde,
        R.drawable.china,
        R.drawable.dania,
        R.drawable.egypt,
        R.drawable.estonia,
        R.drawable.finland,
        R.drawable.france,
        R.drawable.germany,
        R.drawable.india,
        R.drawable.ireland,
        R.drawable.italia,
        R.drawable.japon,
        R.drawable.litva,
        R.drawable.nepal,
        R.drawable.north_corea,
        R.drawable.norway,
        R.drawable.romania,
        R.drawable.russia,
        R.drawable.senegal,
        R.drawable.spain,
        R.drawable.usa
    )

    val countryNameList = arrayOf(
        "Afganistan", "Albania", "Andorra", "Austria", "Australia", "Argentina",
        "Bahrain", "Belarus", "Brazil", "Canada", "Cape Verde", "China", "Dania",
        "Egypt", "Estonia", "Finland", "France", "Germany",
        "India", "Ireland", "Italia", "Japan", "Litva",
        "Nepal", "North Corea", "Norway",
        "Romania", "Russia", "Senegal", "Spain", "USA"

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryRecyclerView = findViewById(R.id.rv_country)
        countryRecyclerView.layoutManager = LinearLayoutManager(this)
        countryRecyclerView.setHasFixedSize(true) // for UNmutable size of recyclerView only, for less push on CPU

        countryDataList = arrayListOf()
        getData()
    }

    private fun getData() {
        for (i in countryFlagList.indices) {
            val countryDataClass = CountryDataClass(countryFlagList[i], countryNameList[i], countryIdList[i])
            countryDataList.add(countryDataClass)
        }
        countryRecyclerView.adapter = CountryAdapterClass(countryDataList)
    }
}