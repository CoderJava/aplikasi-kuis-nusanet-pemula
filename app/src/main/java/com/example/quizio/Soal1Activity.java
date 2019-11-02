package com.example.quizio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Soal1Activity extends AppCompatActivity {

    private TextView textViewJawabanA;
    private TextView textViewJawabanB;
    private TextView textViewJawabanC;
    private TextView textViewJawabanD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal1);

        textViewJawabanA = findViewById(R.id.text_view_jawaban_a_soal_1);
        textViewJawabanB = findViewById(R.id.text_view_jawaban_b_soal_1);
        textViewJawabanC = findViewById(R.id.text_view_jawaban_c_soal_1);
        textViewJawabanD = findViewById(R.id.text_view_jawaban_d_soal_1);
    }
}
