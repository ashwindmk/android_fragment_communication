package com.ashwin.android.fragmentcommunication.interfaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ashwin.android.fragmentcommunication.Constant
import com.ashwin.android.fragmentcommunication.databinding.ActivityFragmentsBinding

private const val SUB_TAG = "InterfacesActivity"

class InterfacesActivity : AppCompatActivity(), MessageInterface {
    private lateinit var binding: ActivityFragmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            supportFragmentManager.beginTransaction()
                .add(fragAContainer.id, InterfaceAFragment.newInstance(), InterfaceAFragment.TAG)
                .commit()

            supportFragmentManager.beginTransaction()
                .add(fragBContainer.id, InterfaceBFragment.newInstance(), InterfaceBFragment.TAG)
                //.replace(fragAContainer.id, InterfaceBFragment.newInstance(), InterfaceBFragment.TAG)
                .commit()

            oneButton.setOnClickListener {
            }

            twoButton.setOnClickListener {
            }
        }
    }

    override fun onResumeFragments() {
        println("${Constant.APP_TAG}: $SUB_TAG: onResumeFragments before super")
        super.onResumeFragments()
        println("${Constant.APP_TAG}: $SUB_TAG: onResumeFragments after super")
    }

    override fun send(key: String, msg: String) {
        println("${Constant.APP_TAG}: $SUB_TAG: send(msg = $msg)")

        if (key == "msg_from_b") {
            val fragA = supportFragmentManager.findFragmentByTag(InterfaceAFragment.TAG)
            fragProps(fragA)
            if (fragA is InterfaceAFragment && fragA.isAdded) {
                fragA.receive(msg)
            } else {
                println("${Constant.APP_TAG}: $SUB_TAG: fragA = null)")
            }
        }

        else if (key == "msg_from_a") {
            val fragB = supportFragmentManager.findFragmentByTag(InterfaceBFragment.TAG)
            fragProps(fragB)
            if (fragB is InterfaceBFragment && fragB.isAdded) {
                fragB.receive(msg)
            } else {
                println("${Constant.APP_TAG}: $SUB_TAG: fragB = null)")
            }
        }
    }

    private fun fragProps(frag: Fragment?) {
        frag?.let {
            println("  ${Constant.APP_TAG}: $SUB_TAG: frag.isVisible = ${frag.isVisible})")
            println("  ${Constant.APP_TAG}: $SUB_TAG: frag.isAdded = ${frag.isAdded})")
            println("  ${Constant.APP_TAG}: $SUB_TAG: frag.isInLayout = ${frag.isInLayout})")
            println("  ${Constant.APP_TAG}: $SUB_TAG: frag.isResumed = ${frag.isResumed})")
            println("  ${Constant.APP_TAG}: $SUB_TAG: frag.isStateSaved = ${frag.isStateSaved})")
        } ?: println("  ${Constant.APP_TAG}: $SUB_TAG: frag = null")
    }
}
