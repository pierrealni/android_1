package com.empresa.ejercicio1;

import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ContinentesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continentes);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                .add(R.id.contenedor, new AmericaFragment()).commit();
        }
    }
    public void verEuropa(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new EuropaFragment()).commit();
    }
    public void verAsia(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new AsiaFragment()).commit();
    }
    public void verAmerica(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new AmericaFragment()).commit();
    }

    public void verAfrica(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new AfricaFragment()).commit();
    }

    public static class AmericaFragment extends Fragment{
        public AmericaFragment(){
        }
        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState){
            View rootView = inflater.inflate(R.layout.fragment_america,container,false);
            return rootView;
        }
    }
    public static class EuropaFragment extends Fragment{
        public EuropaFragment(){
        }
        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState){
            View rootView = inflater.inflate(R.layout.fragment_europa,container,false);
            return rootView;
        }
    }
    public static class AsiaFragment extends Fragment{
        public AsiaFragment(){
        }
        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState){


            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);



            View rootView = inflater.inflate(R.layout.fragment_asia,container,false);
            ImageView fremota= (ImageView)rootView.findViewById(R.id.fotoremota);
            String ruta="http://www.keenthemes.com/preview/metronic/theme/assets/global/plugins/jcrop/demos/demo_files/image1.jpg";
            try{
                URL url = new URL(ruta);
                InputStream inputStream  = (InputStream) (url.getContent());
                Drawable drawable = Drawable.createFromStream(inputStream,"src");
                fremota.setImageDrawable(drawable);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return rootView;
        }
    }
    public static class AfricaFragment extends Fragment{
        public AfricaFragment(){
        }
        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState){
            View rootView = inflater.inflate(R.layout.fragment_africa,container,false);
            final TextView tValor = (TextView) rootView.findViewById(R.id.txtValor);


            final SeekBar ctrl = (SeekBar) rootView.findViewById(R.id.control);
            ctrl.setProgress(ctrl.getMax());
            //Para que al inicio repreente su valor máximo
            tValor.setText("" + ctrl.getProgress());

            final ImageView fsuperior = (ImageView)rootView.findViewById(R.id.fotosuperior);

            ctrl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    tValor.setText("" + ctrl.getProgress());
                    fsuperior.setAlpha((float)ctrl.getProgress()/(float)ctrl.getMax());
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            return rootView;
        }
    }
}
