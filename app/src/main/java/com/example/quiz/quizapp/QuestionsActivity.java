package com.example.quiz.quizapp;

import android.annotation.SuppressLint;
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


public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    ImageView questionImage;

    int[] questionImages = {
            R.drawable.ocean, // 1. soru için resim
            0, // 2. soru için resim yok
            0, // 3. soru için resim
            R.drawable.dag,
            R.drawable.nehir,
            0,
            R.drawable.buzul,
            0,
            0,
            R.drawable.roma,

    };

    String questions[] = {
            "Dünyanın en büyük okyanusu hangisidir?",
            "Amazon Nehri hangi kıtada bulunur?",
            "Hangi ülke hem Avrupa hem de Asya kıtasında yer alır?",
            "Dünya üzerindeki en yüksek dağ hangisidir?",
            "Nil Nehri hangi denize dökülür?",
            "Hangi ülke dünyanın en kalabalık nüfusuna sahiptir?",
            "Kuzey Kutbu hangi okyanusun içinde yer alır?",
            "Dünyanın en büyük çölü hangisidir?",
            "Güney Amerika kıtasının en uzun nehri hangisidir?",
            "İtalya'nın başkenti hangi şehirdir?",

    };


    String answers[] = {
            "Pasifik Okyanusu",
            "Güney Amerika",
            "Türkiye",
            "Everest Dağı",
            "Akdeniz",
            "Çin",
            "Arktik Okyanusu",
            "Sahra Çölü",
            "Amazon Nehri",
            "Roma"
    };

    String opt[] = {
            "Atlantik Okyanusu", "Hint Okyanusu", "Pasifik Okyanusu", "Arktik Okyanusu",
            "Asya", "Afrika", "Güney Amerika", "Kuzey Amerika",
            "Türkiye", "Rusya", "Yunanistan", "Mısır",
            "K2", "Everest Dağı", "Aconcagua", "Denali",
            "Kızıl Deniz", "Akdeniz", "Hint Okyanusu", "Atlantik Okyanusu",
            "Rusya", "Çin", "Amerika Birleşik Devletleri", "Endonezya",
            "Atlantik Okyanusu", "Arktik Okyanusu", "Pasifik Okyanusu", "Hint Okyanusu",
            "Sahra Çölü", "Gobi Çölü", "Arap Çölü", "Kalahari Çölü",
            "Amazon Nehri", "Orinoco Nehri", "Paraná Nehri", "Rio Grande",
            "Milano", "Venedik", "Floransa", "Roma"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @SuppressLint("SuspiciousIndentation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        questionImage = (ImageView) findViewById(R.id.questionImage);

        final TextView score = (TextView)findViewById(R.id.textView4);
        //TextView textView=(TextView)findViewById(R.id.DispName);
        //Intent intent = getIntent();
        //String name= intent.getStringExtra("myname");

        //if (name.trim().equals(""))
         //   textView.setText("Merhabalar");
        //else
        //textView.setText("Merhaba " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);
        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
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
                    Toast.makeText(getApplicationContext(), "Lütfen bir şıkkı seçiniz", Toast.LENGTH_SHORT).show();
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
                if (flag < questions.length) {
                    // Soruyu ve şıkları güncelle
                    int imageResId = questionImages[flag];
                    if (imageResId != 0) {
                        questionImage.setImageResource(imageResId);
                        questionImage.setVisibility(View.VISIBLE);
                    } else {
                        questionImage.setImageResource(android.R.color.transparent);
                    }
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                } else {
                    // Sorular bittiğinde ResultActivity'ye geçiş yap
                    Intent intent = new Intent(QuestionsActivity.this, ResultActivity2.class);
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
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}

