package com.example.multilang;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {
    private MediaPlayer mp;
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
       final ArrayList<Word> Words= new ArrayList<>();

        Words.add(new Word("red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        Words.add(new Word("green","chokokki",R.drawable.color_green,R.raw.color_green));
        Words.add(new Word("brown","ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        Words.add(new Word("gray","ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        Words.add(new Word("black","kululli",R.drawable.color_black,R.raw.color_black));
        Words.add(new Word("white","kelelli",R.drawable.color_white,R.raw.color_white));
        Words.add(new Word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        Words.add(new Word("mustard yellow" ,"chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));



//        ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<>(this, R.layout.list_item,Words);
        WordAdapter adapter=new WordAdapter(this,Words,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.color);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, "ONE", Toast.LENGTH_SHORT).show();
            Word word=Words.get(position);
            mp=MediaPlayer.create(this,word.getSound());
            mp.start();
        });
    }
}