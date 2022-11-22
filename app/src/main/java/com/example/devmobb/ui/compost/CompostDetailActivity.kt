package com.example.devmobb.ui.compost

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.devmobb.R
import compostSelected

class CompostDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compost_detail)
        val compost = intent.getStringExtra("compost")
        val CompostDesignation = findViewById<TextView>(R.id.name_txt)
        val buttonOpen = findViewById<Button>(R.id.btn_map)

        CompostDesignation.text = compost

        compostSelected?.let {compost ->
            CompostDesignation.text = compost.designation

            buttonOpen.setOnClickListener {
                // Display a label at the location of Google's Sydney office
                val gmmIntentUri =
                    Uri.parse("geo:0,0?q=${compost.latitude},${compost.longitude}(${compost.designation})")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            }
        }
    }


}