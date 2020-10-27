package com.example.igem2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    Handler myhander=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myhander.postDelayed(new Runnable() {
                                 @Override
                                 public void run() {
                                     Intent intent =new Intent(MainActivity.this,activity_start.class);
                                     startActivity(intent);
                                     finish();
                                 }
                             }, 5000);


    }
}
