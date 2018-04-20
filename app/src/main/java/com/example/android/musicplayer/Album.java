package com.example.android.musicplayer;

import java.io.Serializable;
import java.util.ArrayList;

public class Album implements Serializable{

    private ArrayList<Song> songArrayList;
    private String name;
    private int cover;
    private String artistName;

    public Album(String name) {
        setName(name);
        songArrayList = new ArrayList<>();
    }

    public Album(String name, int cover) {
        this(name);
        setCover(cover);
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }

    public ArrayList<Song> getSongArrayList() {
        return songArrayList;
    }

    private void setName(String name) {
        this.name = name.trim().toLowerCase();
    }

    public String getName() {
        return this.name;
    }

    private void setCover(int image) {
        this.cover = image;
    }

    public int getCover() {
        return cover;
    }

    public void addSong(Song song) {
        songArrayList.add(song);
    }
}
