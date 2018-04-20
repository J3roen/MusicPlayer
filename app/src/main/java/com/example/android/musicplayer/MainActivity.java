package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView artistListContainer;
    private ArtistAdapter artistAdapter;
    public Library library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        library = new Library();

        artistListContainer = findViewById(R.id.artistListContainer);
        artistAdapter = new ArtistAdapter(this, library.getArtistArrayList());
        artistListContainer.setAdapter(artistAdapter);
        /*
        for (final Artist artist : library.getArtistArrayList()) {
            TextView artistListView = new TextView(this);
            LinearLayout.LayoutParams artistLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            artistListView.setAllCaps(true);
            artistListView.setPadding(0, 0, 0, (int) getResources().getDimension(R.dimen.defaultPadding));
            artistListView.setText(artist.getName());
            artistListView.setTypeface(null, Typeface.BOLD);
            artistListView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent detailActivity = new Intent(MainActivity.this, ArtistDetailActivity.class);
                    detailActivity.putExtra("artist",artist);
                    startActivity(detailActivity);
                }
            });
            artistListContainer.addView(artistListView, artistLayoutParams);
        }*/

        TextView nowPlayingView = findViewById(R.id.nowPlayingButton);
        nowPlayingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CurrentSong.getSong() != null) {
                    Intent songDetailActivity = new Intent(MainActivity.this, SongDetailActivity.class);
                    songDetailActivity.putExtra("song", CurrentSong.getSong());
                    songDetailActivity.putExtra("artist", CurrentSong.getArtistName());
                    songDetailActivity.putExtra("albumCover", CurrentSong.getAlbumCover());
                    startActivity(songDetailActivity);
                } else {
                    Toast.makeText(MainActivity.this,getResources().getString(R.string.noSongPlaying),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
