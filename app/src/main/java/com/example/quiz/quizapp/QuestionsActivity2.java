package com.example.quiz.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;


public class QuestionsActivity2 extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    ImageView questionImage;

    private Object questions;
    int[] questionImages = {
            0, // 1. soru için resim
            R.drawable.gol, // 2. soru için resim yok
            R.drawable.amerika, // 3. soru için resim
            R.drawable.dag,
            0,
            R.drawable.buzul,
            0,
            0,
            0,
            R.drawable.dag,

    };
    String question[] = {
            "Sahra Çölü hangi kıtada bulunur?",
            "Dünyanın yüzey alanı olarak en büyük gölü hangisidir?",
            "Hangi ülke Güney Amerika ve Kuzey Amerika arasında bir köprü görevi görür?",
            "Everest Dağı'ndan sonra dünyanın ikinci en yüksek dağı hangisidir?",
            "Amazon Ormanları hangi ülkelerde bulunur?",
            "Güney Kutbu hangi kıtada yer alır?",
            "Dünyanın en derin okyanus çukuru hangisidir?",
            "Victoria Şelalesi hangi iki Afrika ülkesi arasında yer alır?",
            "Avustralya kıtasındaki en büyük şehir hangisidir?",
            "Himalayalar hangi iki ülke arasında uzanır?"

    };


    String answers[] = {
            "Afrika",
            "Hazar Gölü",
            "Panama",
            "K2",
            "Brezilya, Peru, Kolombiya",
            "Antarktika",
            "Mariana Çukuru",
            "Zambiya ve Zimbabve",
            "Sidney",
            "Nepal ve Çin"
    };

    String opt[] = {
            "Asya", "Afrika", "Avustralya", "Kuzey Amerika",
            "Victoria Gölü", "Üst Göl", "Hazar Gölü", "Titikaka Gölü",
            "Meksika", "Kosta Rika", "Panama", "Nikaragua",
            "Lhotse", "K2", "Makalu", "Cho Oyu",
            "Brezilya, Peru, Kolombiya", "Ekvador, Bolivya, Venezuela", "Guyana, Surinam, Fransız Guyanası", "Arjantin, Uruguay, Paraguay",
            "Antarktika", "Kuzey Amerika", "Güney Amerika", "Asya",
            "Java Çukuru", "Philippine Çukuru", "Mariana Çukuru", "Tonga Çukuru",
            "Nijer ve Çad", "Kenya ve Tanzanya", "Zambiya ve Zimbabve", "Malavi ve Mozambik",
            "Melbourne", "Sidney", "Perth", "Brisbane",
            "Nepal ve Hindistan", "Nepal ve Çin", "Bhutan ve Çin", "Pakistan ve Hindistan"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_2);
        questionImage = (ImageView) findViewById(R.id.questionImage);

        //final TextView score = (TextView)findViewById(R.id.textView4);
        //TextView textView=(TextView)findViewById(R.id.DispName);
        //Intent intent = getIntent();
        //String name= intent.getStringExtra("myname");

        //if (name.trim().equals(""))
         //   textView.setText("Merhabalar");
        //else
        //    textView.setText("Merhaba " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(question[flag]);
        tv.setVisibility(View.VISIBLE);

        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Lütfen bir seçeneği seçiniz", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Doğru", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Yanlış", Toast.LENGTH_SHORT).show();
                }

                flag++;

                // Yeni soru için resmi güncelle veya sonuca geçiş yap
                if (flag < question.length) {
                    // Soruyu ve şıkları güncelle
                    int imageResId = questionImages[flag];
                    if (imageResId != 0) {
                        questionImage.setImageResource(imageResId);
                        questionImage.setVisibility(View.VISIBLE);
                    } else {
                        questionImage.setImageResource(android.R.color.transparent);
                    }
                    tv.setText(question[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                } else {
                    // Sorular bittiğinde ResultActivity'ye geçiş yap
                    // Sorular bittiğinde ResultActivity'ye geçiş yap
                    Intent intent = new Intent(getApplicationContext(), ResultActivity2.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }


                // RadioGroup'un seçimini temizle
                radio_g.clearCheck();
            }
        });
        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity2.class);
                intent.putExtra("correct", correct); // 'correct' ve 'wrong', QuestionsActivity2'deki değişkenlerdir.
                intent.putExtra("wrong", wrong);
                startActivity(intent);

            }
        });

    }

}


