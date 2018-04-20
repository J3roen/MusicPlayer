package com.example.android.musicplayer;

public abstract class CurrentSong extends Song {
    private static Song song;
    private static String artistName;
    private static int albumCover;


    public static void playSong(Song a) {
        song = a;
    }

    public static void setArtistName(String artistName1) {
        artistName = artistName1;
    }

    public static void setAlbumCover(int cover) {
        albumCover = cover;
    }

    public static String getArtistName() {
        return artistName;
    }

    public static int getAlbumCover() {
        return albumCover;
    }

    public static Song getSong() {
        return song;
    }
}
