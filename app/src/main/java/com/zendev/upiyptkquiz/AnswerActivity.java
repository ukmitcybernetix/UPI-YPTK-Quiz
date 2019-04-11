package com.zendev.upiyptkquiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    LinearLayout rootView, descriptionView;
    TextView numberTextView, answerTextView, questionTextView;
    String[] listAnswer;
    Quiz quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        listAnswer = getIntent().getStringArrayExtra("LIST_JAWABAN");
        quiz = QuizActivity.getQuiz();

        rootView = findViewById(R.id.root_view);

        for(int i=0; i<10; i++){
            descriptionView = new LinearLayout(this);
            descriptionView.setPadding(16,16,16,16);

            numberTextView = new TextView(this);
            numberTextView.setTextColor(Color.parseColor("#21293D"));
            numberTextView.setText("NO : " + (i+1) + "       ");

            answerTextView = new TextView(this);
            answerTextView.setTextColor(Color.parseColor("#21293D"));

            if(getAnswerValue(i)!= null){
                answerTextView.setText("Your Answer : " + getAnswerValue(i));
            }else{
                answerTextView.setText("Your Answer : -");
            }

            questionTextView = new TextView(this);
            questionTextView.setPadding(16, 16, 16, 16);

            if(listAnswer[i] == null){
                questionTextView.setBackgroundColor(Color.RED);
            }else if(listAnswer[i].equals(quiz.getSoal(i).getAnswer())){
                questionTextView.setBackgroundColor(Color.parseColor("#21293D"));
            }else{
                questionTextView.setBackgroundColor(Color.RED);
            }

            questionTextView.setTextColor(Color.WHITE);
            questionTextView.setText(quiz.getSoal(i).getQuiz() + "\n\n- " + quiz.getSoal(i).getStringAnswer()+ " -");

            descriptionView.addView(numberTextView);
            descriptionView.addView(answerTextView);
            rootView.addView(descriptionView);
            rootView.addView(questionTextView);
        }
    }

    private String getAnswerValue(int i) {
        String soalTmp = "";

        if(listAnswer[i] == null) {
            soalTmp = null;
        } else if (listAnswer[i].equals("A")) {
            soalTmp = quiz.getSoal(i).getOptA();
        } else if(listAnswer[i].equals("B")) {
            soalTmp = quiz.getSoal(i).getOptB();
        } else if(listAnswer[i].equals("C")) {
            soalTmp = quiz.getSoal(i).getOptC();
        } else if(listAnswer[i].equals("D")) {
            soalTmp = quiz.getSoal(i).getOptD();
        }
        return soalTmp;
    }
}
