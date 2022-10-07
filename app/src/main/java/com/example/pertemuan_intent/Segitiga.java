package com.example.pertemuan_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Segitiga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);

        final EditText alas = (EditText) findViewById(R.id.input_alas);
        final EditText tinggi = (EditText) findViewById(R.id.input_tinggi);
        final EditText luas = (EditText) findViewById(R.id.output_hasil);
        final Button hitung = (Button) findViewById(R.id.btn_hitung);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputAlas = alas.getText().toString();
                String inputTinggi = tinggi.getText().toString();

                try {
                    if(inputAlas.isEmpty()) {
                        alas.setError("Alas tidak boleh kosong");
                    }

                    if(inputTinggi.isEmpty()) {
                        tinggi.setError("Tinggi tidak boleh kosong");
                    }

                    if(!inputAlas.matches("[0-9]+")) {
                        alas.setError("Alas harus berupa angka");
                    }

                    if(!inputTinggi.matches("[0-9]+")) {
                        tinggi.setError("Tinggi harus berupa angka");
                    }

                    double a = Double.parseDouble(inputAlas);
                    double t = Double.parseDouble(inputTinggi);
                    double hasil = 0.5 * a * t;
                    luas.setText(String.valueOf(hasil));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}