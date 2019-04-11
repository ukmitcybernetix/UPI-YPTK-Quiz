package com.zendev.upiyptkquiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    TextView quizTextView, numberTextView, btnNextTextView;
    LinearLayout btnNext, btnPrev, btnHint;
    ImageView imgHint1, imgHint2, imgHint3;
    RadioButton rdbA, rdbB, rdbC, rdbD;
    RadioGroup rdgAnswer;
    static Quiz quiz;
    int indekValue, benarValue, salahValue, kosongValue, hintValue = 3;
    String[] listJawaban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        listJawaban = new String[10];

        quizTextView = findViewById(R.id.quiz);
        numberTextView = findViewById(R.id.action_number);
        btnNextTextView = findViewById(R.id.btn_next_txt);
        btnNext = findViewById(R.id.btn_next);
        btnPrev = findViewById(R.id.btn_prev);
        btnHint = findViewById(R.id.hint);
        rdbA = findViewById(R.id.rdb_a);
        rdbB = findViewById(R.id.rdb_b);
        rdbC = findViewById(R.id.rdb_c);
        rdbD = findViewById(R.id.rdb_d);
        rdgAnswer = findViewById(R.id.rdg_answer);
        imgHint1 = findViewById(R.id.hint1);
        imgHint2 = findViewById(R.id.hint2);
        imgHint3 = findViewById(R.id.hint3);

        quiz = new Quiz();

        quiz.addQuiz("\" Sebelum memulai perkuliahan di kampus UPI YPTK Padang, dosen dan mahasiswa harus membaca 12 Prinsip Dasar UPI YPTK Padang." +
                        " 'Meningkatkan Kreatifitas' merupakan prinsip dasar yang ke ? \"",
                "D", "4", "5" , "11",
                "7");

        quiz.addQuiz("\" Sebelum memulai perkuliahan di kampus UPI YPTK Padang, dosen dan mahasiswa harus membaca 12 Prinsip Dasar UPI YPTK Padang." +
                        " 'Meningkatkan Kreatifitas' merupakan prinsip dasar yang ke ? \"",
                "A", "4", "5" , "11",
                "7");

        quiz.addQuiz("\" Sebelum memulai perkuliahan di kampus UPI YPTK Padang, dosen dan mahasiswa harus membaca 12 Prinsip Dasar UPI YPTK Padang." +
                        " 'Meningkatkan Kreatifitas' merupakan prinsip dasar yang ke ? \"",
                "A", "4", "5" , "11",
                "7");

        quiz.addQuiz("\" Sebelum memulai perkuliahan di kampus UPI YPTK Padang, dosen dan mahasiswa harus membaca 12 Prinsip Dasar UPI YPTK Padang." +
                        " 'Meningkatkan Kreatifitas' merupakan prinsip dasar yang ke ? \"",
                "A", "4", "5" , "11",
                "7");

        quiz.addQuiz("\" Sebelum memulai perkuliahan di kampus UPI YPTK Padang, dosen dan mahasiswa harus membaca 12 Prinsip Dasar UPI YPTK Padang." +
                        " 'Meningkatkan Kreatifitas' merupakan prinsip dasar yang ke ? \"",
                "A", "4", "5" , "11",
                "7");

        quiz.addQuiz("\" Sebelum memulai perkuliahan di kampus UPI YPTK Padang, dosen dan mahasiswa harus membaca 12 Prinsip Dasar UPI YPTK Padang." +
                        " 'Meningkatkan Kreatifitas' merupakan prinsip dasar yang ke ? \"",
                "A", "4", "5" , "11",
                "7");

        quiz.addQuiz("\" Sebelum memulai perkuliahan di kampus UPI YPTK Padang, dosen dan mahasiswa harus membaca 12 Prinsip Dasar UPI YPTK Padang." +
                        " 'Meningkatkan Kreatifitas' merupakan prinsip dasar yang ke ? \"",
                "A", "4", "5" , "11",
                "7");

        quiz.addQuiz("\" Sebelum memulai perkuliahan di kampus UPI YPTK Padang, dosen dan mahasiswa harus membaca 12 Prinsip Dasar UPI YPTK Padang." +
                        " 'Meningkatkan Kreatifitas' merupakan prinsip dasar yang ke ? \"",
                "A", "4", "5" , "11",
                "7");

        quiz.addQuiz("\" Sebelum memulai perkuliahan di kampus UPI YPTK Padang, dosen dan mahasiswa harus membaca 12 Prinsip Dasar UPI YPTK Padang." +
                        " 'Meningkatkan Kreatifitas' merupakan prinsip dasar yang ke ? \"",
                "A", "4", "5" , "11",
                "7");

        quiz.addQuiz("\" Sebelum memulai perkuliahan di kampus UPI YPTK Padang, dosen dan mahasiswa harus membaca 12 Prinsip Dasar UPI YPTK Padang." +
                        " 'Meningkatkan Kreatifitas' merupakan prinsip dasar yang ke ? \"",
                "A", "4", "5" , "11",
                "7");

        setView(quiz, 0);
        quizTextView.setBackgroundColor(Color.parseColor("#21293D"));

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rdgAnswer.getCheckedRadioButtonId()){
                    case R.id.rdb_a:
                        listJawaban[indekValue] = "A";
                        break;
                    case R.id.rdb_b:
                        listJawaban[indekValue] = "B";
                        break;
                    case R.id.rdb_c:
                        listJawaban[indekValue] = "C";
                        break;
                    case R.id.rdb_d:
                        listJawaban[indekValue] = "D";
                        break;
                }
                indekValue++;

                if(indekValue > 9){
                    indekValue = 9;

                    calculateAnswer();

                    Intent moveScore = new Intent(view.getContext(), ScoreActivity.class);
                    moveScore.putExtra("BENAR", benarValue);
                    moveScore.putExtra("SALAH", salahValue);
                    moveScore.putExtra("KOSONG", kosongValue);
                    moveScore.putExtra("LIST_JAWABAN", listJawaban);

                    startActivity(moveScore);
                    finish();
                }

                if(listJawaban[indekValue] != null){
                    rdgAnswer.check(getCheckedButton(listJawaban[indekValue]));
                }else{
                    rdgAnswer.clearCheck();
                }

                if(indekValue == 9){
                    btnNextTextView.setText(getString(R.string.finish_text));
                }

                setView(quiz, indekValue);
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rdgAnswer.getCheckedRadioButtonId()) {
                    case R.id.rdb_a:
                        listJawaban[indekValue] = "A";
                        break;
                    case R.id.rdb_b:
                        listJawaban[indekValue] = "B";
                        break;
                    case R.id.rdb_c:
                        listJawaban[indekValue] = "C";
                        break;
                    case R.id.rdb_d:
                        listJawaban[indekValue] = "D";
                        break;
                }
                indekValue--;

                if(indekValue < 0){
                    indekValue = 0;
                    Toast.makeText(view.getContext(), "Oops! You Can't Go Back", Toast.LENGTH_SHORT).show();
                }

                if(listJawaban[indekValue] != null) {
                    rdgAnswer.check(getCheckedButton(listJawaban[indekValue]));
                }else {
                    rdgAnswer.clearCheck();
                }

                if(indekValue < 9) {
                    btnNextTextView.setText(R.string.next);
                }

                setView(quiz, indekValue);
            }
        });

        btnHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hintValue > 0){
                    hintValue--;
                    Toast.makeText(view.getContext(), "The Answer Is " + quiz.getSoal(indekValue).getAnswer(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(view.getContext(), "Oops, You Can't Use Hint", Toast.LENGTH_SHORT).show();
                }

                switch (hintValue) {
                    case 2:
                        imgHint3.setVisibility(View.GONE);
                        break;
                    case 1:
                        imgHint2.setVisibility(View.GONE);
                        break;
                    case 0:
                        imgHint1.setVisibility(View.GONE);
                        break;

                }
            }
        });
    }

    private void setView(Quiz quiz, int indek) {
        Quiz.Soal soal = quiz.getSoal(indek);

        quizTextView.setText(soal.getQuiz());
        numberTextView.setText((indek+1) + " / 10");
        rdbA.setText("A.  " + soal.getOptA());
        rdbB.setText("B.  " + soal.getOptB());
        rdbC.setText("C.  " + soal.getOptC());
        rdbD.setText("D.  " + soal.getOptD());

        switch (indek) {
            case 0:
                quizTextView.setBackgroundColor(Color.parseColor("#21293D"));
                break;
            case 1:
                quizTextView.setBackgroundColor(Color.DKGRAY);
                break;
            case 2:
                quizTextView.setBackgroundColor(Color.BLACK);
                break;
            case 3:
                quizTextView.setBackgroundColor(Color.parseColor("#21293D"));
                break;
            case 4:
                quizTextView.setBackgroundColor(Color.DKGRAY);
                break;
            case 5:
                quizTextView.setBackgroundColor(Color.BLACK);
                break;
            case 6:
                quizTextView.setBackgroundColor(Color.parseColor("#21293D"));
                break;
            case 7:
                quizTextView.setBackgroundColor(Color.DKGRAY);
                break;
            case 8:
                quizTextView.setBackgroundColor(Color.BLACK);
                break;
            case 9:
                quizTextView.setBackgroundColor(Color.parseColor("#21293D"));
                break;
        }
    }

    private int getCheckedButton(String jawaban) {

        if(jawaban.equals("A")) {
            return R.id.rdb_a;
        }else if(jawaban.equals("B")) {
            return R.id.rdb_b;
        }else if(jawaban.equals("C")) {
            return R.id.rdb_c;
        }else if(jawaban.equals("D")) {
            return R.id.rdb_d;
        }
        return 0;
    }

    private void calculateAnswer() {
        for(int i=0; i<listJawaban.length; i++) {
            if(listJawaban[i] == null) {
                kosongValue++;
            } else if(listJawaban[i].equals(quiz.getSoal(i).getAnswer())) {
                benarValue++;
            }else {
                salahValue++;
            }
        }
    }
}
