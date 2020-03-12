package com.example.menufragments2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    imagen mFragmentImg;
    lista mFragmentLis;
    int showingFragment = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentImg = new imagen();
        mFragmentLis = new lista();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame, mFragmentImg);
        fragmentTransaction.commit();
        showingFragment= 1;








    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        switch (item.getItemId()) {
            case R.id.imagen_paisaje:
                Toast.makeText(getApplicationContext(),"entro imagen", Toast.LENGTH_SHORT).show();
                fragmentTransaction.replace(R.id.frame, mFragmentImg);
                showingFragment=2;
                break;
            case R.id.llista:
                fragmentTransaction.replace(R.id.frame, mFragmentLis);
                Toast.makeText(getApplicationContext(),"entro lista", Toast.LENGTH_SHORT).show();
                showingFragment=1;

                break;


        }

        fragmentTransaction.commit();
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        int id = v.getId();
        MenuInflater inflater = getMenuInflater();

        switch (id){
            case R.id.imagen_paisaje:
                inflater.inflate(R.menu.context_menu, menu);
                Toast.makeText(getApplicationContext(), "toco imagen", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
    }
}

