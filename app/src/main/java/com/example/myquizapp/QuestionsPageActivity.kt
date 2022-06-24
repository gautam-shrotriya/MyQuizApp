package com.example.myquizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuestionsPageActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOption: Int = 0
    private var scoreCorrectAns: Int = 0
    private var mUserName: String? = null

    private var qstnTV: TextView? = null
    private var imgView: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var progressTextView: TextView? = null
    private var option1TV: TextView? = null
    private var option2TV: TextView? = null
    private var option3TV: TextView? = null
    private var option4TV: TextView? = null
    private var btnSubmit: Button? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions_page)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        qstnTV = findViewById(R.id.questionTV)
        imgView = findViewById(R.id.flagIV)
        progressBar = findViewById(R.id.progressBar)
        progressTextView = findViewById(R.id.progressTV)
        option1TV = findViewById(R.id.option1TV)
        option2TV = findViewById(R.id.option2TV)
        option3TV = findViewById(R.id.option3TV)
        option4TV = findViewById(R.id.option4TV)
        btnSubmit = findViewById(R.id.btnSubmitAns)

        option1TV?.setOnClickListener(this)
        option2TV?.setOnClickListener(this)
        option3TV?.setOnClickListener(this)
        option4TV?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()

        defaultSetQuestionView()


    }

    private fun defaultSetQuestionView() {
        defaultOptionView()

        option1TV?.isClickable = true
        option2TV?.isClickable = true
        option3TV?.isClickable = true
        option4TV?.isClickable = true

        val question = mQuestionList!![mCurrentPosition - 1]

        qstnTV?.text = question.question
        imgView?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        progressTextView?.text = "${mCurrentPosition}/${progressBar?.max}"
        option1TV?.text = question.option1
        option2TV?.text = question.option2
        option3TV?.text = question.option3
        option4TV?.text = question.option4

        if(mCurrentPosition == mQuestionList!!.size) {
            btnSubmit?.text = "FINISH"
        }
        else {
            btnSubmit?.text = "SUBMIT"
        }
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.option1TV -> {
                option1TV?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.option2TV -> {
                option2TV?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.option3TV -> {
                option3TV?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.option4TV -> {
                option4TV?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.btnSubmitAns -> {
                if(mSelectedOption == 0) {
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            defaultSetQuestionView()
                        }
                        else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.TOTAL_NO_OF_QUES, mQuestionList!!.size)
                            intent.putExtra(Constants.SCORE_CORRECT_ANS, scoreCorrectAns)
                            startActivity(intent)
                            finish()
                        }
                    }
                    
                }
                else {
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctOption != mSelectedOption) {
                     answerView(mSelectedOption, R.drawable.wrong_ans_border_background)
                    }
                    else{
                        scoreCorrectAns++
                    }
                    answerView(question.correctOption, R.drawable.correct_ans_border_background)

                    if(mCurrentPosition == mQuestionList!!.size) {
                        btnSubmit?.text = "FINISH"
                    }
                    else{
                        btnSubmit?.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOption = 0

                    option1TV?.isClickable = false
                    option2TV?.isClickable = false
                    option3TV?.isClickable = false
                    option4TV?.isClickable = false
                }
            }
        }
    }

    private fun answerView(ans: Int, drawableView: Int) {
        when(ans) {
            1 -> {
                option1TV?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            2 -> {
                option2TV?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            3 -> {
                option3TV?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            4 -> {
                option4TV?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()

        mSelectedOption = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.select_border_background
        )
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()

        option1TV?.let {
            options.add(0, it)
        }
        option2TV?.let {
            options.add(1, it)
        }
        option3TV?.let {
            options.add(2, it)
        }
        option4TV?.let {
            options.add(3, it)
        }

        for(option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.border_background
            )
        }
    }
}