package com.empresa.ejercicio1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Alumno on 12/07/2015.
 */
public class Items2Paises extends BaseAdapter {
    Context co;
    String[] pa;
    Integer[] ba;

    public Items2Paises(Context context,
                        String[] vpaises,Integer[] vbanderas){
        co = context;
        pa = vpaises;
        ba = vbanderas;
    }

    @Override
    public int getCount() {
        return pa.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater)co.getSystemService(co.LAYOUT_INFLATER_SERVICE);
        if(convertView==null){
            grid = new View(co);
            grid = inflater.inflate(R.layout.plantilla_paises_grilla,null);
            TextView tpais = (TextView)grid.findViewById(R.id.txtPais);
            ImageView ibandera = (ImageView)grid.findViewById(R.id.imgBandera);
            //La variable position permite obtener la posición en el arreglo
            tpais.setText(pa[position]);
            ibandera.setImageResource(ba[position]);
        }
        else{
            grid = (View) convertView;
        }
        return grid;
    }
}
