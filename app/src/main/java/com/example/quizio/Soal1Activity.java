package com.example.quizio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Soal1Activity extends AppCompatActivity {

    private TextView textViewJawabanA;
    private TextView textViewJawabanB;
    private TextView textViewJawabanC;
    private TextView textViewJawabanD;
    private Button buttonSubmit;
    private String jawabanYangBenar = "a";
    private String jawabanSiPengguna = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal1);

        textViewJawabanA = findViewById(R.id.text_view_jawaban_a_soal_1);
        textViewJawabanB = findViewById(R.id.text_view_jawaban_b_soal_1);
        textViewJawabanC = findViewById(R.id.text_view_jawaban_c_soal_1);
        textViewJawabanD = findViewById(R.id.text_view_jawaban_d_soal_1);
        buttonSubmit = findViewById(R.id.button_submit_jawaban_soal_1);

        textViewJawabanA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewJawabanA.setBackground(ContextCompat.getDrawable(Soal1Activity.this,
                        R.drawable.background_jawaban_dipilih));
                setBackgroundJawabanBBelumDipilih();
                setBackgroundJawabanCBelumDipilih();
                setBackgroundJawabanDBelumDipilih();
                jawabanSiPengguna = "a";
            }
        });
        textViewJawabanB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewJawabanB.setBackground(ContextCompat.getDrawable(Soal1Activity.this,
                        R.drawable.background_jawaban_dipilih));
                setBackgroundJawabanABelumDipilih();
                setBackgroundJawabanCBelumDipilih();
                setBackgroundJawabanDBelumDipilih();
                jawabanSiPengguna = "b";
            }
        });
        textViewJawabanC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewJawabanC.setBackground(ContextCompat.getDrawable(Soal1Activity.this,
                        R.drawable.background_jawaban_dipilih));
                setBackgroundJawabanABelumDipilih();
                setBackgroundJawabanBBelumDipilih();
                setBackgroundJawabanDBelumDipilih();
                jawabanSiPengguna = "c";
            }
        });
        textViewJawabanD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewJawabanD.setBackground(ContextCompat.getDrawable(Soal1Activity.this,
                        R.drawable.background_jawaban_dipilih));
                setBackgroundJawabanABelumDipilih();
                setBackgroundJawabanBBelumDipilih();
                setBackgroundJawabanCBelumDipilih();
                jawabanSiPengguna = "d";
            }
        });
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jawabanSiPengguna.isEmpty()) {
                    Toast.makeText(Soal1Activity.this, "Kamu belum pilih jawabannya",
                            Toast.LENGTH_LONG)
                            .show();
                    return;
                }
                SharedPreferences sharedPreferences = getSharedPreferences("KUIS",
                        Context.MODE_PRIVATE);
                int totalJawabanYangBenar = sharedPreferences.getInt("total_jawaban_benar", 0);
                int totalJawabanYangSalah = sharedPreferences.getInt("total_jawaban_salah", 0);
                if (jawabanSiPengguna.equals(jawabanYangBenar)) {
                    totalJawabanYangBenar += 1;
                } else {
                    totalJawabanYangSalah += 1;
                }
                sharedPreferences.edit().putInt("total_jawaban_benar",
                        totalJawabanYangBenar).apply();
                sharedPreferences.edit().putInt("total_jawaban_salah",
                        totalJawabanYangSalah).apply();

                Intent intentTotalScoreActivity = new Intent(Soal1Activity.this,
                        TotalScoreActivity.class);
                intentTotalScoreActivity.addFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentTotalScoreActivity);
            }
        });
    }

    private void setBackgroundJawabanABelumDipilih() {
        textViewJawabanA.setBackground(ContextCompat.getDrawable(Soal1Activity.this,
                R.drawable.background_jawaban_belum_dipilih));
    }

    private void setBackgroundJawabanBBelumDipilih() {
        textViewJawabanB.setBackground(ContextCompat.getDrawable(Soal1Activity.this,
                R.drawable.background_jawaban_belum_dipilih));
    }

    private void setBackgroundJawabanCBelumDipilih() {
        textViewJawabanC.setBackground(ContextCompat.getDrawable(Soal1Activity.this,
                R.drawable.background_jawaban_belum_dipilih));
    }

    private void setBackgroundJawabanDBelumDipilih() {
        textViewJawabanD.setBackground(ContextCompat.getDrawable(Soal1Activity.this,
                R.drawable.background_jawaban_belum_dipilih));
    }
}
