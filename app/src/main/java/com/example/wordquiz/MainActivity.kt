package com.example.wordquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart:Button = findViewById(R.id.btnStart)
        btnStart.setOnClickListener {
            var quizIntent = Intent(this, QuizActivity::class.java)
            startActivity(quizIntent)
        }
    }
}