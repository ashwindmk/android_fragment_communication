package com.ashwin.android.fragmentcommunication.viewmodels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ashwin.android.fragmentcommunication.databinding.FragmentBBinding

private const val SUB_TAG = "ViewModelFragmentB"

class ViewModelFragmentB : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() = ViewModelFragmentB()

        const val TAG = "frag-b"
    }

    private lateinit var binding: FragmentBBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        binding.apply {
            fragmentCommon.sendButton.setOnClickListener {
                val msg = fragmentCommon.messageEditText.text.toString()
                viewModel.send("msg_from_b", msg)
            }
        }

        viewModel.resFromALiveData.observe(viewLifecycleOwner, { msg ->
            binding.fragmentCommon.messageTextView.text = msg
        })
    }
}
