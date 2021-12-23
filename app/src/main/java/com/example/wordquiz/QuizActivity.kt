package com.example.wordquiz

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.delay

class QuizActivity : AppCompatActivity() {

    private val wordViewModel: WordViewModel by lazy {
        ViewModelProvider(this).get(WordViewModel::class.java)
    }

    private lateinit var textQuestion:TextView
    private lateinit var btnRadio1:RadioButton
    private lateinit var btnRadio2:RadioButton
    private lateinit var btnRadio3:RadioButton
    private lateinit var btnRadio4:RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val btnBack:Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        textQuestion = findViewById(R.id.textQuestion)
        btnRadio1 = findViewById(R.id.radioButton1)
        btnRadio2 = findViewById(R.id.radioButton2)
        btnRadio3 = findViewById(R.id.radioButton3)
        btnRadio4 = findViewById(R.id.radioButton4)

        updateWordQuiz()

        btnRadio1.setOnClickListener {
            checkAnswer(1)
        }
        btnRadio2.setOnClickListener {
            checkAnswer(2)
        }
        btnRadio3.setOnClickListener {
            checkAnswer(3)
        }
        btnRadio4.setOnClickListener {
            checkAnswer(4)
        }

    }


    private fun updateWordQuiz() {
        textQuestion.text = wordViewModel.curQuestion
        btnRadio1.text = wordViewModel.curNumber1
        btnRadio2.text = wordViewModel.curNumber2
        btnRadio3.text = wordViewModel.curNumber3
        btnRadio4.text = wordViewModel.curNumber4

        btnRadio1.isChecked = false
        btnRadio1.setBackgroundColor(Color.WHITE)
        btnRadio2.isChecked = false
        btnRadio2.setBackgroundColor(Color.WHITE)
        btnRadio3.isChecked = false
        btnRadio3.setBackgroundColor(Color.WHITE)
        btnRadio4.isChecked = false
        btnRadio4.setBackgroundColor(Color.WHITE)
    }

    private fun checkAnswer(userAns: Int) {
        val correctAns = wordViewModel.curAnswer

        if (userAns != correctAns) {
            when (userAns) {
                1 -> btnRadio1.setBackgroundColor(Color.RED)
                2 -> btnRadio2.setBackgroundColor(Color.RED)
                3 -> btnRadio3.setBackgroundColor(Color.RED)
                4 -> btnRadio4.setBackgroundColor(Color.RED)
            }
            when (correctAns) {
                1 -> btnRadio1.setBackgroundColor(Color.GREEN)
                2 -> btnRadio2.setBackgroundColor(Color.GREEN)
                3 -> btnRadio3.setBackgroundColor(Color.GREEN)
                4 -> btnRadio4.setBackgroundColor(Color.GREEN)
            }
        }

        if (userAns == correctAns) {
            when (correctAns) {
                1 -> btnRadio1.setBackgroundColor(Color.GREEN)
                2 -> btnRadio2.setBackgroundColor(Color.GREEN)
                3 -> btnRadio3.setBackgroundColor(Color.GREEN)
                4 -> btnRadio4.setBackgroundColor(Color.GREEN)
            }
        }
        wordViewModel.moveToNext()
        updateWordQuiz()

    }
}