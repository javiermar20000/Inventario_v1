package com.example.inventario_v1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class InicioActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnReg, btnBu, btnLi, btnPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btnReg = (Button)findViewById(R.id.btnReg);
        btnBu = (Button)findViewById(R.id.btnBu);
        btnLi = (Button)findViewById(R.id.btnLi);
        btnPref = (Button)findViewById(R.id.btnPref);

        btnReg.setOnClickListener(this);
        btnBu.setOnClickListener(this);
        btnLi.setOnClickListener(this);
        btnPref.setOnClickListener(this);
        SQLUtilities conexion = new SQLUtilities(this, "Producto", null,1);
    }


    //Metodo para mostrar y ocultar el menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }


    //Metodo para asignar las funciones correspondientes a las opciones
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.opRegistrar) {
            Intent intent = new Intent(InicioActivity.this, RegistrarProductos.class);
            startActivity(intent);

        } else if (id == R.id.opMostrar) {
            Intent intent = new Intent(InicioActivity.this, MostrarProductos.class);
            startActivity(intent);

        } else if (id == R.id.opListar) {
            Intent intent = new Intent(InicioActivity.this, ListarProductos.class);
            startActivity(intent);

        } else if (id == R.id.opSalir) {
            Intent intent = new Intent(InicioActivity.this, LoginSession.class);
            startActivity(intent);

        } else if (id == R.id.opPref) {
            Intent intent = new Intent(InicioActivity.this, Preferencias.class);
            startActivity(intent);
        } else {
            finish();
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnReg) {
            Intent in = new Intent(InicioActivity.this, RegistrarProductos.class);
            startActivity(in);

        } else if (id == R.id.btnBu) {
            Intent in2 = new Intent(InicioActivity.this, MostrarProductos.class);
            startActivity(in2);

        } else if (id == R.id.btnLi) {
            Intent in3 = new Intent(InicioActivity.this, ListarProductos.class);
            startActivity(in3);

        } else if (id == R.id.btnPref) {
            Intent in4 = new Intent(InicioActivity.this, TiendasConsulta.class);
            startActivity(in4);
        }}}




