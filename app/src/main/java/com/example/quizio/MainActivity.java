package com.example.quizio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private EditText editTextNama;
    private Button buttonMulaiKuis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("KUIS", Context.MODE_PRIVATE);
        editTextNama = findViewById(R.id.edit_text_nama_activity_main);
        buttonMulaiKuis = findViewById(R.id.button_mulai_kuis_activity_main);

        buttonMulaiKuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = editTextNama.getText().toString();
                if (nama.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nama harus diisi", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    sharedPreferences.edit().putString("nama", nama).apply();
                    Intent intentSoal1Activity = new Intent(
                            MainActivity.this,
                            Soal1Activity.class
                    );
                    startActivity(intentSoal1Activity);
                }
            }
        });
    }
}
