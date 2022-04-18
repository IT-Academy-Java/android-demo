package com.example.basicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button helloButton;
    private Button byeButton;

    private View nextButton;
    private final String GREETING = "Hello from the other side!";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloButton = findViewById(R.id.helloButton);
        helloButton.setOnClickListener(this);

        // Second form
        byeButton = findViewById(R.id.byeButton);
        byeButton.setOnClickListener(view -> Toast.makeText(MainActivity.this, "Bye bye tinner!!!", Toast.LENGTH_SHORT).show());

        nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Next Activity clicked!!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("greeting", GREETING);
                startActivity(intent);
            }
        });

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

    public final static String AI_ENABLED = "AI_ENABLED";
    private void json() throws JsonProcessingException{
        Expense expense = new Expense("rest. ca la pagesa", 100, new Date(2010-1900,2,1));
        expense.AddNewPayer("Enric", 50);
        expense.AddNewPayer("Jose Miguel", 50);


        User user1 = new User("Enric", "evergaraca@uoc.edu", null);
        User user2 = new User("Jose Miguel", "jm@uoc.edu", null);

        Trip newTrip = new Trip(null, new Date(2010-1900,1,1),"la volta al món");

        //String json = newTrip.Serialize();

        newTrip.AddNewUser(user1);
        newTrip.AddNewUser(user2);
        newTrip.AddNewExpense(expense);
        System.out.println(newTrip.toString());

        System.out.println(newTrip.GetUserNames());

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(newTrip);
    }

}