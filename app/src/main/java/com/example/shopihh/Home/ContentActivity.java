package com.example.shopihh.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.shopihh.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class ContentActivity extends AppCompatActivity {

    int data[] = {R.drawable.content_aov, R.drawable.content_pubg, R.drawable.content_mobile_legends};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
    }

}