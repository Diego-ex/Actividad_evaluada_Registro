package com.poblete.actividad_evaluada_registro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity {


    ImageView logoImageView;
    MaterialButton btn_Registro;
    TextInputEditText nameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    RadioGroup rbGroup;
    String genero;
    TextView resultadoPruebaTXT;
    static ArrayList<Usuario> listaUsuario = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //Enlazar
        logoImageView = findViewById(R.id.logoImageView);
        btn_Registro = findViewById(R.id.btn_Registro);
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        rbGroup = findViewById(R.id.rbGroup);
        resultadoPruebaTXT = findViewById(R.id.resultadoPruebaTXT);

        rbGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(R.id.rbFemenino == i){
                    genero = "Femenino";
                }else{
                    genero = "Masculino";
                }
                Toast.makeText(RegistroActivity.this, "Género: "+genero,Toast.LENGTH_SHORT).show();
            }
        });

        btn_Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validación de usuario
                String name = nameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String confirmPassword = confirmPasswordEditText.getText().toString().trim();
                // si el nombre es vacío o si tiene menos de 3 caracteres
                if (name.isEmpty() || name.length() < 3){
                    nameEditText.setError("Se necesitan más de 3 caracteres");
                    return;
                }else{
                    nameEditText.setError(null);
                }
                // si el email es vacío o si es o no una dirección de email (dentro del método entra si no es una dirección)
                if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    emailEditText.setError("Correo invalido");
                    return;
                }else{
                    emailEditText.setError(null);
                }
                // si la contraseña está vacía o tiene menos de 8 caracteres
                if (password.isEmpty() || password.length() < 8){
                    passwordEditText.setError("Se necesitan más de 8 caracteres");
                    return;
                }else if (!Pattern.compile("[0-9]").matcher(password).find()) {
                    //quiero que contenga un número esta contraseña
                    passwordEditText.setError("Al menos ún número");
                    return;
                }else {
                    //si no hay error se continua con la lógica
                    passwordEditText.setError(null);
                }
                // determino si las contraseñas ingresadas son iguales
                if (!confirmPassword.equals(password)){
                    confirmPasswordEditText.setError("Deben ser iguales");
                    return;
                }else {
                    Toast.makeText(RegistroActivity.this, "Hola " + name , Toast.LENGTH_LONG).show();

                    //crear el usuario y añadir a la lista
                    Usuario nUsuario = new Usuario(name, email, password, confirmPassword);
                    listaUsuario.add(nUsuario);
                    //Intent intento = new Intent(RegistroActivity.this, VerRegistroActivity.class);
                    //startActivity(intento);
                    //resultadoPruebaTXT.setText(listaUsuario.toString());
                }
            }
        });

    }

}