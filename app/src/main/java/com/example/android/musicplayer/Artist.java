package com.example.android.musicplayer;

import android.media.Image;

import java.io.Serializable;
import java.util.ArrayList;

public class Artist implements Serializable {

    private String name;
    private Image photo;
    private ArrayList<Album> albumArrayList;

    public Artist(String name) {
        setName(name);
        albumArrayList = new ArrayList<>();
    }

    private void setName(String name) {
        this.name=  name.toLowerCase().trim();
    }

    public String getName() {
        return this.name;
    }

    public void addAlbum(Album album) {
        album.setArtistName(this.name);
        albumArrayList.add(album);
    }

    public ArrayList<Album> getAlbumArrayList() {
        return albumArrayList;
    }
}
