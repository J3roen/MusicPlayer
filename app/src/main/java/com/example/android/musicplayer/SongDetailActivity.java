package com.example.android.musicplayer;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SongDetailActivity extends AppCompatActivity {
private Song song;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);
        //set song title view
        song = (Song) getIntent().getSerializableExtra("song");
        String title = song.getName().toUpperCase().concat(" by ").concat(getIntent().getStringExtra("artist").toUpperCase());
        this.setTitle(title);

        //set cover image
        Drawable cover = getResources().getDrawable(getIntent().getIntExtra("albumCover",-1));
        ImageView coverImage = findViewById(R.id.albumImage);
        coverImage.setImageDrawable(cover);

        //if song is already playing, change text & behaviour of button
        final Button button = findViewById(R.id.playNowButton);
        if (CurrentSong.getSong() != null && CurrentSong.getSong().getName().equals(song.getName()))
        {
            button.setText(getResources().getString(R.string.alreadyPlaying));
        } else {
            button.setText(getResources().getString(R.string.playNowButton));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setCurrentSong(view);
                    button.setText(getResources().getString(R.string.alreadyPlaying));
                }
            });
        }
    }

    public void setCurrentSong (View v) {
        CurrentSong.playSong((Song) getIntent().getSerializableExtra("song"));
        CurrentSong.setAlbumCover(getIntent().getIntExtra("albumCover",-1));
        CurrentSong.setArtistName(getIntent().getStringExtra("artist").toUpperCase());
        Toast.makeText(this,getResources().getString(R.string.playSongConfirmation),Toast.LENGTH_LONG).show();
    }
}
