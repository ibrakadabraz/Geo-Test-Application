package com.example.quiz.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity2 extends AppCompatActivity {
    TextView tvm, tv2m, tv3m;
    Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_2);

        tvm = (TextView) findViewById(R.id.tvresm);
        tv2m = (TextView) findViewById(R.id.tvres2m);
        tv3m = (TextView) findViewById(R.id.tvres3m);
        btnRestart = (Button) findViewById(R.id.btnRestart);

        // Intent'ten verileri al
        int correct = getIntent().getIntExtra("correct", 0);
        int wrong = getIntent().getIntExtra("wrong", 0);

        // StringBuffers'ı kullanarak sonuçları göster
        StringBuffer sb = new StringBuffer();
        sb.append("Doğru Cevaplar: " + correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Yanlış Cevaplar: " + wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Başarı Skoru: " + correct + "\n"); // Başarı skorunuzu hesaplama yönteminize bağlıdır.
        tvm.setText(sb);
        tv2m.setText(sb2);
        tv3m.setText(sb3);

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }
        });
    }
}

