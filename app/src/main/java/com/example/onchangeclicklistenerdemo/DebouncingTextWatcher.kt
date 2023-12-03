package com.example.onchangeclicklistenerdemo

import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DebouncingTextWatcher(private val textView : TextView, private val debounceDuration: Long = 1000): TextWatcher {



    private var debouncingJob : Job? = null

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun afterTextChanged(p0: Editable?) {
      debouncingJob?.cancel()

        debouncingJob = CoroutineScope(Dispatchers.Main).launch {
            delay(debounceDuration)

            p0?.let {
                val inputText = it.toString()
                textView.text = "EditText is Written: $inputText"
            }
        }
    }
    fun cancelDebouncing(){
        debouncingJob?.cancel()
    }
}