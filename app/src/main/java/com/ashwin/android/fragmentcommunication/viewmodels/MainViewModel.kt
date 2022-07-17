package com.ashwin.android.fragmentcommunication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ashwin.android.fragmentcommunication.Constant

private const val SUB_TAG = "MainViewModel"

class MainViewModel : ViewModel() {
    private val _resFromALiveData: MutableLiveData<String> = MutableLiveData()
    val resFromALiveData: LiveData<String> = _resFromALiveData

    private val _resFromBLiveData: MutableLiveData<String> = MutableLiveData()
    val resFromBLiveData: LiveData<String> = _resFromBLiveData

    fun send(key: String, msg: String) {
        when (key) {
            "msg_from_a" -> {
                _resFromALiveData.value = msg
            }
            "msg_from_b" -> {
                _resFromBLiveData.value = msg
            }
            else -> {
                println("${Constant.APP_TAG}: $SUB_TAG: Unknown key = $key")
            }
        }
    }
}
