package com.example.myjetpack.roomBasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.myjetpack.R;

import java.util.List;

public class RoomBasicActivity extends AppCompatActivity implements View.OnClickListener {

    WordDataBase wordDataBase;
    WordDao wordDao;

    TextView txt;
    Button update,clear,insert,del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_basic);

        wordDataBase = Room.databaseBuilder(this,WordDataBase.class,"word_database")
                .allowMainThreadQueries()//不能用
                .build();
        wordDao = wordDataBase.getWordDao();
        bindWidgets();
        setListener();
        loadData();
    }
    void bindWidgets(){
        txt = findViewById(R.id.item);
        update = findViewById(R.id.updateBtn);
        clear = findViewById(R.id.btnClear);
        insert = findViewById(R.id.btnInsert);
        del = findViewById(R.id.btnDel);
    }

    void setListener(){
        update.setOnClickListener(this);
        insert.setOnClickListener(this);
        clear.setOnClickListener(this);
        del.setOnClickListener(this);
    }

    void loadData(){
        List<Word> list = wordDao.getWords();
        String str = "";
        for(Word word:list)
            str  += "ID:"+word.getId() + " "+word.getWord() +" "+word.getChinese_word()+"\n";
        Log.d("TAG",str);
        txt.setText(str);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.updateBtn:
                Word word = new Word("contain","包括");
                word.setId(6);
                wordDao.updateWords(word);
                break;
            case R.id.btnInsert:
                Word word1 = new Word("name","姓名");
                Word word2 = new Word("sex","性别");
                wordDao.insertWords(word1,word2);
                break;
            case R.id.btnClear:
                wordDao.deleteAllWords();
                break;
            case R.id.btnDel:
                //删除最新的一个记录
                Word word3 = wordDao.getWords().get(0);
                Log.d("TAG",String.valueOf(word3.getId()));
                wordDao.deleteWords(word3);
                break;
        }
        loadData();
    }
}