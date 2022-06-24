package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val nameTV: TextView = findViewById(R.id.userNameTV)
        val scoreDisplayTV: TextView = findViewById(R.id.scoreDisplayTV)

        val userName: String? = intent.getStringExtra(Constants.USER_NAME)
        val scoreCorrect: Int = intent.getIntExtra(Constants.SCORE_CORRECT_ANS, 0)
        val totalQuestions: Int = intent.getIntExtra(Constants.TOTAL_NO_OF_QUES, 0)

        nameTV.text = userName
        scoreDisplayTV.text = "Your score is $scoreCorrect out of $totalQuestions"

        val buttonFinish = findViewById<Button>(R.id.buttonFinish)
        buttonFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}