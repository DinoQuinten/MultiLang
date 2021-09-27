package com.example.multilang;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Family extends AppCompatActivity {
    private MediaPlayer mp;
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        final  ArrayList<Word> Words= new ArrayList<>();

        Words.add(new Word("father","әpә",R.drawable.family_father,R.raw.family_father));
        Words.add(new Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        Words.add(new Word("son","angsi",R.drawable.family_son,R.raw.family_son));
        Words.add(new Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        Words.add(new Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        Words.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        Words.add(new Word("younger sister","teṭe",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        Words.add(new Word("Older Sister" ,"kolliti",R.drawable.family_older_sister,R.raw.family_older_sister));
        Words.add(new Word("grandmother" ,"ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        Words.add(new Word("grandfather" ,"paapa",R.drawable.family_grandfather,R.raw.family_grandfather));




//        ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<>(this, R.layout.list_item,Words);
        WordAdapter adapter=new WordAdapter(this,Words,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.Family);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Family.this, "ONE", Toast.LENGTH_SHORT).show();
                Word word=Words.get(position);
                mp= MediaPlayer.create(Family.this,word.getSound());
                mp.start();
            }
        });
    }

}