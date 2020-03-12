package com.example.menuifragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentImg mFragmentImg;
    FragmentLis mFragmentLis;
    int showingFragment = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentImg = new FragmentImg();
        mFragmentLis = new FragmentLis();

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
            case R.id.llista:
                Toast.makeText(getApplicationContext(),"entro lista", Toast.LENGTH_SHORT).show();
                fragmentTransaction.replace(R.id.frame, mFragmentLis);
                showingFragment=1;
                break;
            case R.id.imagen:
                fragmentTransaction.replace(R.id.frame, mFragmentImg);
                Toast.makeText(getApplicationContext(),"entro imagen", Toast.LENGTH_SHORT).show();
                showingFragment=2;

                break;



        }

        fragmentTransaction.commit();
        return super.onOptionsItemSelected(item);

    }


}

