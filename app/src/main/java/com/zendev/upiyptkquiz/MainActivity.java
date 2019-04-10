package com.zendev.upiyptkquiz;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RelativeLayout relativeLayout1, relativeLayout2;
    Button btnStart, btnLogin, btnRegister;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            relativeLayout1.setVisibility(View.VISIBLE);
            relativeLayout2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout1 = findViewById(R.id.rellay1);
        relativeLayout2 = findViewById(R.id.rellay2);

        btnStart = findViewById(R.id.btn_start);
        btnStart.setOnClickListener(this);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(this);

        handler.postDelayed(runnable, 3000);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start:
                break;
            case R.id.btn_login:
                Toast.makeText(this, "Under Construction", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_register:
                Toast.makeText(this, "Under Construction", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
