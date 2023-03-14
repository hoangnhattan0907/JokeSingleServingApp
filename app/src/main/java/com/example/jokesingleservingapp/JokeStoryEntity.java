package com.example.jokesingleservingapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "JokeStory")
public class JokeStoryEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "content")
    private String content;
    @ColumnInfo(name = "isRead")
    private boolean isRead;
    @ColumnInfo(name = "downVote")
    private int downVote;
    @ColumnInfo(name = "upVote")
    private int upVote;

    public JokeStoryEntity(String content, boolean isRead){
        this.content = content;
        this.isRead = isRead;
        this.downVote = 0;
        this.upVote = 0;
    }

    @Ignore
    public JokeStoryEntity(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public int getDownVote() {
        return downVote;
    }

    public void setDownVote(int downVote) {
        this.downVote = downVote;
    }

    public int getUpVote() {
        return upVote;
    }

    public void setUpVote(int upVote) {
        this.upVote = upVote;
    }

    @Override
    public String toString() {
        return "JokeStoryEntity{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", isRead=" + isRead +
                ", downVote=" + downVote +
                ", upVote=" + upVote +
                '}';
    }
}
