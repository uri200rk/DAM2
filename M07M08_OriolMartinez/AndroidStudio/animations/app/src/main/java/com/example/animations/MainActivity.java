package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    ImageView imagen;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    TextView textoAccion;
    SeekBar velocity;




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

        textoAccion = (TextView)findViewById(R.id.textoAccion);

        velocity = (SeekBar)findViewById(R.id.seekBar);


        //declaracion de animaciones

        final Animation aFadeIn,aFadeOut, aLeft_Right, aTop_Bottom, aZoomIN, aZoomOUT, aRotate, aBounce, aFlash;

        //inicializacion animaciones
        aFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        aFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        aLeft_Right = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_right);
        aTop_Bottom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.top_bottom);
        aZoomIN = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        aZoomOUT = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
        aRotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        aBounce = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
        aFlash = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.flash);



        //duracion animaciones
        //seekBar
        aFadeIn.setDuration(2000);
        aFadeOut.setDuration(2000);
        aZoomIN.setDuration(2000);
        aZoomOUT.setDuration(2000);
        aLeft_Right.setDuration(2000);
        aRotate.setDuration(2000);
        aTop_Bottom.setDuration(2000);
        aBounce.setDuration(2000);
        aFlash.setDuration(2000);

        velocity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                aFadeIn.setDuration(progress*100);
                aFadeOut.setDuration(progress*100);
                aZoomIN.setDuration(progress*100);
                aZoomOUT.setDuration(progress*100);
                aLeft_Right.setDuration(progress*100);
                aRotate.setDuration(progress*100);
                aTop_Bottom.setDuration(progress*100);
                aBounce.setDuration(progress*100);
                aFlash.setDuration(progress*100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });











        //FADE IN

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoAccion.setText("Running");
                imagen.startAnimation(aFadeIn);

                aFadeIn.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        imagen.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        textoAccion.setText("Stop");
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
                textoAccion.setText("Running");
                imagen.startAnimation(aFadeOut);

                aFadeOut.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        imagen.setVisibility(View.INVISIBLE);
                        textoAccion.setText("Stop");
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
                textoAccion.setText("Running");
                imagen.startAnimation(aZoomIN);
                aZoomIN.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        textoAccion.setText("Stop");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });



        //ZOOM OUT

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoAccion.setText("Running");
                imagen.startAnimation(aZoomOUT);

                aZoomOUT.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        textoAccion.setText("Stop");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });




        //LEFT RIGHT

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoAccion.setText("Running");
                imagen.startAnimation(aLeft_Right);

                aLeft_Right.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        textoAccion.setText("Stop");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });



        //TOP BOTTOM

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoAccion.setText("Running");
                imagen.startAnimation(aTop_Bottom);

                aTop_Bottom.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        textoAccion.setText("Stop");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });




        //ROTATE

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoAccion.setText("Running");
                imagen.startAnimation(aRotate);

                aRotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        textoAccion.setText("Stop");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });


        //BOUNCE

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoAccion.setText("Running");
                imagen.startAnimation(aBounce);

                aBounce.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        textoAccion.setText("Stop");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });


        //flash

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoAccion.setText("Running");
                imagen.startAnimation(aFlash);

                aFlash.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        textoAccion.setText("Stop");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });


    }
}
