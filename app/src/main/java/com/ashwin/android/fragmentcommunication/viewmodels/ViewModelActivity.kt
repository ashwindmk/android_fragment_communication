package com.ashwin.android.fragmentcommunication.viewmodels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ashwin.android.fragmentcommunication.databinding.ActivityFragmentsBinding

class ViewModelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(binding.fragAContainer.id, ViewModelFragmentA.newInstance(), ViewModelFragmentA.TAG)
            .commit()

        supportFragmentManager.beginTransaction()
            .add(binding.fragBContainer.id, ViewModelFragmentB.newInstance(), ViewModelFragmentB.TAG)
            .commit()
    }
}
