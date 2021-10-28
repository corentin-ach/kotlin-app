package com.corentinach.activities

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComputeActivity : AppCompatActivity(), TextWatcher {
    private lateinit var field1: EditText
    private lateinit var field2: EditText
    private lateinit var result: TextView
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)
        field1 = findViewById(R.id.field_1)
        field2 = findViewById(R.id.field_2)
        result = findViewById(R.id.resultat)
        button = findViewById(R.id.btn_calculer)
        field1.addTextChangedListener(this)
        field2.addTextChangedListener(this)
        button.setOnClickListener {
            var numberResult =
                (field1.text.toString().toDouble() + field2.text.toString().toDouble()).toString()
            result.text = numberResult
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        if (field1.text.isBlank()) {
            button.isEnabled = false
        } else if (field2.text.isBlank()) {
            button.isEnabled = false
        } else { button.isEnabled = true }
    }
}
