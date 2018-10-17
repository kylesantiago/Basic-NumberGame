package com.example.kyles.numbergame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView note;
    private int num1;
    private int num2;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        note = findViewById(R.id.textView3);

        Intent intent = getIntent();
        num1 = intent.getIntExtra("num1",-1);
        num2 = intent.getIntExtra("num2",-1);

        if(num1 == num2){
            text = "Good Job!!";
            MainActivity.incrementScore();
        }
        else{
            text = "Wrong Answer";
        }

        note.setText(text);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height* 0.2));


    }
}
