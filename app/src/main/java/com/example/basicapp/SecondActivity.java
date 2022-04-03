package com.example.basicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.textVieMain);

        // get intent data
        Bundle bundle = getIntent().getExtras();
        if(bundle != null && bundle.getString("greeting") != null){
            String greeter = bundle.getString("greeting");
            Toast.makeText(SecondActivity.this, "==>>>" + greeter, Toast.LENGTH_LONG).show();
            textView.setText(greeter);
        } else{
            Toast.makeText(SecondActivity.this, "Empty!!!", Toast.LENGTH_SHORT).show();
        }


    }
}