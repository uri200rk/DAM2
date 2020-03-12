package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static final String KEY_COUNTER = "COUNTER";
    static final String KEY_COLOR = "COLOR";
    static final String KEY_COLORTEXT = "COLORTEXT";
    static final String KEY_TAMAÑO = "TAMAÑO";
    static final String KEY_MOSTRAR = "MOSTRAR";

    TextView marcador;
    int Imarcador = 0;
    int color;
    int colortext = Color.rgb(0, 0 ,0);
    float tamaño;
    boolean mostrar = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marcador = findViewById(R.id.textView);













        

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);




        button1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Imarcador ++;
                marcador.setText(String.valueOf(Imarcador));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Imarcador --;
                marcador.setText(String.valueOf(Imarcador));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(marcador.getTextSize()<=700){
                    marcador.setTextSize(TypedValue.COMPLEX_UNIT_PX ,marcador.getTextSize()+10);
                    tamaño = marcador.getTextSize();
                }


            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(marcador.getTextSize()>=400) {
                    marcador.setTextSize(TypedValue.COMPLEX_UNIT_PX, marcador.getTextSize() - 10);
                    tamaño = marcador.getTextSize();
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = false;
                marcador.setVisibility(View.INVISIBLE);

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = true;
                marcador.setVisibility(View.VISIBLE);

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                colortext= Color.argb(255,random.nextInt(256),random.nextInt(256), random.nextInt(256));
                marcador.setTextColor(colortext);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                color= Color.argb(255,random.nextInt(256),random.nextInt(256), random.nextInt(256));
                marcador.setBackgroundColor(color);
            }
        });



    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER, Imarcador);
        outState.putInt(KEY_COLOR, color);
        outState.putInt(KEY_COLORTEXT,colortext);
        outState.putFloat(KEY_TAMAÑO, tamaño);
        outState.putBoolean(KEY_MOSTRAR, mostrar);
        Log.v("", "" + mostrar);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Imarcador=savedInstanceState.getInt(KEY_COUNTER);
        color= savedInstanceState.getInt(KEY_COLOR);
        colortext = savedInstanceState.getInt(KEY_COLORTEXT);
        tamaño = savedInstanceState.getFloat(KEY_TAMAÑO);
        mostrar = savedInstanceState.getBoolean(KEY_MOSTRAR);

        marcador.setTextColor(colortext);
        marcador.setBackgroundColor(color);
        marcador.setText(Integer.toString(Imarcador));
        marcador.setTextSize(TypedValue.COMPLEX_UNIT_PX,tamaño);

        if(!mostrar) {
            marcador.setVisibility(View.INVISIBLE);
        }else{
            marcador.setVisibility(View.VISIBLE);
        }

    }



}
