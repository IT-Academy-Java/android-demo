package com.example.basicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    private Button btnThirdActivity;

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

        btnThirdActivity = findViewById(R.id.btnGoToThirdActivity);
        btnThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });


    }
}