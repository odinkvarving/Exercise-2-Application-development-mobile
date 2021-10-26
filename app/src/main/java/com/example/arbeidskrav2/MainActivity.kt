package com.example.arbeidskrav2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val upperLimit = 100

    private var generatedNumber1 = 0
    private var generatedNumber2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button_generate_numbers)
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val randomNumber1 = (0..100).random()
                val randomNumber2 = (0..100).random()
                val intent = Intent("com.example.arbeidskrav2.GenerateNumberActivity")
                intent.putExtra("randomNumber1", randomNumber1)
                intent.putExtra("randomNumber2", randomNumber2)
                startActivityForResult(intent, 5)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == 6) {
            if (data != null) {
                generatedNumber1 = data.getIntExtra("random number 1", 0)
                generatedNumber2 = data.getIntExtra("random number 2", 0)
                Log.d("Generated numbers: ", "$generatedNumber1 $generatedNumber2")
            }
        }else{
            Log.d("Wrong result code", resultCode.toString())
        }
    }

    fun onClickStartGenerateNumbersActivity(v: View?) {
        val randomNumber1 = (0..100).random()
        val randomNumber2 = (0..100).random()
        val intent = Intent("com.example.arbeidskrav2.GenerateNumberActivity")
        intent.putExtra("randomNumber1", randomNumber1)
        intent.putExtra("randomNumber2", randomNumber2)
        startActivityForResult(intent, 5)
    }

    fun onClickStartCalculatorActivity(v: View?) {
        val intent = Intent("com.example.arbeidskrav2.CalculatorActivity")
        intent.putExtra("generated1", generatedNumber1)
        intent.putExtra("generated2", generatedNumber2)
        intent.putExtra("UpperLimit", upperLimit)
        startActivity(intent)
    }
}