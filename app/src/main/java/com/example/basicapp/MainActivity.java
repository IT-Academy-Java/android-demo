package com.example.basicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int result = check();

        Toast.makeText(this,"Hello tostaita from Android -> " + result, Toast.LENGTH_LONG).show();
    }

    private int check(){
        int a = 5;
        int b = 10;
        int c = 20;

        if(a > b){
            return 0;
        } else if (c > a){
            return c;
        } else {
            return a;
        }
    }
}