package com.example.android.musicplayer;

import java.io.Serializable;

class Song implements Serializable{

    private String name;
    private int duration;

    public Song() {

    }

    public Song(String name, int durationMinutes, int durationSeconds) {
        setName(name);
        setDuration(durationMinutes, durationSeconds);
    }

    private void setName(String name) {
        this.name = name.trim().toLowerCase();
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return this.name;
    }

    public int getDuration() {
        return this.duration;
    }

    private void setDuration(int minutes, int seconds) {
        this.duration = seconds + (minutes * 60);
    }

}
