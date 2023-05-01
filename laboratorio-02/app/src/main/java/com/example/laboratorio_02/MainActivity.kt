package com.example.laboratorio_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var weigthEditText : EditText
    private lateinit var heightEditText : EditText
    private lateinit var acctionButton: Button
    private lateinit var bmiTextView: TextView
    private lateinit var resultText: TextView
    private lateinit var infoTextView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        setListener()
    }

    private fun bind(){
        weigthEditText = findViewById(R.id.weight_edit)
        heightEditText = findViewById(R.id.height_edit)
        acctionButton = findViewById(R.id.acction_calculate)
        bmiTextView = findViewById(R.id.bmi_text_view)
        resultText = findViewById(R.id.result_text_view)
        infoTextView = findViewById(R.id.info_text_view)

    }

    private fun setListener() {
        acctionButton.setOnClickListener{

            val weigth = weigthEditText.text.toString()
            val height = heightEditText.text.toString()

            if (!validateInput(weigth, height)){
                clearTextView()
                return@setOnClickListener
            }

            val bmi = calculateBmi(weigth.toFloat(), height.toFloat())
            val  bmiTwoDigits = String.format("%.2f", bmi).toFloat()

            clearFocus()
            displayResult(bmiTwoDigits)
        }
    }

    private fun calculateBmi(weigth: Float, height: Float): Float{
        return weigth / ((height/100) * (height/100))
    }

    private fun displayResult(bmi: Float) {
        bmiTextView.text = bmi.toString()
        infoTextView.text = "(Normal range is 18.00 to 24.9)"

        var informationResult = ""
        var color = 0

        when {
            bmi < 18.5 -> {
                informationResult = "Underweight"
                color = R.color.under_weight
            }
            bmi in 18.5..24.99 -> {
                informationResult = "Healthy"
                color = R.color.normal_weight
            }
            bmi in 25.0..29.99 -> {
                informationResult = "Overweight"
                color = R.color.over_weight
            }
            bmi > 30.00 -> {
                informationResult = "Obese"
                color = R.color.obese
            }
        }

        resultText.text = informationResult
        resultText.setTextColor(ContextCompat.getColor(this,color))
    }

    private fun clearFocus() {
        weigthEditText.clearFocus()
        heightEditText.clearFocus()
    }

    private fun clearTextView() {
        bmiTextView.text = ""
        resultText.text = ""
        infoTextView.text = ""
    }

    private fun validateInput(weigth: String?, height: String?): Boolean{
        when {
            weigth.isNullOrEmpty() -> {
                Toast.makeText(this, "Weight is empty!!", Toast.LENGTH_SHORT).show()
                return false
            }
            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty!!", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        return true
    }
}