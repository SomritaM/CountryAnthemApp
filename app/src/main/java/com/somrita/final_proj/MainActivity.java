package com.somrita.final_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer pianoMusic;
    MediaPlayer pianoMusics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pianoMusic = MediaPlayer.create(this,
                R.raw.piano);
        pianoMusics= MediaPlayer.create(this,
                R.raw.piano2);
        Switch switch1 = (Switch) findViewById(R.id.switch1);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                pianoMusic.setLooping(isChecked);
            }
        });
    }
    public void playMusic(View v)
    {
        pianoMusic.start();
    }
    public void playBack(View v)
    {
        pianoMusics.start();
    }
    public void pauseMusic(View v)
    {
        if(pianoMusic.isPlaying())
            pianoMusic.pause();
        if(pianoMusics.isPlaying())
            pianoMusics.pause();
    }
    public void enter(View v) {
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        float rating = ratingBar.getRating();
        Intent goToSecond = new Intent();
        goToSecond.setClass(this, MainActivity2.class);
        startActivity(goToSecond);
        goToSecond.putExtra("nbStars", rating);
        startActivity(goToSecond);
        finish();
        if(v.equals(pianoMusic))
            Toast.makeText(getApplicationContext(),"It is Indian National Anthem",Toast.LENGTH_SHORT).show();
        if(v.equals(pianoMusics))
            Toast.makeText(getApplicationContext(),"It is Bangladesh National Anthem",Toast.LENGTH_SHORT).show();
    }
    }
