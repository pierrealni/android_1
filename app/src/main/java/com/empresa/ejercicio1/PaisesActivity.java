package com.empresa.ejercicio1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


public class PaisesActivity extends AppCompatActivity {
    String[] paises = new String[]{
      "Argentina","Brasil","Canadá","Colombia","Cuba","Perú"
    };
    String[] capitales = new String[]{
      "Buenos Aires","Brasilia","Otawa","Bogotá","La Habana","Lima"
    };
    Integer[] banderas = {
        R.mipmap.ic_argentina,R.mipmap.ic_brasil,R.mipmap.ic_canada,
        R.mipmap.ic_colombia,R.mipmap.ic_cuba,R.mipmap.ic_peru
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);

        ItemsPaises ipaises = new ItemsPaises(this,paises,capitales,banderas);

        ListView lista = (ListView)findViewById(R.id.listaPaises);
        lista.setAdapter(ipaises);

    }
}