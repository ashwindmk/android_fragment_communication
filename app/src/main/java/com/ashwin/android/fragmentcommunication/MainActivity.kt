package com.ashwin.android.fragmentcommunication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ashwin.android.fragmentcommunication.databinding.ActivityMainBinding
import com.ashwin.android.fragmentcommunication.fragmanager.FragManagerActivity
import com.ashwin.android.fragmentcommunication.interfaces.InterfacesActivity
import com.ashwin.android.fragmentcommunication.viewmodels.ViewModelActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            interfacesButton.setOnClickListener {
                startActivity(Intent(this@MainActivity, InterfacesActivity::class.java))
            }

            fragmentManagerButton.setOnClickListener {
                startActivity(Intent(this@MainActivity, FragManagerActivity::class.java))
            }

            viewModelButton.setOnClickListener {
                startActivity(Intent(this@MainActivity, ViewModelActivity::class.java))
            }
        }
    }
}
