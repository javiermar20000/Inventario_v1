package com.example.inventario_v1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class TiendasConsulta extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiendas);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.desplegable2, menu);
        return true;
    }

    //Metodo para asignar las funciones correspondientes a las opciones
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.opRegresar){
            Intent intent = new Intent( TiendasConsulta.this, InicioActivity.class);
            startActivity(intent);

        }else if ( id == R.id.opSesion ){
            Intent intent = new Intent( TiendasConsulta.this, LoginSession.class);
            startActivity(intent);

        }else if(id == R.id.opPreferencias){
            Intent intent = new Intent( TiendasConsulta.this, Preferencias.class);
            startActivity(intent);

        }else{
            finish();
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }}