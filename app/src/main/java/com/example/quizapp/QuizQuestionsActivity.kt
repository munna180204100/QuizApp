package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.hardware.camera2.params.BlackLevelPattern
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {

    private var mCurrentPosition:Int =1
    private var mQuestionsList: ArrayList<Question>?=null
    private var mSelectOptionPosition: Int =0
    private var mCorrectAnswer : Int=0
    private var mUsername:String? =null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mUsername=intent.getStringExtra(constants.userName)
        mQuestionsList=constants.getQuestions()
        setQuestion()

        val option1=findViewById<TextView>(R.id.optionOne)
        val option2=findViewById<TextView>(R.id.optionTwo)
        val option3=findViewById<TextView>(R.id.optionThree)
        val option4=findViewById<TextView>(R.id.optionFour)
        val submitBtn=findViewById<Button>(R.id.submit_btn)


            option1.setOnClickListener(this)
            option2.setOnClickListener(this)
            option3.setOnClickListener(this)
            option4.setOnClickListener(this)
            submitBtn.setOnClickListener(this)




    }

    private fun setQuestion(){

        val question =  mQuestionsList!![mCurrentPosition-1]
        defaultOptionsView()

        val submitBtn=findViewById<Button>(R.id.submit_btn)
        if(mCurrentPosition == mQuestionsList!!.size){
            submitBtn.text="FINISH"
        }else {
            submitBtn.text = "SUBMIT"
        }

        var progressBar=findViewById<ProgressBar>(R.id.progressBar)
        var progress= findViewById<TextView>(R.id.progress)

        val tv_question=findViewById<TextView>(R.id.tv_question)
        val iv_image=findViewById<ImageView>(R.id.iv_image)
        val option1=findViewById<TextView>(R.id.optionOne)
        val option2=findViewById<TextView>(R.id.optionTwo)
        val option3=findViewById<TextView>(R.id.optionThree)
        val option4=findViewById<TextView>(R.id.optionFour)


        progressBar.progress=mCurrentPosition;
        progress.text="$mCurrentPosition/${progressBar.max}"

        tv_question.text=question!!.question
        iv_image.setImageResource(question.image)
        option1.text=question.optionOne
        option2.text=question.optionTwo
        option3.text=question.optionThree
        option4.text=question.optionFour

    }

    private fun defaultOptionsView(){

        val tv_question=findViewById<TextView>(R.id.tv_question)
        val iv_image=findViewById<ImageView>(R.id.iv_image)
        val option1=findViewById<TextView>(R.id.optionOne)
        val option2=findViewById<TextView>(R.id.optionTwo)
        val option3=findViewById<TextView>(R.id.optionThree)
        val option4=findViewById<TextView>(R.id.optionFour)

        val options=ArrayList<TextView>()
        options.add(0,option1)
        options.add(1,option2)
        options.add(2,option3)
        options.add(3,option4)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,
            R.drawable.option_bg_border
            )

        }

    }

    override fun onClick(v: View?) {

        val option1=findViewById<TextView>(R.id.optionOne)
        val option2=findViewById<TextView>(R.id.optionTwo)
        val option3=findViewById<TextView>(R.id.optionThree)
        val option4=findViewById<TextView>(R.id.optionFour)
        val submitBtn=findViewById<Button>(R.id.submit_btn)

        when(v?.id){
          R.id.optionOne->{
              selectedOptionView(option1,1)
          }
            R.id.optionTwo->{
                selectedOptionView(option2,2)
            }
            R.id.optionThree->{
                selectedOptionView(option3,3)
            }
            R.id.optionFour->{
                selectedOptionView(option4,4)
            }
            R.id.submit_btn->{
                if(mSelectOptionPosition==0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }
                        else->{
                           val intent = Intent(this,resultActivity::class.java)
                            intent.putExtra(constants.userName,mUsername)
                            intent.putExtra(constants.totalQues,mQuestionsList!!.size)
                            intent.putExtra(constants.correctAns,mCorrectAnswer)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question =mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.correctAns!=mSelectOptionPosition){
                        answerView(mSelectOptionPosition,R.drawable.wrong_option_bg_border)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAns,R.drawable.correct_option_bg_border)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        submitBtn.text="FINISH"
                    }else {
                        submitBtn.text = "Go To Next Question"
                    }
                    mSelectOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer:Int , drawableView:Int){

        val option1=findViewById<TextView>(R.id.optionOne)
        val option2=findViewById<TextView>(R.id.optionTwo)
        val option3=findViewById<TextView>(R.id.optionThree)
        val option4=findViewById<TextView>(R.id.optionFour)

        when(answer){
            1->{
                option1.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            2->{
                option2.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            3->{
                option3.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            4->{
                option4.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }

        }
    }


    private fun selectedOptionView(tv: TextView,selectedOptionNum:Int){
        defaultOptionsView()
        mSelectOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#000000"))
        tv.typeface=Typeface.DEFAULT_BOLD
        tv.background=ContextCompat.getDrawable(this,
            R.drawable.selecter_option_bg_border
        )



    }
}