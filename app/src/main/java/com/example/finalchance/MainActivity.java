package com.example.finalchance;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        b1 = findViewById(R.id.butt1);
        b2 = findViewById(R.id.butt2);

        b1.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), CompActivity.class);
            startActivity(intent);
        });
        b2.setOnClickListener(view -> {
            Intent intent2 = new Intent(getApplicationContext(), FuseActivity.class);
            startActivity(intent2);
        });

    }

}