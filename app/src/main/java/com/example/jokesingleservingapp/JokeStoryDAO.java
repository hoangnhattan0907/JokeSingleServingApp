package com.example.jokesingleservingapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface JokeStoryDAO {
    @Query("SELECT * FROM JokeStory")
    List<JokeStoryEntity> getAll();
    @Insert
    void insertJokeStory(JokeStoryEntity jokeStoryEntity);
    @Update
    void updateVote(JokeStoryEntity jokeStoryEntity);
}
