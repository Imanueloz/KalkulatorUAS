package com.example.kalkulatoruas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<itemhasil> listhasil;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private EditText aedtangka1;
    private EditText aedtangka2;
    private Spinner aspnoperasi;
    private Button abtnhitung;
    private final TextView ahasiloperasi;

    private Double bdoangka1;
    private Double bdoangka2;
    private String bpiloperasi;
    private Double bhasilhitung;

    public MainActivity(ArrayList<itemhasil> listhasil, TextView ahasiloperasi) {
        this.listhasil = listhasil;
        this.ahasiloperasi = ahasiloperasi;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rechasil = findViewById(R.id.rec_hasil);
        initData();

        rechasil.setAdapter(new AdapterHasil());

        preferences = getSharedPreferences(Context.MODE_PRIVATE);
        abtnhitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }

            private void getData() {
            }
        });

        aedtangka1 = findViewById(R.id.edtAngka1);
        aedtangka2 = findViewById(R.id.edtAngka2);
        aspnoperasi = findViewById(R.id.operasi);
        abtnhitung = findViewById(R.id.btnhasil);

        abtnhitung.setOnClickListener(view -> {
            bdoangka1 = Double.valueOf(aedtangka1.getText().toString());
            bdoangka2 = Double.valueOf(aedtangka2.getText().toString());

            bpiloperasi = aspnoperasi.getSelectedItem().toString();

            switch (bpiloperasi) {
                case "+":
                    bhasilhitung = bdoangka1 + bdoangka2;
                    break;
                case "-":
                    bhasilhitung = bdoangka1 - bdoangka2;
                    break;
                case "x":
                    bhasilhitung = bdoangka1 * bdoangka2;
                    break;
                case "/":
                    bhasilhitung = bdoangka1 / bdoangka2;
                    break;
            }

            ahasiloperasi.setText(String.valueOf(bhasilhitung));
        });
    }

    private SharedPreferences getSharedPreferences(int modePrivate) {
        return null;
    }

    private void initData() {
        this.listhasil = new ArrayList<>();
        listhasil.add(new itemhasil(bhasilhitung, R.id.txthasil1));
        listhasil.add(new itemhasil(bhasilhitung, R.id.txthasil2));
        listhasil.add(new itemhasil(bhasilhitung, R.id.txthasil3));
        listhasil.add(new itemhasil(bhasilhitung, R.id.txthasil4));
        listhasil.add(new itemhasil(bhasilhitung, R.id.txthasil5));
        listhasil.add(new itemhasil(bhasilhitung, R.id.txthasil6));
    }
}