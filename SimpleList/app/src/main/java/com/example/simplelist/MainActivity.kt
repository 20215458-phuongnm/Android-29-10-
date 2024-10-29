package com.example.simplelist


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumber: EditText
    private lateinit var buttonShow: Button
    private lateinit var listViewNumbers: ListView
    private lateinit var textViewError: TextView
    private lateinit var radioGroup: RadioGroup

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber = findViewById(R.id.editTextNumber)
        buttonShow = findViewById(R.id.buttonShow)
        listViewNumbers = findViewById(R.id.listViewNumbers)
        textViewError = findViewById(R.id.textViewError)
        radioGroup = findViewById(R.id.radioGroup)

        buttonShow.setOnClickListener {
            displayNumbers()
        }
    }

    private fun displayNumbers() {
        val inputText = editTextNumber.text.toString()
        if (inputText.isEmpty() || inputText.toInt() <= 0) {
            textViewError.text = "Vui lòng nhập số nguyên dương!"
            textViewError.visibility = View.VISIBLE
            return
        }

        val n = inputText.toInt()
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        val numbers = mutableListOf<Int>()

        when (selectedRadioButtonId) {
            R.id.radioEven -> {
                for (i in 0..n step 2) {
                    numbers.add(i)
                }
            }
            R.id.radioOdd -> {
                for (i in 1..n step 2) {
                    numbers.add(i)
                }
            }
            R.id.radioSquare -> {
                for (i in 0..n) {
                    val square = i * i
                    if (square <= n) {
                        numbers.add(square)
                    }
                }
            }
            else -> {
                textViewError.text = "Vui lòng chọn loại số!"
                textViewError.visibility = View.VISIBLE
                return
            }
        }

        textViewError.visibility = View.GONE
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, numbers)
        listViewNumbers.adapter = adapter
    }
}
