package com.corentinach.applicationtp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image_view)
        button = findViewById(R.id.my_button)
        button.setOnClickListener(this)
        loadImage()
    }

    fun loadImage() {
        Picasso.get()
            .load("https://images.unsplash.com/photo-1635354942686-c862da3c30a6?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1170&q=80")
            .resize(500, 500)
            .centerCrop()
            .into(imageView)
    }

    override fun onClick(v: View?) {
        Toast.makeText(this, "You click me", Toast.LENGTH_LONG).show()
    }
}
