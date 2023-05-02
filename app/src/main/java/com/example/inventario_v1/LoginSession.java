package com.example.inventario_v1;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import com.google.android.material.button.MaterialButton;

import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class LoginSession extends AppCompatActivity {

    CheckBox checkGuardarSesion;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_session);

        TextView NombreUsuario =(TextView) findViewById(R.id.NombreUsuario);
        TextView Contrasena =(TextView) findViewById(R.id.Contrasena);



        MaterialButton Boton = (MaterialButton) findViewById(R.id.Boton);
        MaterialButton Boton2 = (MaterialButton) findViewById(R.id.Boton2);

        //admin and admin password
        Boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(NombreUsuario.getText().toString().equals("javier") && Contrasena.getText().toString().equals("1234")){
                    //Login correct
                    Toast.makeText(LoginSession.this,"Inicio de sesion EXITOSO!!!!!!",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginSession.this,InicioActivity.class));
                }else
                    //Login NOT WORKS!
                    Toast.makeText(LoginSession.this,"Inicio de sesion FALLIDO!!!!",Toast.LENGTH_SHORT).show();
            }
        });
        Boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(NombreUsuario.getText().toString().equals("") || Contrasena.getText().toString().equals("")){
                    Toast.makeText(LoginSession.this, "Llene todos los campos para el registro", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginSession.this, "Registro Exitoso, iniciando sesión",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginSession.this,InicioActivity.class));
                }
            }

        });
    }


}