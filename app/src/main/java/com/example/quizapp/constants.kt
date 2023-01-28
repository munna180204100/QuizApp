package com.example.quizapp

object constants{

    const val userName:String = "username"
    const val totalQues:String="totalAns"
    const val correctAns:String="correctAns"

    fun getQuestions():ArrayList<Question>{
        val questionList=ArrayList<Question>()

        //1
        val ques1=Question(1,"Which Contry is this?",
        R.drawable.ic_flag_of_argentina,
            "Austria",
            "Australia",
            "Armenia",
            "Argentina",
            4)
        questionList.add(ques1)

        //2
        val ques2=Question(2,"Which Contry is this?",
            R.drawable.ic_flag_of_australia,
            "Austria",
            "Australia",
            "Armenia",
            "Argentina",
            2)
        questionList.add(ques2)

        //3
        val ques3=Question(3,"Which Contry is this?",
            R.drawable.ic_flag_of_belgium,
            "Argentina",
            "Australia",
            "Brazil",
            "Belgium",
            4)
        questionList.add(ques3)

        //4
        val ques4=Question(4,"Which Contry is this?",
            R.drawable.ic_flag_of_brazil,
            "Argentina",
            "Australia",
            "Brazil",
            "Belgium",
            3)
        questionList.add(ques4)

        //5
        val ques5=Question(5,"Which Contry is this?",
            R.drawable.ic_flag_of_denmark,
            "Brazil",
            "Spain",
            "India",
            "Denmark",
            4)
        questionList.add(ques5)

        //6
        val ques6=Question(6,"Which Contry is this?",
            R.drawable.ic_flag_of_fiji,
            "Fiji",
            "Spain",
            "India",
            "Denmark",
            1)
        questionList.add(ques6)

        //7
        val ques7=Question(7,"Which Contry is this?",
            R.drawable.ic_flag_of_germany,
            "India",
            "Australia",
            "Germany",
            "Austria",
            3)
        questionList.add(ques7)

        //8
        val ques8=Question(8,"Which Contry is this?",
            R.drawable.ic_flag_of_india,
            "Argentina",
            "Australia",
            "India",
            "Austria",
            3)
        questionList.add(ques8)

        //9
        val ques9=Question(9,"Which Contry is this?",
            R.drawable.ic_flag_of_kuwait,
            "Argentina",
            "India",
            "Fiji",
            "Kuwait",
            4)
        questionList.add(ques9)

        //10
        val ques10=Question(10,"Which Contry is this?",
            R.drawable.ic_flag_of_fiji,
            "Fiji",
            "Spain",
            "India",
            "Denmark",
            1)
        questionList.add(ques10)

        return questionList
    }
}