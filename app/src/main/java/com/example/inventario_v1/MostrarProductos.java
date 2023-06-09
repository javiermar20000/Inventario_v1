package com.example.inventario_v1;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MostrarProductos extends AppCompatActivity implements View.OnClickListener{

    private EditText edtRut, edtNombre, edtCant,edtTipo;
    private Button btnBuscar;
    SQLUtilities conexion;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        conexion = new SQLUtilities(this, "Material", null,1);

        edtRut = (EditText)findViewById(R.id.edtId);
        edtNombre = (EditText)findViewById(R.id.edtNombre);
        edtCant = (EditText)findViewById(R.id.edtCant);
        edtTipo = (EditText)findViewById(R.id.edtTipo);
        btnBuscar = (Button)findViewById(R.id.btnMostrar);
        btnBuscar.setOnClickListener(this);


    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.desplegable3, menu);
        return true;
    }


    //Metodo para asignar las funciones correspondientes a las opciones
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.opRegresar) {
            Intent intent = new Intent(MostrarProductos.this, InicioActivity.class);
            startActivity(intent);

        } else {
            finish();
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }

    private void BuscarPersona(){

        SQLiteDatabase db = conexion.getReadableDatabase();
        String[] parametros = {edtRut.getText().toString()};


        try {
            Cursor cursor = db.rawQuery("SELECT nombre, cantidad, tipo FROM Material WHERE id=?",parametros);
            cursor.moveToFirst();

            edtNombre.setText(cursor.getString(0));
            edtCant.setText(cursor.getString(1));
            edtTipo.setText(cursor.getString(2));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(this,"El ID especificado no existe", Toast.LENGTH_SHORT).show();

            edtNombre.setText("");
            edtCant.setText("");
            edtTipo.setText("");
        }


    }


    @Override
    public void onClick(View view) {
        BuscarPersona();
    }
}