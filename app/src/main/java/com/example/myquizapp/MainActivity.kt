package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btn_Start)
        val etNameView : EditText = findViewById(R.id.et_Name)

        btnStart.setOnClickListener {
            if(etNameView.text.isEmpty()) {
                Toast.makeText(this, "Please, enter your name.", Toast.LENGTH_LONG).show()
            }
            else {
                val intent = Intent(this, QuestionsPageActivity::class.java)
                intent.putExtra(Constants.USER_NAME, etNameView.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}