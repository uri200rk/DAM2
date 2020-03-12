package com.example.menu_contextual;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

private ListView listView;
private ImageView imagenQueso;
private TextView registros;
private Button btnMostrar;
    String[] color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] usuaris={"pedro","maria","joan","cristina"};


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,usuaris);

        listView = (ListView) findViewById(R.id.lista);
        listView.setAdapter(adapter);
        imagenQueso =  findViewById(R.id.quesoImagen);
        btnMostrar = findViewById(R.id.imgMostrar);
        registerForContextMenu(listView);
        registerForContextMenu(imagenQueso);

        //localStorage

        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        final boolean valorOcultar = myPreferences.getBoolean("vOcultar", false);
        final String valorColores = myPreferences.getString("colores", "");
        final SharedPreferences.Editor myEditor = myPreferences.edit();





        //accion btnMostrar
        btnMostrar.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                imagenQueso.setVisibility(View.VISIBLE);
                myEditor.putBoolean("vOcultar", false);
                myEditor.commit();




            }
        });

        //visualizacion imagen
        if (valorOcultar == false){
            imagenQueso.setVisibility(View.VISIBLE);

        }else{
            imagenQueso.setVisibility(View.INVISIBLE);

        }

        //recorrer string
//        registros.setText(valorColores);


    }

    //inflar menu correspondiente
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        int id = v.getId();
        MenuInflater inflater = getMenuInflater();

        switch (id){
            case R.id.quesoImagen:
                inflater.inflate(R.menu.context_menu2,menu);
                break;
            case R.id.lista:
                inflater.inflate(R.menu.context_menu,menu);

                break;

        }


    }

    //accion dependiendo del item
    int index;
    String vColores;
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {


        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();

        registros = findViewById(R.id.registros);

        boolean vOcultar ;

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                index = position;
                return false;
            }
        });

        switch (item.getItemId()){
            case R.id.ocultar:
                imagenQueso.setVisibility(View.INVISIBLE);
                registros.setText("\nSe ha ocultado la imagen");
                myEditor.putBoolean("vOcultar", true);
                break;


            case R.id.rojo:
                listView.getChildAt(index).setBackgroundColor(Color.RED);
                registros.setText(registros.getText()+"\nEl item "+index+" ha canviado a color Rojo");
             //   color[index] = "red,";

                break;

            case  R.id.verde:
                listView.getChildAt(index).setBackgroundColor(Color.GREEN);
                registros.setText(registros.getText()+"\nEl item "+index+" ha canviado a color Verde");
              //  color[index] = "green,";

                break;

        }

//        color.toString();
//        myEditor.putString("color",color.toString());
       myEditor.commit();



        return super.onContextItemSelected(item);
    }



}
