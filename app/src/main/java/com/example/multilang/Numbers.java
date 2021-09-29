package com.example.multilang;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {
    private MediaPlayer mp;
    private AudioManager audioManager;

    private final Handler handler = new Handler();
    private final AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT
                    || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // Permanent loss of audio focus
                mp.pause();
                mp.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // Pause playback
                mp.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // Your app has been granted audio focus again
                // Raise volume to normal, restart playback if necessary
                releaseMediaPlayer();
            }
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> Numbers = new ArrayList<>();

        Numbers.add(new Word("one", "1", R.drawable.number_one, R.raw.number_one));
        Numbers.add(new Word("Two", "2", R.drawable.number_two, R.raw.number_two));
        Numbers.add(new Word("Three", "3", R.drawable.number_three, R.raw.number_three));
        Numbers.add(new Word("Four", "4", R.drawable.number_four, R.raw.number_four));
        Numbers.add(new Word("Five", "5", R.drawable.number_five, R.raw.number_five));
        Numbers.add(new Word("Six", "6", R.drawable.number_six, R.raw.number_six));
        Numbers.add(new Word("Seven", "7", R.drawable.number_seven, R.raw.number_seven));
        Numbers.add(new Word("Eight", "8", R.drawable.number_eight, R.raw.number_eight));
        Numbers.add(new Word("Nine", "9", R.drawable.number_nine, R.raw.number_nine));
        Numbers.add(new Word("Ten", "10", R.drawable.number_ten, R.raw.number_ten));


//        ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<>(this, R.layout.list_item,Numbers);
        WordAdapter adapter = new WordAdapter(this, Numbers, R.color.category_numbers);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
//            Toast.makeText(Numbers.this, "ONE", Toast.LENGTH_SHORT).show();
            releaseMediaPlayer();
            Word word_1 = Numbers.get(position);

            AudioManager.OnAudioFocusChangeListener afChangeListener = null;
            int result = audioManager.requestAudioFocus(afChangeListener,
                    // Use the music stream.
                    AudioManager.STREAM_MUSIC,
                    // Request permanent focus.
                    AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                // Start playback

                mp = MediaPlayer.create(Numbers.this, word_1.getSound());
                mp.start();
                mp.setOnCompletionListener(mp1 -> releaseMediaPlayer());//tells to wait till sound is completed playing
            }


        });


//        for (int i=0;i<Numbers.size();i++){
//            TextView NumberList=new TextView(this);
//            NumberList.setTextSize(32);
//            NumberList.setText(Numbers.get(i));
//            itemsAdapter.(NumberList);
//        }
//        Numbers_textView.addView(NumberList);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mp != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mp.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mp = null;

            audioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
        Toast.makeText(this, "Resource Freed", Toast.LENGTH_SHORT).show();

    }


}