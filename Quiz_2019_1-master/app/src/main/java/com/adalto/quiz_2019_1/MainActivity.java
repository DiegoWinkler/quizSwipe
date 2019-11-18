package com.adalto.quiz_2019_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnVertical, btnHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHorizontal = (Button) findViewById(R.id.btnHorizontal);
        btnVertical = (Button) findViewById(R.id.btnVertical);

        btnVertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent
                        (MainActivity.this, QuizActivity.class);
                intent.putExtra("tipo", "vertical");
                startActivity(intent);
            }
        });

        btnHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent
                        (MainActivity.this, QuizActivity.class);
                intent.putExtra("tipo", "horizontal");
                startActivity(intent);
            }
        });

    }
}








