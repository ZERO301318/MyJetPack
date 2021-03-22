package com.example.myjetpack.roomBasic;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "engligh_word")
    private String word;
    @ColumnInfo(name = "chinese_word")
    private String chinese_word;

    public Word(String word, String chinese_word) {
        this.word = word;
        this.chinese_word = chinese_word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getChinese_word() {
        return chinese_word;
    }

    public void setChinese_word(String chinese_word) {
        this.chinese_word = chinese_word;
    }
}