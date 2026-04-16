package com.example.projekt2.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.projekt2.model.Score;

@Database(entities = {Score.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ScoreDao scoreDao();
}