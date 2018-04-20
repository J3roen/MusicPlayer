package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


public class ArtistDetailActivity extends AppCompatActivity {
    private ListView listView;
    private AlbumAdapter albumAdapter;
    Artist artist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_detail);
        artist = (Artist) getIntent().getSerializableExtra("artist");
        String title = artist.getName().toUpperCase().concat(" ");
        title = title.concat(getResources().getString(R.string.albumList));
        this.setTitle(title);
        //fill in the album list with albums from current artist, using custom ArrayAdapter
        listView = findViewById(R.id.albumListContainer);
        albumAdapter = new AlbumAdapter(this, artist.getAlbumArrayList());
        listView.setAdapter(albumAdapter);
        /*
        //create new arraylist with album names
        ArrayList<String> albumNames = new ArrayList<String>();
        for (final Album album : artist.getAlbumArrayList())
            albumNames.add(album.getName());
        // fill in the album list with albums from current artist, using ArrayAdapter
        ArrayAdapter<String> albumAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, albumNames);
        ListView listView = findViewById(R.id.albumListContainer);
        listView.setAdapter(albumAdapter);
        final LinearLayout albumListContainer = findViewById(R.id.albumListContainer);
        for (final Album album : artist.getAlbumArrayList()) {
            final TextView albumListView = new TextView(this);
            final LinearLayout.LayoutParams albumLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            albumListView.setAllCaps(true);
            albumListView.setPadding(0, 0, 0, (int) getResources().getDimension(R.dimen.defaultPadding));
            albumListView.setText(album.getName());
            albumListView.setTag("closed");
            //onClickListener to handle expanding and closing the song list of an album
            albumListView.setOnClickListener(new View.OnClickListener() {
                   public void onClick(View v) {
                       int currentIndex = albumListContainer.indexOfChild(albumListView);
                       //if list already expanded, close it. Else expand it
                       if (v.getTag().toString().equals("expanded")) {
                           v.setTag("closed");
                           //close song list
                           albumListContainer.removeViewAt(currentIndex + 1);
                       } else {
                           //expand song list
                           v.setTag("expanded");
                           //create LinearLayout songListLayout
                           LinearLayout songListContainer = new LinearLayout(ArtistDetailActivity.this);
                           LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                           songListContainer.setOrientation(LinearLayout.VERTICAL);
                           params.setMargins((int) getResources().getDimension(R.dimen.defaultPadding) / 2, 0, 0, (int) getResources().getDimension(R.dimen.defaultPadding) / 2);
                           songListContainer.setLayoutParams(params);
                           albumListContainer.addView(songListContainer, currentIndex + 1);
                           //fill songListLayout with list of songs
                           for (final Song song : album.getSongArrayList())
                           {
                               TextView songListView = new TextView (ArtistDetailActivity.this);
                               LinearLayout.LayoutParams songLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                               songListView.setAllCaps(true);
                               songListView.setPadding(0,0,0,(int) getResources().getDimension(R.dimen.defaultPadding));
                               songListView.setText(song.getName());
                               songListView.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       Intent songDetailActivity = new Intent(ArtistDetailActivity.this,SongDetailActivity.class);
                                       songDetailActivity.putExtra("song",song);
                                       songDetailActivity.putExtra("artist",artist.getName());
                                       songDetailActivity.putExtra( "albumCover",album.getCover());
                                       startActivity(songDetailActivity);
                                   }
                               });
                               songListView.setLayoutParams(songLayoutParams);
                               songListContainer.addView(songListView);
                           }
                       }
                   }
            });
            albumListContainer.addView(albumListView, albumLayoutParams);
        }*/

        TextView home = findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivity = new Intent (ArtistDetailActivity.this, MainActivity.class);
                startActivity(mainActivity);
            }
        });
    }
}
