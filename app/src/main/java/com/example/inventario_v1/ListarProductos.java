package com.example.inventario_v1;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListarProductos extends AppCompatActivity {

    FloatingActionButton fabEliminar;

    ListView listViewMateriales;
    ArrayList<String> listaInformacion;
    ArrayList<Material> listaMaterial;
    SQLUtilities conexion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        listViewMateriales = (ListView) findViewById(R.id.listViewPersonas);



        conexion = new SQLUtilities(this, "Material", null,1);

        consultarListaMateriales();
        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listViewMateriales.setAdapter(adaptador);

        listViewMateriales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                String informacion = "Id: " + listaMaterial.get(pos).getId() + "\n";
                informacion += "Nombre: "+ listaMaterial.get(pos).getNombre() + "\n";
                informacion += "Cantidad: "+ listaMaterial.get(pos).getCantidad() + "\n";
                informacion += "Tipo: "+ listaMaterial.get(pos).getTipo() + "\n";

                Toast.makeText(ListarProductos.this,informacion, Toast.LENGTH_LONG).show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.desplegable3, menu);
        return true;
    }


    //Metodo para asignar las funciones correspondientes a las opciones
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.opRegresar) {
            Intent intent = new Intent(ListarProductos.this, InicioActivity.class);
            startActivity(intent);

        } else {
            finish();
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }

    private void consultarListaMateriales() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Material material = null;
        listaMaterial = new ArrayList<Material>();

        Cursor cursor = db.rawQuery("SELECT * FROM Material", null);

        while (cursor.moveToNext()){
            material = new Material();
            material.setId(cursor.getString(0));
            material.setNombre(cursor.getString(1));
            material.setCantidad(cursor.getString(2));
            material.setTipo(cursor.getString(3));

            listaMaterial.add(material);

        }
        obtenerLista();
    }
    private void obtenerLista() {
        listaInformacion = new ArrayList<String>();

        for (int i=0; i<listaMaterial.size(); i++){
            listaInformacion.add("Nombre: " + listaMaterial.get(i).getNombre() + "\nCantidad: " + listaMaterial.get(i).getCantidad() + "\nTipo: " + listaMaterial.get(i).getTipo());
        }
    }
    }
