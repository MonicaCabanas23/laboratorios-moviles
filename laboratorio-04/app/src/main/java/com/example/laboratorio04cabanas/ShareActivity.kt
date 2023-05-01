package com.example.laboratorio04cabanas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ShareActivity : AppCompatActivity() {
    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var numberTextView: TextView
    private lateinit var shareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        bind()
        val name = intent.getStringExtra(MainActivity.SHARE_VALUE1).toString()
        val email = intent.getStringExtra(MainActivity.SHARE_VALUE2).toString()
        val number = intent.getStringExtra(MainActivity.SHARE_VALUE3).toString()

        nameTextView.text = "Nombre: ${name}";
        emailTextView.text = "Correo electrónico: ${email}";
        numberTextView.text = "Número de teléfono: ${number}";

        shareButton.setOnClickListener{ share() }
    }

    private fun bind() {
        nameTextView = findViewById(R.id.nameTextView)
        emailTextView = findViewById(R.id.emailTextView)
        numberTextView = findViewById(R.id.numberTextView)
        shareButton = findViewById(R.id.button)
    }

    private fun share() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}