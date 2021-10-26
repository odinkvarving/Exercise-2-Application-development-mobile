package com.example.arbeidskrav2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    var firstNumberValue = 0
    var secondNumberValue = 0
    var answerValue = 0
    var upperLimitValue = 0

    var generated1 = 0
    var generated2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        upperLimitValue = intent.getIntExtra("UpperLimit", 0)

        generated1 = intent.getIntExtra("generated1", 0)
        generated2 = intent.getIntExtra("generated2", 0)

        Log.d("UPPER LIMIT", upperLimitValue.toString())
        Log.d("GENERATED NUMBERS", "$generated1 $generated2")

        val firstNumberText = findViewById<TextView>(R.id.number1)
        firstNumberText.setText("3").toString()
        firstNumberValue = Integer.parseInt(firstNumberText.text.toString())

        val secondNumberText = findViewById<TextView>(R.id.number2)
        secondNumberText.setText("5").toString()
        secondNumberValue = Integer.parseInt(secondNumberText.text.toString())

        val answer = findViewById<EditText>(R.id.EditSvar)
        answerValue = Integer.parseInt(answer.text.toString())

        Log.d("First initial value: ", firstNumberText.text.toString())
        Log.d("Second initial value: ", secondNumberText.text.toString())
        Log.d("Initial answer value: ", answerValue.toString())
    }

    fun createRandomNumbers() {
        val firstNumberText = findViewById<TextView>(R.id.number1)
        firstNumberText.setText(generated1.toString())
        firstNumberValue = Integer.parseInt(firstNumberText.text.toString())

        val secondNumberText = findViewById<TextView>(R.id.number2)
        secondNumberText.setText(generated2.toString())
        secondNumberValue = Integer.parseInt(secondNumberText.text.toString())

        val upperLimit = findViewById<EditText>(R.id.EditØvreGrense)
        upperLimitValue = Integer.parseInt(upperLimit.text.toString())
    }

    fun onClickAddButton(v: View?) {
        val answer = findViewById<EditText>(R.id.EditSvar)
        answerValue = Integer.parseInt(answer.text.toString())

        val correctIfAddition: Boolean = answerValue == (firstNumberValue + secondNumberValue)
        Log.d("BOOLEAN: ", correctIfAddition.toString())
        Log.d("ADDITION: ", (firstNumberValue + secondNumberValue).toString())

        if(correctIfAddition) {
            Log.d("Riktig", getString(R.string.Riktig))
            //Toast.makeText(applicationContext, "Test", Toast.LENGTH_LONG).show()
        }else{
            Log.d("Feil", getString(R.string.Feil) + " " + (firstNumberValue * secondNumberValue))
            //Toast.makeText(applicationContext, getString(R.string.Feil) + (firstNumberValue * secondNumberValue), Toast.LENGTH_LONG).show()
        }
        createRandomNumbers()
    }

    fun onClickMultiplyButton(v: View?) {

        val correctIfMultiplication: Boolean = answerValue == (firstNumberValue * secondNumberValue)

        if(correctIfMultiplication) {
            Log.d("Riktig", getString(R.string.Riktig))
            //Toast.makeText(this, R.string.Riktig, Toast.LENGTH_LONG).show()

        }else {
            Log.d("Feil", getString(R.string.Feil) + " " + (firstNumberValue + secondNumberValue))
            //Toast.makeText(this, R.string.Feil + (firstNumberValue + secondNumberValue), Toast.LENGTH_LONG).show()
        }
        createRandomNumbers()
        val answer = findViewById<EditText>(R.id.EditSvar)
        answerValue = Integer.parseInt(answer.text.toString())
    }

    fun onClickAvsluttAktivitet(v: View?) {

        finish()
    }
}