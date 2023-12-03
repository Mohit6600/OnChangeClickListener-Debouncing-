package com.example.onchangeclicklistenerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    private var debouncingTextWatcher: DebouncingTextWatcher? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val textView = findViewById<TextView>(R.id.textView)

   /*     editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

               textView.setText("EditText is written: "+p0)
            *//*
                p0?.let {
                    textView.text = "EditText is written: $it"
                }*//*
            }
        })*/

        debouncingTextWatcher = DebouncingTextWatcher(textView)
        editText.addTextChangedListener(debouncingTextWatcher)


    }
    override fun onDestroy() {
        super.onDestroy()
        debouncingTextWatcher?.cancelDebouncing()
    }
}