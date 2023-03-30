package com.example.searchexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import com.example.searchexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //declare binding to assist in accessing views directly using their ids.
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initialize binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // initializing list and adding data to list
        val counties = arrayOf(
            "Nairobi",
            "Murang'a",
            "Kiambu",
            "Machakos",
            "Kitui",
            "Embu",
            "Meru",
            "Kirinyaga",
            "Nyeri",
            "Isiolo",
            "Mandera",
            "Garissa",
            "Wajir",
            "TanaRiver",
            "Marsabit",
            "Taita/Taveta",
            "Makueni",
            "Lamu",
            "Kilifi",
            "Kwale",
            "Mombasa",
            "Tharaka-Nithi",
            "Turkana",
            "Samburu",
            "West Pokot",
            "Nyandarua",
            "Laikipia",
            "Narok",
            "Kajiado",
            "Tranzoia",
            "Uasin Gishu",
            "Bomet",
            "Kakamega",
            "Vihiga",
            "Nandi",
            "Elgeyo/Marakwet",
            "Busia",
            "Bungoma",
            "Siaya",
            "Kisumu",
            "Migori",
            "Kisii",
            "Homabay",
            "Nyamira",
            "Kericho"
        )

        // on below line we are craeting the adapter
        // listener for our search view.
        val countyAdapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, counties)

        //attach the adapter to the listView
        binding.userList.adapter = countyAdapter

        binding.searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            //it is called when the user presses the search after writing certain characters inside the searchView
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                if (counties.contains(query)){
                    countyAdapter.filter
                }
                return false
            }
            //it is called when a user enters a new chacter
            override fun onQueryTextChange(newText: String?): Boolean {
                countyAdapter.filter.filter(newText)
                return false
            }

        })


    }
}