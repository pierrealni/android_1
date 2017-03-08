package com.empresa.ejercicio1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class CiudadSeleccionadaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudad_seleccionada);

        TextView tv = (TextView)findViewById(R.id.txtNombreCiudad);

        Bundle datos_recibidos = getIntent().getExtras();
        /*
         * Asi se recupera todos los datos pasados por Bundle en un Intent
         */
        String ciu = datos_recibidos.getString("ciudad_elegida");
        //Asi se recupera el dato especifico de un Bundle
        tv.setText(ciu);

    }
}
