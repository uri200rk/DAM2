package com.example.provesso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    SoundPool sp, sp2;
    int song = 0;
    int song2 = 0;
    int soundID1 = 0;
    int soundID2 = 0;
    Button btnMusic1, btnMusic2, btnStop;
    SeekBar volume;
    float volumenLevel = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMusic1 = (Button)findViewById(R.id.so1);
        btnMusic2 = (Button)findViewById(R.id.so2);
        btnStop = (Button)findViewById(R.id.stop);
        volume = (SeekBar) findViewById(R.id.seekBar);

        volume.setMin(1);
        volume.setMax(100);


        volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sp.setVolume(soundID1,(float)progress/100,progress/100);
                sp2.setVolume(soundID2,(float)progress/100,progress/100);
                Log.d("a", " "+(float)progress/100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //soundPool1

        sp = new SoundPool(2, AudioManager.STREAM_MUSIC,1);
        song = sp.load(this, R.raw.music3,1);


        btnMusic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundID1= sp.play(song,1, 1,1, 0, 1);

            }
        });


        sp2 = new SoundPool(2, AudioManager.STREAM_MUSIC,1);
        song2 = sp2.load(this, R.raw.music1,2);

        btnMusic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundID2= sp2.play(song2,1, 1,1, 0, 1);
            }
        });




        //stop

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sp.stop(soundID1);
                sp2.stop(soundID2);


            }
        });




    }


}
