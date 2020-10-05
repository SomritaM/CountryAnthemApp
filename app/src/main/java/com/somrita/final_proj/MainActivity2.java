package com.somrita.final_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent caller=getIntent();
        float rating=caller.getFloatExtra("nbStars",0);
        TextView textView=(TextView)findViewById(R.id.textView);
        textView.setText("Welcome to second activity! Your rating:" +rating);
    }
}