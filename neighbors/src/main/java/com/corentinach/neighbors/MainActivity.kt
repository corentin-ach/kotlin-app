package com.corentinach.neighbors

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.corentinach.neighbors.databinding.AddNeighborBinding
import com.corentinach.neighbors.fragments.ListNeighborsFragment

class MainActivity : AppCompatActivity(), NavigationListener {
    private lateinit var toolbar: Toolbar
    private lateinit var binding: AddNeighborBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        showFragment(ListNeighborsFragment())
    }

    override fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }.commit()
    }

    override fun updateTitle(title: Int) {
        toolbar.setTitle(title)
    }

}
