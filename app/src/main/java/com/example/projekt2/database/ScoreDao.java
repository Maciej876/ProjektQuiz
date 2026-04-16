package com.example.projekt2.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.projekt2.model.Score;

import java.util.List;

@Dao
public interface ScoreDao {

    @Insert
    void insert(Score score);

    @Query("SELECT * FROM Score ORDER BY points DESC LIMIT 10")
    List<Score> getTopScores();
}