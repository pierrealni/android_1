package com.empresa.ejercicio1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView tMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Paseando por el Peru");
        tMensaje = (TextView)findViewById(R.id.txtMensaje);
        tMensaje.setText("Esto es Android");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cambiar) {
            tMensaje.setText("Movil en lo movil");
            return true;
        }
        if (id == R.id.action_titulo) {
            this.setTitle("Aplicacion para Viajeros");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void cambiarSaludo(View view) {
        tMensaje.setText("Viajando");
        this.setTitle("Por el Peru");
    }

    public void cerrar(View view) {
        this.finish();//Se cierra el activity
    }

    public void mostrarFotos(View view) {
        Intent intent = new Intent(this,FotosActivity.class);
        startActivity(intent);
        //Asi se llama a otro activity;
    }

    public void verPaginaWeb(View view) {
        String ruta = "https://www.youtube.com/watch?v=dXf3cAhoqQE";
        //String ruta = "http://www.android.com/";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(ruta));
        startActivity(i);
    }

    public void verCiudades(View view) {
        Intent intent = new Intent(this,CiudadesActivity.class);
        startActivity(intent);
    }
}













