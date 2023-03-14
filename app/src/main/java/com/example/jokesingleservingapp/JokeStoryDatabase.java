package com.example.jokesingleservingapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//Singleton
@Database(entities = {JokeStoryEntity.class},version = 1)
public abstract class JokeStoryDatabase extends RoomDatabase {
    private static JokeStoryDatabase instance = null;
    private static final String DATABASE_NAME = "JokeStory.db";

    public synchronized static JokeStoryDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),JokeStoryDatabase.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract JokeStoryDAO getJokeStoryDAO();
}
