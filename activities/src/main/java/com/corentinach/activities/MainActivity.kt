package com.corentinach.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var clickButton: Button
    private var nbClick = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButton = findViewById(R.id.btn_click_me)
        clickButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Toast.makeText(baseContext, "Tu m'as cliqué", Toast.LENGTH_LONG).show()
        nbClick++
        val newText = "Cliquez moi $nbClick"
        clickButton.text = newText
    }
}
