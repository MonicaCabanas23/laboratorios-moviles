package com.example.laboratorio_03_cabaas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var fiveCents : ImageView
    private lateinit var tenCents : ImageView
    private lateinit var quarter : ImageView
    private lateinit var oneDollar : ImageView
    private lateinit var cashTextView : TextView
    private var cash = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        listeners()
    }

    fun bind() {
        fiveCents = findViewById(R.id.five_cents)
        tenCents = findViewById(R.id.ten_cents)
        quarter = findViewById(R.id.quarter)
        oneDollar = findViewById(R.id.dollar)
        cashTextView = findViewById(R.id.cash_textView)
    }

    fun listeners() {
        fiveCents.setOnClickListener{
            cash += 0.05
            cash = String.format("%.2f", cash).toDouble()

            cashTextView.text = "$${cash}"
        }

        tenCents.setOnClickListener{
            cash += 0.10
            cash = String.format("%.2f", cash).toDouble()

            cashTextView.text = "$${cash}"
        }

        quarter.setOnClickListener{
            cash += 0.25
            cash = String.format("%.2f", cash).toDouble()

            cashTextView.text = "$${cash}"
        }

        oneDollar.setOnClickListener{
            cash += 1.00
            cash = String.format("%.2f", cash).toDouble()

            cashTextView.text = "$${cash}"
        }


    }
}