package com.empresa.ejercicio1;

import android.app.AlertDialog;
import android.app.WallpaperManager;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;


public class FotosActivity extends AppCompatActivity implements View.OnClickListener {
    Integer [] galeria = {
            R.drawable.f1,R.drawable.f2,R.drawable.f3,
            R.drawable.f4,R.drawable.f5,R.drawable.f6,
            R.drawable.f7,R.drawable.f8,R.drawable.f9,
            R.drawable.f10,R.drawable.f11,R.drawable.f12,
            R.drawable.f13,R.drawable.f14,R.drawable.f15
    };
    ImageView visor;
    int posicion;
    Animation animar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotos);
        posicion = 0;
        visor = (ImageView)findViewById(R.id.muestra);
        visor.setImageResource(galeria[posicion]);
        ImageButton bRetroceder = (ImageButton)findViewById(R.id.btnRetroceder);
        ImageButton bAvanzar = (ImageButton)findViewById(R.id.btnAvanzar);
        ImageButton bCerrar = (ImageButton)findViewById(R.id.btnCerrar);
        ImageButton bWallpaper = (ImageButton)findViewById(R.id.btnWallpaper);

        bAvanzar.setOnClickListener(this);
        bRetroceder.setOnClickListener(this);
        bCerrar.setOnClickListener(this);
        bWallpaper.setOnClickListener(this);

        animar = AnimationUtils.loadAnimation(this,R.anim.animarfoto);
        /* Asi se carla la secuencia de la animación */
        animar.reset();/* Se inicializa la animación */


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAvanzar:
                posicion++;
                if(posicion==galeria.length){
                    posicion = 0;
                }
                visor.setImageResource(galeria[posicion]);
                visor.startAnimation(animar);
                break;
            case R.id.btnRetroceder:
                posicion--;
                if(posicion==-1){
                    posicion = galeria.length-1;
                }
                visor.setImageResource(galeria[posicion]);
                visor.startAnimation(animar);
                break;
            case R.id.btnCerrar:
                this.finish();/* Cierra el activity */
                break;
            case R.id.btnWallpaper:
                //Ventana de mensaje: AlertDialog
                AlertDialog vMensaje;
                vMensaje = new AlertDialog.Builder(this).create();
                vMensaje.setTitle("Papel Tapiz");
                vMensaje.setIcon(R.mipmap.ic_alert);
                vMensaje.setMessage("Está seguro que desea cambiar el Papel Tapiz?");
                vMensaje.setButton(DialogInterface.BUTTON_POSITIVE, "Si",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                cambiarWallpaper();
                            }
                        }
                );
                vMensaje.setButton(DialogInterface.BUTTON_NEGATIVE, "No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),
                                        "Se ha cancelado la operación",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                );
                vMensaje.show();/* Para que se muestre la ventana de alerta */
                break;
        }
    }

    private void cambiarWallpaper(){
        WallpaperManager papelTapiz =
                WallpaperManager.getInstance(getApplicationContext());
        try {
            papelTapiz.setResource(galeria[posicion]);
            Toast.makeText(this,"Se ha cambiado el papel tapiz",
                    Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onPause(){
        super.onPause();
        //El método onPause se ejecuta al cerrar el activity
        SharedPreferences.Editor datosGuardar = getPreferences(0).edit();
        datosGuardar.putInt("posImagen",posicion);
        datosGuardar.commit();
        /* Se est{a guardando en el dispositivo un valor (pueden ser varios valores) */
    }
    public void onResume(){
        super.onResume();
        //El método onResume se ejecuta al abrir el activity
        SharedPreferences datosRecuperar = getPreferences(0);
        int posicionImagen = datosRecuperar.getInt("posImagen",-1);
        //Se recupera el valor almacenado en SharedPreferences mediante
        //La clave con la que fue guardada, y si no hay datos por recuperar
        //Se toma un valor por defecto (-1 en este ejemplo)
        if(posicionImagen>-1){
            posicion = posicionImagen;
            visor.setImageResource(galeria[posicion]);
            visor.startAnimation(animar);
        }
    }
}












