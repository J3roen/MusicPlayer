package com.example.android.musicplayer;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;

class Library implements Serializable {
    private ArrayList<Artist> artistArrayList;
    private Context context;
    public Library() {
        artistArrayList = new ArrayList<>();
        initializeLibrary();

    }

    public ArrayList<Artist> getArtistArrayList() {
        return artistArrayList;
    }

    public Artist findArtist(String name) throws Exception {
        for (Artist a : artistArrayList) {
            if (a.getName().equals(name))
                return a;
        }
        throw new Exception("artist not found in library");
    }
    private void initializeLibrary() {
        //hard code a test library
        Artist artist = new Artist("Jack Johnson");
        int cover = R.drawable.all_the_light_above_it_too;
        Album album = new Album("All the light above it too", cover);
        Song song = new Song ("Subplots",4,29);
        album.addSong(song);
        song = new Song ("you can't control it",4,9);
        album.addSong(song);
        song = new Song ("sunset for somebody else",3,30);
        album.addSong(song);
        artist.addAlbum(album);

        cover = R.drawable.from_here_to_now_to_you;
        album = new Album("From here to now to you", cover);
        song = new Song ("i got you",2,59);
        album.addSong(song);
        song = new Song ("washing dishes",3,26);
        album.addSong(song);
        song = new Song ("shot reverse shot",3,10);
        album.addSong(song);
        artist.addAlbum(album);
        artistArrayList.add(artist);

        artist = new Artist("Red Hot Chili Peppers");
        cover = R.drawable.im_with_you;
        album = new Album("I'm with you", cover);
        song = new Song("Monarchy of roses",4,12);
        album.addSong(song);
        song = new Song("Factory of faith",4,20);
        album.addSong(song);
        artist.addAlbum(album);
        artistArrayList.add(artist);

        artist = new Artist("Queen");
        cover = R.drawable.queen;
        album = new Album ("Queen", cover);
        song = new Song("keep yourself alive",3,47);
        album.addSong(song);
        song = new Song("doin' all right",4,9);
        album.addSong(song);
        artist.addAlbum(album);

        cover = R.drawable.jazz;
        album = new Album("jazz", cover);
        song = new Song("mustapha",2,59);
        album.addSong(song);
        song = new Song ("fat bottomed girls",4,14);
        album.addSong(song);
        artist.addAlbum(album);
        artistArrayList.add(artist);

    }
}
