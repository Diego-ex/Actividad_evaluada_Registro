package com.poblete.actividad_evaluada_registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button btn_Registro, btn_VerTodo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //enlazar botones
        btn_Registro = findViewById(R.id.btn_Registro);
        btn_VerTodo = findViewById(R.id.btn_VerTodo);

        btn_Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cambio a la actividad de registro de usuarios
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        btn_VerTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cambio a la actividad ver registros
                Intent intent2 = new Intent(MainActivity.this, VerRegistroActivity.class);
                startActivity(intent2);
            }
        });

    }
}