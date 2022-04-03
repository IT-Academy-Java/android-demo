package com.example.basicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button greetingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // First form
        // greetingButton = findViewById(R.id.helloButton);
        // greetingButton.setOnClickListener(view -> Toast.makeText(MainActivity.this, "Hello darling!!!", Toast.LENGTH_SHORT).show());

        greetingButton = findViewById(R.id.helloButton);
        greetingButton.setOnClickListener(this);


        // Super Toast
        SuperActivityToast.create(this, new Style(), Style.TYPE_BUTTON)
                .setButtonText("UNDO")
                .setButtonIconResource(R.drawable.ic_undo)
                .setProgressBarColor(Color.WHITE)
                .setText("Welcome to APP from SUPER TOAST!!!")
                .setDuration(Style.DURATION_LONG)
                .setFrame(Style.FRAME_LOLLIPOP)
                .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_PURPLE))
                .setAnimations(Style.ANIMATIONS_POP).show();
    }


    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this, "Hello darling!!!", Toast.LENGTH_SHORT).show();
    }
}