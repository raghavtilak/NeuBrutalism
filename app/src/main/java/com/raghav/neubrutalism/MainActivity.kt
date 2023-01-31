package com.raghav.neubrutalism

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val neubutton = findViewById<NeuBrutalismView>(R.id.neubrutview)

        neubutton.setOnClickListener {
            Log.d("TAG","Onclick")
        }

        neubutton.bg_shadowColor = Color.BLUE
    }
}