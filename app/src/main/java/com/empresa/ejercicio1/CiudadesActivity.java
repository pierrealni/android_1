package com.empresa.ejercicio1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Alumno on 05/07/2015.
 */
public class CiudadesActivity extends ListActivity {
    String[] ciudades = new String[]{
        "Tacna","Moquegua","Arequipa","Ica","Lima","Chimbote",
            "Huaraz","Trujillo","Chiclayo","Piura","Tumbas",
            "Puno","Cuzco","Apurimac"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListAdapter listado = new ArrayAdapter<String>(
               this,android.R.layout.simple_list_item_1,ciudades
        );
        /*
        * El arreglo se mostrar{a en un layout predefinido simple_list_item_1
        * */
        setListAdapter(listado);

        final ListView listView = getListView();
        //Asi del activity se obtiene un ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*
                 * La variable position generada permite obtener la posición
                 * del elemento seleccionado en la lista
                 */
                String ciudad = listView.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),ciudad,Toast.LENGTH_LONG).show();

                Bundle datos = new Bundle();
                //La clase Bundle se usa para pasar datos a otro activity
                datos.putString("ciudad_elegida",ciudad);
                //Se pasa mediante un key o clave

                Intent i = new Intent(getApplicationContext(),
                                    CiudadSeleccionadaActivity.class);
                i.putExtras(datos);/* Asi se pasa con el activity los
                 datos del Bundle */
                startActivity(i);
            }
        });

    }
}










