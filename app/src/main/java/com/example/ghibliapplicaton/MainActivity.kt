package com.example.ghibliapplicaton

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // 映画の候補
    private val spinnerItems = arrayOf("風の谷のナウシカ", "ハウルの動く城" , "となりのトトロ")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner = findViewById<Spinner>(R.id.ghibliMovieSpinner)
        val ghibliMovieArrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, spinnerItems
        )
        ghibliMovieArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = ghibliMovieArrayAdapter

        val searchButton = findViewById<Button>(R.id.searchButton)
        // 検索ボタン押下時の処理
        searchButton.setOnClickListener{
            val selectedMovie = findViewById<TextView>(R.id.selectedMovie)
            if(selectedMovie!=null){
                selectedMovie.visibility = View.VISIBLE
                selectedMovie.text = spinner.selectedItem as String
            }
        }
    }
}