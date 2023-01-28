package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val tv_name=findViewById<TextView>(R.id.tv_name)
        val tv_score=findViewById<TextView>(R.id.tv_score)
        val finish_btn=findViewById<Button>(R.id.btn_finish)

        val username=intent.getStringExtra(constants.userName)
        val totalQues=intent.getIntExtra(constants.totalQues,0)
        val correctAns=intent.getIntExtra(constants.correctAns,0)
        tv_name.text=username
        tv_score.text= "Your Score is $correctAns out of $totalQues"

        finish_btn.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}