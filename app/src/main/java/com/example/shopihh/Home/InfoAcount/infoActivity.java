package com.example.shopihh.Home.InfoAcount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopihh.R;

import static java.net.Proxy.Type.HTTP;


public class infoActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_Email, btn_Instragam;
    private TextView tv_Email,tv_Instragam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        btn_Email = findViewById(R.id.btnInfo_Email);
        btn_Instragam = findViewById(R.id.btnInfo_Instragam);
        tv_Email = findViewById(R.id.tvInfo_Email);
        tv_Instragam = findViewById(R.id.tvInfo_Instragam);

        btn_Email.setOnClickListener(this);
        btn_Instragam.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnInfo_Email:
               Intent emailIntent = new Intent(Intent.ACTION_SEND);
               emailIntent.setData(Uri.parse("mailto:"));
               String[] email = {tv_Email.getText().toString()};
               emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
               emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Umpan Balik");
               emailIntent.setType("message/rfc822");
               startActivity(emailIntent);
                break;
            case R.id.btnInfo_Instragam:
                Intent instragamIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_u/" +
                        tv_Instragam.getText().toString()));
                instragamIntent.setPackage("com.instagram.android");
                startActivity(instragamIntent);
                break;
        }
    }

}