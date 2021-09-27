package com.example.multilang;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
       final ArrayList<Word> Words= new ArrayList<>();


        Words.add(new Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        Words.add(new Word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        Words.add(new Word("My name is...","oyaaset...",R.raw.phrase_my_name_is));
        Words.add(new Word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        Words.add(new Word("I’m feeling good","kuchi achit",R.raw.phrase_im_feeling_good));
        Words.add(new Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        Words.add(new Word("Yes, I’m coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        Words.add(new Word("I’m coming.","әәnәm",R.raw.phrase_im_coming));
        Words.add(new Word("Let’s go.","yoowutis",R.raw.phrase_lets_go));
        Words.add(new Word("Come here.","әnni'nem",R.raw.phrase_come_here));

//        ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<>(this, R.layout.list_item,Words);
        WordAdapter adapter=new WordAdapter(this,Words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.Phrases);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, "Pharases", Toast.LENGTH_SHORT).show();
            Word word = Words.get(position);
            mp = MediaPlayer.create(Phrases.this, word.getSound());
            mp.start();
        } );

    }
}