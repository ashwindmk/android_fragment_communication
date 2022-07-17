package com.ashwin.android.fragmentcommunication.fragmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ashwin.android.fragmentcommunication.databinding.ActivityFragmentsBinding

class FragManagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            supportFragmentManager.beginTransaction()
                .add(fragAContainer.id, FragManagerAFragment.newInstance(), FragManagerAFragment.TAG)
                .commit()

            supportFragmentManager.beginTransaction()
                .add(fragBContainer.id, FragManagerBFragment.newInstance(), FragManagerBFragment.TAG)
                .commit()

            oneButton.setOnClickListener {
            }

            twoButton.setOnClickListener {
            }
        }
    }
}
