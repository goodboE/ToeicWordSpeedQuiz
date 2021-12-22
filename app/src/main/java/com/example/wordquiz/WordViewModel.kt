package com.example.wordquiz

import androidx.lifecycle.ViewModel

class WordViewModel : ViewModel() {
    var curIndex = 0
    private val wordBank = listOf<Word>(
        Word("apple", "사과", "배", "포도", "귤", 1, false),
        Word("banana", "사과", "바나나", "사람", "동물", 2, false),
        Word("power", "축구", "책", "힘", "약한", 3, false)
    )

    val curAnswer: Int
        get() = wordBank[curIndex].answer
    val curQuestion: String
        get() = wordBank[curIndex].question
    val curNumber1: String
        get() = wordBank[curIndex].number_1
    val curNumber2: String
        get() = wordBank[curIndex].number_2
    val curNumber3: String
        get() = wordBank[curIndex].number_3
    val curNumber4: String
        get() = wordBank[curIndex].number_4
    var curGetTheRightAnswer: Boolean = false
        get() = wordBank[curIndex].get_the_right_answer


    fun moveToNext() {
        curIndex = (curIndex + 1) % wordBank.size
    }

}