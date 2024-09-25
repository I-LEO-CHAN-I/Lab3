package com.example.lab3

import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val stringInputField = findViewById<EditText>(R.id.editTextText)
        val charInputField = findViewById<EditText>(R.id.editTextText2)
        val charIndexText = findViewById<TextView>(R.id.textView)
        charInputField.filters = arrayOf(InputFilter.LengthFilter(1))

        stringInputField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (stringInputField.text.isNotEmpty() && charInputField.text.isNotEmpty()) {
                    FindIndex(stringInputField.text.toString(), charInputField.text.toString()[0])
                } else {
                    charIndexText.text = "Некорректный ввод"
                }
            }
        })

        charInputField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (stringInputField.text.isNotEmpty() && charInputField.text.isNotEmpty()) {
                    FindIndex(stringInputField.text.toString(), charInputField.text.toString()[0])
                } else {
                    charIndexText.text = "Некорректный ввод"
                }
            }
        })
    }

    fun FindIndex(string: String, char: Char) {
        val charIndexText = findViewById<TextView>(R.id.textView)
        var index : Int = -1
        for (i in string.length - 1 downTo 0) {
            if (string[i] == char) {
                index = i + 1;
                break
            }
        }

        if (index > 0) {
            charIndexText.text = "Последнее вхождение символа \nв строке: " + index.toString()
        } else {
            charIndexText.text = "Символ не найден"
        }
    }
}