package com.poblete.actividad_evaluada_registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class VerRegistroActivity extends AppCompatActivity {

    ImageView logoImageView;
    TextView UsuariosTXT;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_registro);

        logoImageView = findViewById(R.id.logoImageView);
        UsuariosTXT = findViewById(R.id.UsuariosTXT);
        recycler = findViewById(R.id.recycler);

        recycler.setLayoutManager(new LinearLayoutManager(this));



    }
}