package com.ashwin.android.fragmentcommunication.fragmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.ashwin.android.fragmentcommunication.Constant
import com.ashwin.android.fragmentcommunication.databinding.FragmentBBinding

private const val SUB_TAG = "FragManagerBFragment"

class FragManagerBFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() = FragManagerBFragment()

        const val TAG = "frag-b"
    }

    private lateinit var binding: FragmentBBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            fragmentCommon.sendButton.setOnClickListener {
                val msg = fragmentCommon.messageEditText.text.toString()
                val bundle = bundleOf(Pair("msg", msg))
                parentFragmentManager.setFragmentResult("result_from_b", bundle)
            }
        }

        parentFragmentManager.setFragmentResultListener("result_from_a", viewLifecycleOwner, { key, bundle ->
            val msg = bundle.getString("msg")
            println("${Constant.APP_TAG}: $SUB_TAG: onFragmentResult: msg = $msg")
            binding.fragmentCommon.messageTextView.text = msg
        })
    }
}
