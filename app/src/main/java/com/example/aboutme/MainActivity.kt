package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button:Button = findViewById(R.id.done_button)
        button.setOnClickListener { changeNickname(button) }

        var field:TextView = findViewById<TextView>(R.id.nickname_text)
        field.setOnClickListener{ original(field) }
    }

    private fun changeNickname(view :View)
    {
        var field:TextView = findViewById<TextView>(R.id.nickname_text)
        var nickname : EditText= findViewById<EditText>(R.id.nickname_edit)
        field.text = "aka ${nickname.text.toString()}"
        nickname.visibility = View.GONE
        findViewById<Button>(R.id.done_button).visibility = View.GONE
        field.visibility = View.VISIBLE
        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }

    private fun original(view : View)
    {
        var nickname : EditText= findViewById<EditText>(R.id.nickname_edit)
        var button:Button = findViewById(R.id.done_button)
        view.visibility=View.GONE
        nickname.visibility=View.VISIBLE
        button.visibility=View.VISIBLE
        nickname.text=null
    }

}