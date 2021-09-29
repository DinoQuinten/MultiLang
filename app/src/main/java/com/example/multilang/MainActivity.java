package com.example.multilang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView color= (TextView) findViewById(R.id.color);
        color.setOnClickListener(v -> {
            Intent Color= new Intent(MainActivity.this,Colors.class);
            startActivity(Color);
        });

    }


    public void numbers_list(View view){
        Intent numbers = new Intent(MainActivity.this, Numbers.class);
        startActivity(numbers);
    }
    public void Family_list(View view){
        Intent family= new Intent(MainActivity.this,Family.class);
        startActivity(family);
    }
//     public void Colors_list(View view){
//        Intent Color= new Intent(MainActivity.this,Colors.class);
//        startActivity(Color);
//    }
     public void Phrases_list(View view){
        Intent Phrases= new Intent(MainActivity.this,Phrases.class);
        startActivity(Phrases);
    }


}