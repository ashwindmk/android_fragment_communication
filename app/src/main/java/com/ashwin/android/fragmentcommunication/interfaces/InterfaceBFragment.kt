package com.ashwin.android.fragmentcommunication.interfaces

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ashwin.android.fragmentcommunication.Constant
import com.ashwin.android.fragmentcommunication.databinding.FragmentBBinding

private const val SUB_TAG = "InterfaceBFragment"

class InterfaceBFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() = InterfaceBFragment()

        const val TAG = "frag-b"
    }

    private lateinit var binding: FragmentBBinding

    private var messageInterface: MessageInterface? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        println("${Constant.APP_TAG}: $SUB_TAG: onAttach")
        if (context is MessageInterface) {
            messageInterface = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("${Constant.APP_TAG}: $SUB_TAG: onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            fragmentCommon.sendButton.setOnClickListener {
                val msg = fragmentCommon.messageEditText.text.toString()
                messageInterface?.send("msg_from_b", msg)
            }
        }
    }

    fun receive(msg: String) {
        println("${Constant.APP_TAG}: $SUB_TAG: receive(msg = $msg)")
        binding.fragmentCommon.messageTextView.text = msg
    }
}
