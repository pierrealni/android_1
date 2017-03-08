package com.empresa.ejercicio1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Alumno on 12/07/2015.
 */
public class ItemsPaises extends ArrayAdapter<String> {
    Activity co;
    String[] pa;
    String[] ca;
    Integer[] ba;

    public ItemsPaises(Activity context,
            String[] vpaises, String[] vcapitales,Integer[] vbanderas) {
        super(context, R.layout.plantilla_paises_lista,vpaises);
        co = context;
        pa = vpaises;
        ca = vcapitales;
        ba = vbanderas;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = co.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.plantilla_paises_lista,null,true);
        /* la variable rowView repreentar{ia a cada elemento de la lista */
        TextView tpais = (TextView)rowView.findViewById(R.id.txtPais);
        TextView tcapital = (TextView)rowView.findViewById(R.id.txtCapital);
        ImageView ibandera = (ImageView)rowView.findViewById(R.id.imgBandera);
        //La variable position permite obtener la posición en el arreglo
        tpais.setText(pa[position]);
        tcapital.setText(ca[position]);
        ibandera.setImageResource(ba[position]);

        return rowView;
    }

}
