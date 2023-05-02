package com.example.inventario_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarProductos extends AppCompatActivity implements View.OnClickListener{

    private Spinner spinner;
    private EditText edtId, edtNombre, edtCant;
    private Button btnRegistrar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        edtId = (EditText)findViewById(R.id.edtId);
        edtNombre = (EditText)findViewById(R.id.edtNombre);
        edtCant = (EditText)findViewById(R.id.edtCant);
        spinner = (Spinner)findViewById(R.id.spinner);
        btnRegistrar = (Button)findViewById(R.id.btnMostrar);
        btnRegistrar.setOnClickListener(this);


        String [] opciones = {"Tipo", "Legumbres" , "Verduras", "Carnes", "Frutas", "Cereales", "Lacteos", "Bebestibles" };


        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.desplegable3, menu);
        return true;
    }


    //Metodo para asignar las funciones correspondientes a las opciones
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.opRegresar) {
            Intent intent = new Intent(RegistrarProductos.this, InicioActivity.class);
            startActivity(intent);

        } else {
            finish();
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }

    private void registrarMaterail(){
        SQLUtilities conexion = new SQLUtilities(this, "Material", null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        String id = edtId.getText().toString();
        String nombre = edtNombre.getText().toString();
        String cantidad = edtCant.getText().toString();
        String tipo = spinner.getSelectedItem().toString();


        if ( !id.isEmpty() && !nombre.isEmpty() && !cantidad.isEmpty() && !tipo.equals("Tipo") ){
            ContentValues registro = new ContentValues();

            registro.put("Id", id);
            registro.put("nombre", nombre);
            registro.put("cantidad", cantidad);
            registro.put("tipo", tipo);


            db.insert("Material", null, registro);

            db.close();

            Toast.makeText(this,nombre +" se ha registrado con exito", Toast.LENGTH_SHORT).show();

            edtId.setText("");
            edtNombre.setText("");
            edtCant.setText("");
            spinner.setSelection(0);


        }else{
            Toast.makeText(this," Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }







    }

    @Override
    public void onClick(View view) {
        registrarMaterail();
    }
}