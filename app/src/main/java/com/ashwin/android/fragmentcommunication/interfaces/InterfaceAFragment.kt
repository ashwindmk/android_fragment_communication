package com.ashwin.android.fragmentcommunication.interfaces

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ashwin.android.fragmentcommunication.Constant
import com.ashwin.android.fragmentcommunication.databinding.FragmentABinding

private const val SUB_TAG = "InterfaceAFragment"

class InterfaceAFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() = InterfaceAFragment()

        const val TAG = "frag-a"
    }

    private lateinit var binding: FragmentABinding
    //private val binding: FragmentInterfaceBBinding by viewBinding
    /*
    private var _binding: FragmentInterfaceABinding? = null
    private val binding get() = _binding!!    // This property is only valid between onCreateView and onDestroyView.
    */

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            fragmentCommon.sendButton.setOnClickListener {
                val msg = fragmentCommon.messageEditText.text.toString()
                messageInterface?.send("msg_from_a", msg)
            }
        }
    }

    fun receive(msg: String) {
        println("${Constant.APP_TAG}: $SUB_TAG: receive(msg = $msg)")
        binding.fragmentCommon.messageTextView.text = msg
    }
}
