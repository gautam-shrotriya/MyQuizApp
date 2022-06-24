package com.example.myquizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_NO_OF_QUES: String = "total_no_of_ques"
    const val SCORE_CORRECT_ANS: String = "score_correct_ans"

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.flag_of_italy,
            "Italy", "Mexico", "Spain", "China",
            1
        )

        questionList.add(que1)

        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.flag_of_france,
            "Germany", "Canada", "France", "Ireland",
            3
        )

        questionList.add(que2)

        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.flag_of_usa,
            "Russia", "United Kingdom", "USA", "Australia",
            3
        )

        questionList.add(que3)

        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.flag_of_india,
            "Indonesia", "India", "Nepal", "China",
            2
        )

        questionList.add(que4)

        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.flag_of_japan,
            "Greece", "Poland", "South Korea", "Japan",
            4
        )

        questionList.add(que5)

        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.flag_of_spain,
            "Spain", "Colombia", "Switzerland", "Belgium",
            1
        )

        questionList.add(que6)

        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.flag_of_china,
            "Vietnam", "Peru", "Thailand", "China",
            4
        )

        questionList.add(que7)

        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.flag_of_italy,
            "South Africa", "Norway", "Austria", "Finland",
            2
        )

        questionList.add(que8)

        val que9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.flag_of_brazil,
            "Australia", "Bolivia", "Brazil", "Cuba",
            3
        )

        questionList.add(que9)

        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.flag_of_ukraine,
            "Belarus", "Russia", "Romania", "Ukraine",
            4
        )

        questionList.add(que10)

        return questionList
    }
}