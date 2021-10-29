package com.corentinach.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var clickButton: Button
    private lateinit var computeButton: Button
    private lateinit var textView: TextView
    private var nbClick = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButton = findViewById(R.id.btn_click_me)
        clickButton.setOnClickListener(this)
        textView = findViewById(R.id.text_view)
        computeButton = findViewById(R.id.btn_compute)
        computeButton.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        Toast.makeText(baseContext, "Tu m'as cliqué", Toast.LENGTH_LONG).show()
        nbClick++
        val newText = "Cliquez moi $nbClick"
        clickButton.text = newText
        textView.text = getString(R.string.you_have_clicked, nbClick)

        if (nbClick > 4) {
            clickButton.isEnabled = false
        }
    }


}
