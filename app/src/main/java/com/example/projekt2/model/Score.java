package com.example.projekt2.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Score {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String playerName;
    public int points;

    public Score(String playerName, int points) {
        this.playerName = playerName;
        this.points = points;
    }
}
