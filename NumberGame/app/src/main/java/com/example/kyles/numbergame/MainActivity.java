package com.example.kyles.numbergame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button submit;
    private Button res;
    private Button pass;
    private Button reroll;
    private Button add;
    private Button mul;
    private Button div;
    private Button sub;

    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;

    private TextView bigNum;
    private TextView equation;
    private String sEquation;

    private Random rand;

    private int[] top;
    private int[] bottom;

    private static int scoreI;
    private static TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.button9);
        res = findViewById(R.id.restartBtn);
        pass = findViewById(R.id.button10);
        reroll = findViewById(R.id.rerollBtn);
        add = findViewById(R.id.addBtn);
        sub = findViewById(R.id.subBtn);
        mul = findViewById(R.id.mulBtn);
        div = findViewById(R.id.divBtn);

        num1 = findViewById(R.id.button);
        num2 = findViewById(R.id.button2);
        num3 = findViewById(R.id.button3);
        num4 = findViewById(R.id.button4);
        num5 = findViewById(R.id.button5);
        num6 = findViewById(R.id.button6);

        bigNum = findViewById(R.id.textView);
        equation = findViewById(R.id.textView2);
        score = findViewById(R.id.textView4);
        sEquation = "";

        scoreI = 0;
        rand = new Random();

        top = new int[]{25, 50, 75, 100};
        bottom = new int[]{1,2,3,4,5,6,7,8,9,10};

        initBigNum();
        initChoice();

        num1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(sEquation.equalsIgnoreCase("") || sEquation.split(" ").length == 2) {
                    sEquation += num1.getText().toString() + " ";
                    equation.setText(sEquation);
                    num1.setEnabled(false);
                }
                if (sEquation.split(" ").length == 3) {
                    performEquation();
                }
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (sEquation.equalsIgnoreCase("") || sEquation.split(" ").length == 2) {
                    sEquation += num2.getText().toString() + " ";
                    equation.setText(sEquation);
                    num2.setEnabled(false);
                }
                if (sEquation.split(" ").length == 3) {
                    performEquation();
                }
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(sEquation.equalsIgnoreCase("") || sEquation.split(" ").length == 2) {
                    sEquation += num3.getText().toString() + " ";
                    equation.setText(sEquation);
                    num3.setEnabled(false);
                }
                if (sEquation.split(" ").length == 3) {
                    performEquation();
                }
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(sEquation.equalsIgnoreCase("") || sEquation.split(" ").length == 2) {
                    sEquation += num4.getText().toString() + " ";
                    equation.setText(sEquation);
                    num4.setEnabled(false);
                }
                if (sEquation.split(" ").length == 3) {
                    performEquation();
                }
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(sEquation.equalsIgnoreCase("") || sEquation.split(" ").length == 2) {
                    sEquation += num5.getText().toString() + " ";
                    equation.setText(sEquation);
                    num5.setEnabled(false);
                }
                if (sEquation.split(" ").length == 3) {
                    performEquation();
                }
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(sEquation.equalsIgnoreCase("") || sEquation.split(" ").length == 2) {
                    sEquation += num6.getText().toString() + " ";
                    equation.setText(sEquation);
                    num6.setEnabled(false);
                }
                if (sEquation.split(" ").length == 3) {
                    performEquation();
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(sEquation.split(" ").length == 1 && !sEquation.equalsIgnoreCase("")) {
                    sEquation += "+ ";
                    equation.setText(sEquation);
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(sEquation.split(" ").length == 1 && !sEquation.equalsIgnoreCase("")) {
                    sEquation += "- ";
                    equation.setText(sEquation);
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(sEquation.split(" ").length == 1 && !sEquation.equalsIgnoreCase("")) {
                    sEquation += "/ ";
                    equation.setText(sEquation);
                }
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(sEquation.split(" ").length == 1 && !sEquation.equalsIgnoreCase("")) {
                    sEquation += "x ";
                    equation.setText(sEquation);
                }
            }
        });

        res.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                refreshChoice();
            }
        });

        reroll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                initChoice();
            }
        });

        pass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                initChoice();
                initBigNum();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                if((sEquation.split(" ").length == 1 && !sEquation.equalsIgnoreCase(""))){
                    intent.putExtra("num1", Integer.valueOf(bigNum.getText().toString()));
                    intent.putExtra("num2",Integer.valueOf(sEquation.split(" ")[0]));
                    MainActivity.this.startActivity(intent);
                    initBigNum();
                    initChoice();
                }
            }
        });

        score.setText("Score: " + scoreI);
    }

    private void performEquation(){
        switch(sEquation.split(" ")[1]){
            case "+": int tempAdd = Integer.valueOf(sEquation.split(" ")[0]) + Integer.valueOf(sEquation.split(" ")[2]);
                sEquation = tempAdd + " ";
                equation.setText(sEquation);
                break;
            case "-": int tempSub = Integer.valueOf(sEquation.split(" ")[0]) - Integer.valueOf(sEquation.split(" ")[2]);
                if (tempSub < 0){
                    tempSub*=-1;
                }
                sEquation = tempSub + " ";
                equation.setText(sEquation);
                break;
            case "x": int tempMul = Integer.valueOf(sEquation.split(" ")[0]) * Integer.valueOf(sEquation.split(" ")[2]);
                sEquation = tempMul + " ";
                equation.setText(sEquation);
                break;
            case "/": int tempDiv = Integer.valueOf(sEquation.split(" ")[0]) / Integer.valueOf(sEquation.split(" ")[2]);
                sEquation = tempDiv + " ";
                equation.setText(sEquation);
                break;
        }
    }

    public static void incrementScore(){
        scoreI++;
        score.setText("Score: " + scoreI);
    }

    private void initChoice(){

        num1.setText(top[rand.nextInt(4)] + "");
        num2.setText(top[rand.nextInt(4)] + "");
        if(rand.nextInt(10)%2==1){
            num3.setText(top[rand.nextInt(4)]+"");
        }
        else{
            num3.setText(bottom[rand.nextInt(10)]+"");
        }
        num4.setText(bottom[rand.nextInt(10)]+"");
        num5.setText(bottom[rand.nextInt(10)]+"");
        num6.setText(bottom[rand.nextInt(10)]+"");

        refreshChoice();
    }
    private void checkChoice(){
        if(Integer.valueOf(num1.getText().toString()) >= 100){
            num1.setTextSize(18);
        }
        if(Integer.valueOf(num2.getText().toString()) >= 100){
            num2.setTextSize(18);
        }
        if(Integer.valueOf(num3.getText().toString()) >= 100){
            num3.setTextSize(18);
        }
        if(Integer.valueOf(num4.getText().toString()) >= 100){
            num4.setTextSize(18);
        }
        if(Integer.valueOf(num5.getText().toString()) >= 100){
            num5.setTextSize(18);
        }
        if(Integer.valueOf(num6.getText().toString()) >= 100){
            num6.setTextSize(18);
        }
    }
    private void refreshChoice(){
        num1.setEnabled(true);
        num2.setEnabled(true);
        num3.setEnabled(true);
        num4.setEnabled(true);
        num5.setEnabled(true);
        num6.setEnabled(true);

        num1.setTextSize(24);
        num2.setTextSize(24);
        num3.setTextSize(24);
        num4.setTextSize(24);
        num5.setTextSize(24);
        num6.setTextSize(24);

        sEquation = "";
        equation.setText(sEquation);

        checkChoice();
    }

    private void initBigNum(){
        bigNum.setText(rand.nextInt(999) + "");
    }
}
