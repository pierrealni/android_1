package com.empresa.ejercicio1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;


public class Paises2Activity extends AppCompatActivity {
    String[] paises = new String[]{
            "Argentina","Brasil","Canadá","Colombia","Cuba","Perú"
    };
    Integer[] banderas = {
            R.mipmap.ic_argentina,R.mipmap.ic_brasil,R.mipmap.ic_canada,
            R.mipmap.ic_colombia,R.mipmap.ic_cuba,R.mipmap.ic_peru
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises2);

        Items2Paises ipaises = new Items2Paises(this,paises,banderas);

        GridView gv = (GridView)findViewById(R.id.gridPaises);
        gv.setAdapter(ipaises);

        //Para seleccionar un elemento de la lista
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),paises[position],
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
