package com.example.wordquiz

data class Word(val question: String,
                val number_1: String,
                val number_2: String,
                val number_3: String,
                val number_4: String,
                val answer: Int,
                var get_the_right_answer: Boolean)
