package com.example.arbeidskrav2

import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import java.io.IOException

class GenerateNumberActivity : Activity(){
    private var randomNumber = 0
    private var randomNumber2 = 0
    private val duration = Toast.LENGTH_LONG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate_number)
        try {
            randomNumber = intent.getIntExtra("randomNumber1", 0)
            val number = findViewById<View>(R.id.rnd) as TextView
            number.setText(randomNumber.toString())

            randomNumber2 = intent.getIntExtra("randomNumber2", 0)
            val number2 = findViewById<View>(R.id.rnd2) as TextView
            number2.setText(randomNumber2.toString())
        }catch (e: IOException) {
            Toast.makeText(this, "Could not fetch random number", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    fun onClickAvsluttAktivitet(v: View?) {
        val intent = Intent("com.example.arbeidskrav2")
        intent.putExtra("random number 1", randomNumber)
        intent.putExtra("random number 2", randomNumber2)
        setResult(6, intent)
        finish()
    }

}
