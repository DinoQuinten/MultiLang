package com.example.multilang;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {
    private MediaPlayer mp;
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        final ArrayList <Word> Numbers= new ArrayList<>();

        Numbers.add(new Word("one","1",R.drawable.number_one,R.raw.number_one));
        Numbers.add(new Word("Two","2",R.drawable.number_two,R.raw.number_two));
        Numbers.add(new Word("Three","3",R.drawable.number_three,R.raw.number_three));
        Numbers.add(new Word("Four","4",R.drawable.number_four,R.raw.number_four));
        Numbers.add(new Word("Five","5",R.drawable.number_five,R.raw.number_five));
        Numbers.add(new Word("Six","6",R.drawable.number_six,R.raw.number_six));
        Numbers.add(new Word("Seven","7",R.drawable.number_seven,R.raw.number_seven));
        Numbers.add(new Word("Eight","8",R.drawable.number_eight,R.raw.number_eight));
        Numbers.add(new Word("Nine","9",R.drawable.number_nine,R.raw.number_nine));
        Numbers.add(new Word("Ten","10",R.drawable.number_ten,R.raw.number_ten));


//        ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<>(this, R.layout.list_item,Numbers);
        WordAdapter adapter=new WordAdapter(this,Numbers,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(Numbers.this, "ONE", Toast.LENGTH_SHORT).show();
            Word word_1=Numbers.get(position);
            mp=MediaPlayer.create(Numbers.this,word_1.getSound());
            mp.start();
        });


//        for (int i=0;i<Numbers.size();i++){
//            TextView NumberList=new TextView(this);
//            NumberList.setTextSize(32);
//            NumberList.setText(Numbers.get(i));
//            itemsAdapter.(NumberList);
//        }
//        Numbers_textView.addView(NumberList);

    }


}