package com.corentinach.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComputeActivity : AppCompatActivity() {
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
        button.setOnClickListener {
            var numberResult = (field1.text.toString().toInt() + field2.text.toString().toInt()).toString()
            result.text = numberResult
        }
    }
}
