package com.example.shopihh.Home.Content;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.shopihh.R;

public class Content_Activity extends AppCompatActivity {
    private View view;
    private RelativeLayout relativeLayout;
    private ImageView img_slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        //menghubungkan relative layout
        relativeLayout = findViewById(R.id.rlContent_try);
        int check = getIntent().getIntExtra("check",0);
        int imageSlider = getIntent().getIntExtra("slider", 0);

        img_slider = findViewById(R.id.imgContent_Slider);
        img_slider.setImageResource(imageSlider);

        switch(check) {
            case R.drawable.content_call_of_duty:
                view = getLayoutInflater().inflate(R.layout.cod_item, relativeLayout, false);
                break;
            case R.drawable.content_dragon_raja:
                view = getLayoutInflater().inflate(R.layout.dragon_raja_item, relativeLayout, false);
                break;
            case R.drawable.content_ff:
                view = getLayoutInflater().inflate(R.layout.free_fire_item, relativeLayout, false);
                break;
            case R.drawable.content_lol:
                view = getLayoutInflater().inflate(R.layout.lol_item, relativeLayout, false);
                break;
            case R.drawable.content_lords_mobile:
                view = getLayoutInflater().inflate(R.layout.lord_mobile_item, relativeLayout, false);
                break;
            case R.drawable.content_mobile_legends:
                view = getLayoutInflater().inflate(R.layout.mlbb_item, relativeLayout, false);
                break;
            case R.drawable.content_pubg:
                view = getLayoutInflater().inflate(R.layout.pubg_item, relativeLayout, false);
                break;
            case R.drawable.content_aov:
                view = getLayoutInflater().inflate(R.layout.aov_item, relativeLayout, false);
                break;
        }

        //membuat layaout tampil xml content
        relativeLayout.addView(view);


    }

}