package com.corentinach.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.corentinach.activities.databinding.ComputeActivityBinding

class ComputeActivity : AppCompatActivity(), TextWatcher {
    private lateinit var binding: ComputeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ComputeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.field1.addTextChangedListener(this)
        binding.field2.addTextChangedListener(this)
        binding.btnCalculer.setOnClickListener {
            var numberResult =
                (binding.field1.text.toString().toDouble() + binding.field2.text.toString().toDouble()).toString()
            binding.resultat.text = numberResult
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        binding.btnCalculer.isEnabled = binding.field1.text.isNotBlank() && binding.field2.text.isNotBlank()
    }
}
