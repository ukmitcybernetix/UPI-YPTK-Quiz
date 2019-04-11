package com.zendev.upiyptkquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity implements View.OnClickListener{

    TextView score, right, wrong, blank;
    Button answer;
    int rightValue, wrongValue, blankValue, scoreValue;
    String[] listAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        score = findViewById(R.id.score);
        right = findViewById(R.id.right);
        wrong = findViewById(R.id.wrong);
        blank = findViewById(R.id.blank);
        answer = findViewById(R.id.btn_answer);

        rightValue = getIntent().getIntExtra("BENAR", 0);
        right.setText("" + rightValue);

        wrongValue = getIntent().getIntExtra("SALAH", 0);
        wrong.setText("" + wrongValue);

        blankValue = getIntent().getIntExtra("KOSONG", 0);
        blank.setText("" + blankValue);

        scoreValue = rightValue * 10;
        score.setText("" + scoreValue);

        listAnswer = getIntent().getStringArrayExtra("LIST_JAWABAN");

        answer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent moveAnswer = new Intent(view.getContext(), AnswerActivity.class);
        moveAnswer.putExtra("BENAR", rightValue);
        moveAnswer.putExtra("SALAH", wrongValue);
        moveAnswer.putExtra("KOSONG", blankValue);
        moveAnswer.putExtra("LIST_JAWABAN", listAnswer);
        startActivity(moveAnswer);
        finish();
    }
}
