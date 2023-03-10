package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        var btn=findViewById<Button>(R.id.btn_start)
        var et_name=findViewById<AppCompatEditText>(R.id.et_name)

        btn.setOnClickListener {
            if(et_name.text.toString().isEmpty()) {
                Toast.makeText(this, "Please Enter your name", Toast.LENGTH_SHORT).show()
            }else{
                val intent=Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(constants.userName,et_name.text.toString())
                startActivity(intent)
                finish()
            }
            }
    }
}