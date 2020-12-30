package com.example.shopihh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.shopihh.Login.LoginActivity;


public class MainActivity extends AppCompatActivity {
    //loading splash selama 3000 = 3 detik
    private final int loading = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       new Handler().postDelayed(new Runnable(){
           @Override
           public void run(){
               Intent HomeActivity = new Intent(MainActivity.this, LoginActivity.class);
               startActivity(HomeActivity);
               finish();
           }
       },loading);
    }
}