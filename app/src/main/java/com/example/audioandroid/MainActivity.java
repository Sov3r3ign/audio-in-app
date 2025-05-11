package com.example.audioandroid;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button song1, song2;
    MediaPlayer mpSong1, mpSong2;
    int playing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        song1 = (Button) findViewById(R.id.btnDrake);
        song2 = (Button) findViewById(R.id.btnPost);

        song1.setOnClickListener(bDrake);
        song2.setOnClickListener(bPost);

        mpSong1 = new MediaPlayer();
        mpSong1 = MediaPlayer.create(this, R.raw.drake);

        mpSong2 = new MediaPlayer();
        mpSong2 = MediaPlayer.create(this, R.raw.take);

        playing =0;


    }
    Button.OnClickListener bDrake = new Button.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            switch(playing)
            {
                case 0:
                    mpSong1.start();
                    playing = 1;
                    song1.setText("Pause God's Plan");
                    song2.setVisibility(View.INVISIBLE);
                    break;
                case 2:
                    mpSong1.pause();
                    playing = 0;
                    song1.setText("Play God's Plan");
                    song2.setVisibility(View.VISIBLE);
                    break;
            }

        }
    };
    Button.OnClickListener bPost= new Button.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            switch(playing)
            {
                case 0:
                    mpSong2.start();
                    playing = 1;
                    song2.setText("Pause Take what you want");
                    song1.setVisibility(View.INVISIBLE);
                    break;
                case 2:
                    mpSong2.pause();
                    playing = 0;
                    song2.setText("Play Take what you want");
                    song1.setVisibility(View.VISIBLE);
                    break;
            }

        }
    };
}