package com.corentinach.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.corentinach.activities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var nbClick = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnClickMe.setOnClickListener(this)
        binding.btnCompute.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        Toast.makeText(baseContext, "Tu m'as cliqué", Toast.LENGTH_LONG).show()
        nbClick++
        val newText = "Cliquez moi $nbClick"
        binding.btnClickMe.text = newText
        binding.textView.text = getString(R.string.you_have_clicked, nbClick)

        if (nbClick > 4) {
            binding.btnClickMe.isEnabled = false
        }
    }


}
