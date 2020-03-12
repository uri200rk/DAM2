package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView imagen;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = (ImageView) findViewById(R.id.imagenPollo);

        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        btn5 = (Button)findViewById(R.id.button5);
        btn6 = (Button)findViewById(R.id.button6);
        btn7 = (Button)findViewById(R.id.button7);
        btn8 = (Button)findViewById(R.id.button8);
        btn9 = (Button)findViewById(R.id.button9);
        btn10 = (Button)findViewById(R.id.button10);

        //declaracion de animaciones

        final Animation aFadeIn,aFadeOut, aLeft_Right, aTop_Bottom, aZoomIN, aZoomOUT, aRotate;

        //inicializacion animaciones
        aFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        aFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        aLeft_Right = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_right);
        aTop_Bottom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.top_bottom);
        aZoomIN = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        aZoomOUT = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
        aRotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);








        //duracion animaciones

        long duration = 2000;
        aFadeIn.setDuration(duration);
        aFadeOut.setDuration(duration);
        aZoomIN.setDuration(duration);
        aZoomOUT.setDuration(duration);
        aLeft_Right.setDuration(duration);
        aRotate.setDuration(duration);
        aTop_Bottom.setDuration(duration);




        //FADE IN

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagen.startAnimation(aFadeIn);

                aFadeIn.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        imagen.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });







        //FADE OUT

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagen.startAnimation(aFadeOut);

                aFadeOut.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        imagen.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });


        //ZOOM IN

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagen.startAnimation(aZoomIN);
            }
        });



        //ZOOM OUT

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagen.startAnimation(aZoomOUT);
            }
        });




        //LEFT RIGHT

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imagen.startAnimation(aLeft_Right);

            }
        });



        //TOP BOTTOM

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagen.startAnimation(aTop_Bottom);
            }
        });




        //ROTATE

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagen.startAnimation(aRotate);


            }
        });









    }
}
