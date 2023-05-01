package com.example.laboratorio04cabanas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText
    private lateinit var numberEditText: TextInputEditText
    private lateinit var actionNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        actionNext.setOnClickListener{ actionNext()}
    }

    fun bind() {
        nameEditText = findViewById(R.id.nameText)
        emailEditText = findViewById(R.id.emailText)
        numberEditText = findViewById(R.id.numberText)
        actionNext = findViewById(R.id.actionNext)
    }

    fun actionNext() {
        val intent = Intent(this, ShareActivity::class.java)
        intent.putExtra(SHARE_VALUE1, nameEditText.text.toString())
        intent.putExtra(SHARE_VALUE2, emailEditText.text.toString())
        intent.putExtra(SHARE_VALUE3, numberEditText.text.toString())
        startActivity(intent)
    }

    companion object {
        const val SHARE_VALUE1 = "name"
        const val SHARE_VALUE2 = "email"
        const val SHARE_VALUE3 = "number"
    }
}