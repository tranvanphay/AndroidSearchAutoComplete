package com.phaytran.objectfiltercustom

import android.graphics.Color
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    lateinit var adapter: RecyclerViewAdapter
    lateinit var countryrv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<SearchView>(R.id.country_search)

        countryrv = findViewById(R.id.country_rv)
        countryrv.layoutManager = LinearLayoutManager(countryrv.context)
        countryrv.setHasFixedSize(true)

        textView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })

        getListOfCountries()
    }

    private fun getListCountry():ArrayList<Country>{
        return arrayListOf<Country>(
            Country(0,"Viet Nam",R.drawable.vietnam),
            Country(1,"Trung Quoc",R.drawable.china),
            Country(2,"Han Quoc",R.drawable.korean),
            Country(3,"My",R.drawable.america),
            Country(3,"Singapore",R.drawable.singapo),
            Country(3,"Thai lan",R.drawable.thailand),
            Country(4,"Anh",R.drawable.england)
        )
    }

    private fun getListOfCountries() {
        adapter = RecyclerViewAdapter(getListCountry())
        countryrv.adapter = adapter
    }


}
