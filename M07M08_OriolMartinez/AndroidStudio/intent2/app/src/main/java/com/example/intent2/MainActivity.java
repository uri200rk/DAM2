package com.example.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Intent in = new Intent(this,Main2Activity.class);
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button);


        button1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent in = new Intent(v.getContext(),Main2Activity.class);
                startActivityForResult(in, 0);
            }
        });






    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            textView = findViewById(R.id.textView);
            textView.setText(data.getStringExtra("valor"));
        }

    }




}
