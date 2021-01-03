package com.example.shopihh.Home.Content;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopihh.Home.HomeActivity;
import com.example.shopihh.R;

public class Content_Activity extends AppCompatActivity implements View.OnClickListener {
    private View view;
     private TextView tv_Title, tv_Harga;
    private RelativeLayout relativeLayout;
    private ImageView img_slider;
    private EditText ed_Id;
    private Button btn_pil1, btn_pil2, btn_pil3, btn_pil4, btn_pil5, btn_pil6, btn_pil7, btn_pil8,
                    btn_Beli;
    private int harga, imageSlider, check;
    //untuk mengirimkan di intent seperti nama jual seperti 100 diamond dll
    private String namaTopUp, title;


    //jika di tekan tombol back di hp akan kembali ke home activity
    @Override
    public void onBackPressed() {
        //check berguna mengontrol fragment dan user prioritas
        Intent homeIntent = new Intent(Content_Activity.this, HomeActivity.class);
        homeIntent.putExtra("user", getIntent().getParcelableExtra("user"));
        homeIntent.putExtra("check","check");
        startActivity(homeIntent);
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        //check berguna untuk memilih item inflater
        check = getIntent().getIntExtra("checkimg",0);
        imageSlider = getIntent().getIntExtra("slider", 0);
        title = getIntent().getStringExtra("title");
        int id = getIntent().getIntExtra("id", 0);
        harga = 0;


        //menghubungkan relative layout
        relativeLayout = findViewById(R.id.rlContent_try);
        tv_Title = findViewById(R.id.tvContent_Title);
        tv_Harga = findViewById(R.id.tvContent_Harga);
        img_slider = findViewById(R.id.imgContent_Slider);
        btn_Beli = findViewById(R.id.btnContent_Beli);
        ed_Id = findViewById(R.id.edContent_id);

        //memasukan gambar slider
        img_slider.setImageResource(imageSlider);
        //memasukan text ke title
        tv_Title.setText(title);

        //kontrol pada saat tekan kembali di bayar activity
        if(id==0){
            ed_Id.setText("");
        }else{
            ed_Id.setText(String.valueOf(id));
        }


        btn_Beli.setOnClickListener(this);

        switch(check) {
            case R.drawable.content_call_of_duty:
                //inflate ke layout parent
                view = getLayoutInflater().inflate(R.layout.cod_item, relativeLayout, false);
                //menghubungkan button di xml ke class
                btn_pil1 = view.findViewById(R.id.btnCod_1);
                btn_pil2 = view.findViewById(R.id.btnCod_2);
                btn_pil3 = view.findViewById(R.id.btnCod_3);
                btn_pil4 = view.findViewById(R.id.btnCod_4);
                btn_pil5 = view.findViewById(R.id.btnCod_5);
                btn_pil6 = view.findViewById(R.id.btnCod_6);
                btn_pil7 = view.findViewById(R.id.btnCod_7);
                btn_pil8 = view.findViewById(R.id.btnCod_8);
                // mengaktifkan action jika di klik
                btn_pil1.setOnClickListener(this);
                btn_pil2.setOnClickListener(this);
                btn_pil3.setOnClickListener(this);
                btn_pil4.setOnClickListener(this);
                btn_pil5.setOnClickListener(this);
                btn_pil6.setOnClickListener(this);
                btn_pil7.setOnClickListener(this);
                btn_pil8.setOnClickListener(this);
                break;
            case R.drawable.content_dragon_raja:
                view = getLayoutInflater().inflate(R.layout.dragon_raja_item, relativeLayout, false);
                //menghubungkan button di xml ke class
                btn_pil1 = view.findViewById(R.id.btnDragon_1);
                btn_pil2 = view.findViewById(R.id.btnDragon_2);
                btn_pil3 = view.findViewById(R.id.btnDragon_3);
                btn_pil4 = view.findViewById(R.id.btnDragon_4);
                btn_pil5 = view.findViewById(R.id.btnDragon_5);
                btn_pil6 = view.findViewById(R.id.btnDragon_6);
                btn_pil7 = view.findViewById(R.id.btnDragon_7);
                btn_pil8 = view.findViewById(R.id.btnDragon_8);
                // mengaktifkan action jika di klik
                btn_pil1.setOnClickListener(this);
                btn_pil2.setOnClickListener(this);
                btn_pil3.setOnClickListener(this);
                btn_pil4.setOnClickListener(this);
                btn_pil5.setOnClickListener(this);
                btn_pil6.setOnClickListener(this);
                btn_pil7.setOnClickListener(this);
                btn_pil8.setOnClickListener(this);
                break;
            case R.drawable.content_ff:
                view = getLayoutInflater().inflate(R.layout.free_fire_item, relativeLayout, false);
                //menghubungkan button di xml ke class
                btn_pil1 = view.findViewById(R.id.btnFf_1);
                btn_pil2 = view.findViewById(R.id.btnFf_2);
                btn_pil3 = view.findViewById(R.id.btnFf_3);
                btn_pil4 = view.findViewById(R.id.btnFf_4);
                btn_pil5 = view.findViewById(R.id.btnFf_5);
                btn_pil6 = view.findViewById(R.id.btnFf_6);
                btn_pil7 = view.findViewById(R.id.btnFf_7);
                btn_pil8 = view.findViewById(R.id.btnFf_8);
                // mengaktifkan action jika di klik
                btn_pil1.setOnClickListener(this);
                btn_pil2.setOnClickListener(this);
                btn_pil3.setOnClickListener(this);
                btn_pil4.setOnClickListener(this);
                btn_pil5.setOnClickListener(this);
                btn_pil6.setOnClickListener(this);
                btn_pil7.setOnClickListener(this);
                btn_pil8.setOnClickListener(this);
                break;
            case R.drawable.content_lol:
                view = getLayoutInflater().inflate(R.layout.lol_item, relativeLayout, false);
                //menghubungkan button di xml ke class
                btn_pil1 = view.findViewById(R.id.btnLol_1);
                btn_pil2 = view.findViewById(R.id.btnLol_2);
                btn_pil3 = view.findViewById(R.id.btnLol_3);
                btn_pil4 = view.findViewById(R.id.btnLol_4);
                btn_pil5 = view.findViewById(R.id.btnLol_5);
                btn_pil6 = view.findViewById(R.id.btnLol_6);
                btn_pil7 = view.findViewById(R.id.btnLol_7);
                // mengaktifkan action jika di klik
                btn_pil1.setOnClickListener(this);
                btn_pil2.setOnClickListener(this);
                btn_pil3.setOnClickListener(this);
                btn_pil4.setOnClickListener(this);
                btn_pil5.setOnClickListener(this);
                btn_pil6.setOnClickListener(this);
                btn_pil7.setOnClickListener(this);
                break;
            case R.drawable.content_lords_mobile:
                view = getLayoutInflater().inflate(R.layout.lord_mobile_item, relativeLayout, false);
                //menghubungkan button di xml ke class
                btn_pil1 = view.findViewById(R.id.btnLords_1);
                btn_pil2 = view.findViewById(R.id.btnLords_2);
                btn_pil3 = view.findViewById(R.id.btnLords_3);
                btn_pil4 = view.findViewById(R.id.btnLords_4);
                btn_pil5 = view.findViewById(R.id.btnLords_5);
                btn_pil6 = view.findViewById(R.id.btnLords_6);;
                // mengaktifkan action jika di klik
                btn_pil1.setOnClickListener(this);
                btn_pil2.setOnClickListener(this);
                btn_pil3.setOnClickListener(this);
                btn_pil4.setOnClickListener(this);
                btn_pil5.setOnClickListener(this);
                btn_pil6.setOnClickListener(this);
                break;
            case R.drawable.content_mobile_legends:
                view = getLayoutInflater().inflate(R.layout.mlbb_item, relativeLayout, false);
                //menghubungkan button di xml ke class
                btn_pil1 = view.findViewById(R.id.btnMlbb_1);
                btn_pil2 = view.findViewById(R.id.btnMlbb_2);
                btn_pil3 = view.findViewById(R.id.btnMlbb_3);
                btn_pil4 = view.findViewById(R.id.btnMlbb_4);
                btn_pil5 = view.findViewById(R.id.btnMlbb_5);
                btn_pil6 = view.findViewById(R.id.btnMlbb_6);
                btn_pil7 = view.findViewById(R.id.btnMlbb_7);
                btn_pil8 = view.findViewById(R.id.btnMlbb_8);
                // mengaktifkan action jika di klik
                btn_pil1.setOnClickListener(this);
                btn_pil2.setOnClickListener(this);
                btn_pil3.setOnClickListener(this);
                btn_pil4.setOnClickListener(this);
                btn_pil5.setOnClickListener(this);
                btn_pil6.setOnClickListener(this);
                btn_pil7.setOnClickListener(this);
                btn_pil8.setOnClickListener(this);
                break;
            case R.drawable.content_pubg:
                view = getLayoutInflater().inflate(R.layout.pubg_item, relativeLayout, false);
                //menghubungkan button di xml ke class
                btn_pil1 = view.findViewById(R.id.btnPubg_1);
                btn_pil2 = view.findViewById(R.id.btnPubg_2);
                btn_pil3 = view.findViewById(R.id.btnPubg_3);
                btn_pil4 = view.findViewById(R.id.btnPubg_4);
                btn_pil5 = view.findViewById(R.id.btnPubg_5);
                btn_pil6 = view.findViewById(R.id.btnPubg_6);
                btn_pil7 = view.findViewById(R.id.btnPubg_7);
                // mengaktifkan action jika di klik
                btn_pil1.setOnClickListener(this);
                btn_pil2.setOnClickListener(this);
                btn_pil3.setOnClickListener(this);
                btn_pil4.setOnClickListener(this);
                btn_pil5.setOnClickListener(this);
                btn_pil6.setOnClickListener(this);
                btn_pil7.setOnClickListener(this);
                break;
            case R.drawable.content_aov:
                view = getLayoutInflater().inflate(R.layout.aov_item, relativeLayout, false);
                //menghubungkan button di xml ke class
                btn_pil1 = view.findViewById(R.id.btnAov_1);
                btn_pil2 = view.findViewById(R.id.btnAov_2);
                btn_pil3 = view.findViewById(R.id.btnAov_3);
                btn_pil4 = view.findViewById(R.id.btnAov_4);
                btn_pil5 = view.findViewById(R.id.btnAov_5);
                btn_pil6 = view.findViewById(R.id.btnAov_6);
                btn_pil7 = view.findViewById(R.id.btnAov_7);
                btn_pil8 = view.findViewById(R.id.btnAov_8);
                // mengaktifkan action jika di klik
                btn_pil1.setOnClickListener(this);
                btn_pil2.setOnClickListener(this);
                btn_pil3.setOnClickListener(this);
                btn_pil4.setOnClickListener(this);
                btn_pil5.setOnClickListener(this);
                btn_pil6.setOnClickListener(this);
                btn_pil7.setOnClickListener(this);
                btn_pil8.setOnClickListener(this);
                break;
        }

        //menampilkan sub layout
        relativeLayout.addView(view );

    }

    //fungsi checklist untuk menceklis pilihan
    //variable cek didlam fungsi checklist berguna untuk menandakan banyaknya tombil yang tampil
    private void checklistBtn1(int cek){
        btn_pil1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24,0);
        btn_pil2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil4.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil5.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil6.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        if(cek == 7) {
            btn_pil7.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        if(cek > 7){
            btn_pil7.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            btn_pil8.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        }
    }

    private void checklistBtn2(int cek){
        btn_pil1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24,0);
        btn_pil3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil4.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil5.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil6.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        if(cek == 7) {
            btn_pil7.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        if(cek > 7){
            btn_pil7.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            btn_pil8.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        }
    }

    private void checklistBtn3(int cek){
        btn_pil1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil3.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24,0);
        btn_pil4.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil5.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil6.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        if(cek == 7) {
            btn_pil7.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        if(cek > 7){
            btn_pil7.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            btn_pil8.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        }
    }

    private void checklistBtn4(int cek){
        btn_pil1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil4.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24,0);
        btn_pil5.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil6.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        if(cek == 7) {
            btn_pil7.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        if(cek > 7){
            btn_pil7.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            btn_pil8.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        }
    }

    private void checklistBtn5(int cek){
        btn_pil1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil4.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil5.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24,0);
        btn_pil6.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        if(cek == 7) {
            btn_pil7.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        if(cek > 7){
            btn_pil7.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            btn_pil8.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        }
    }

    private void checklistBtn6(int cek){
        btn_pil1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil4.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil5.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil6.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24,0);
        if(cek == 7) {
            btn_pil7.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        if(cek > 7){
            btn_pil7.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            btn_pil8.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        }
    }

    private void checklistBtn7(int cek){
        btn_pil1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil4.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil5.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil6.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        if(cek == 7) {
            btn_pil7.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24,0);
        }
        if(cek > 7){
            btn_pil7.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24,0);
            btn_pil8.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        }
    }

    private void checklistBtn8(int cek){
        btn_pil1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil4.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil5.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        btn_pil6.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        if(cek == 7) {
            btn_pil7.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        if(cek > 7){
            btn_pil7.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            btn_pil8.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24,0);
        }

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnCod_1:
                //harga cod 31 cp
                harga = 4000;
                namaTopUp = btn_pil1.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn1(8);
                break;
            case R.id.btnCod_2:
                //harga cod 62 cp
                harga = 8000;
                tv_Harga.setText(String.format("Rp %,d",harga));
                namaTopUp = btn_pil2.getText().toString();
                checklistBtn2(8);
                break;
            case R.id.btnCod_3:
                //harga cod 127 cp
                harga = 19000;
                tv_Harga.setText(String.format("Rp %,d",harga));
                namaTopUp = btn_pil3.getText().toString();
                checklistBtn3(8);
                break;
            case R.id.btnCod_4:
                //harga cod 317 cp
                harga = 40000;
                tv_Harga.setText(String.format("Rp %,d",harga));
                namaTopUp = btn_pil4.getText().toString();
                checklistBtn4(8);
                break;
            case R.id.btnCod_5:
                //harga cod 634 cp
                harga = 90000;
                tv_Harga.setText(String.format("Rp %,d",harga));
                namaTopUp = btn_pil5.getText().toString();
                checklistBtn5(8);
                break;
            case R.id.btnCod_6:
                //harga cod 1373 cp
                harga = 190000;
                tv_Harga.setText(String.format("Rp %,d",harga));
                namaTopUp = btn_pil6.getText().toString();
                checklistBtn6(8);
                break;
            case R.id.btnCod_7:
                //harga cod 2059 cp
                harga = 290000;
                tv_Harga.setText(String.format("Rp %,d",harga));
                namaTopUp = btn_pil7.getText().toString();
                checklistBtn7(8);
                break;
            case R.id.btnCod_8:
                //harga cod 3564 cp
                harga = 480000;
                tv_Harga.setText(String.format("Rp %,d",harga));
                namaTopUp = btn_pil8.getText().toString();
                checklistBtn8(8);
                break;
            case R.id.btnDragon_1:
                //harga dragon raja 67 cupons
                harga = 14000;
                namaTopUp = btn_pil1.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn1(8);
                break;
            case R.id.btnDragon_2:
                //harga dragon raja 337 cupons
                harga = 70000;
                namaTopUp = btn_pil2.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn2(8);
                break;
            case R.id.btnDragon_3:
                //harga dragon raja 1097 cupons
                harga = 210000;
                namaTopUp = btn_pil3.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn3(8);
                break;
            case R.id.btnDragon_4:
                //harga dragon raja 2296 cupons
                harga = 425000;
                namaTopUp = btn_pil4.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn4(8);
                break;
            case R.id.btnDragon_5:
                //harga dragon raja 2808 cupons
                harga = 500000;
                namaTopUp = btn_pil5.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn5(8);
                break;
            case R.id.btnDragon_6:
                //harga dragon raja 5086 cupons
                harga = 900000;
                namaTopUp = btn_pil6.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn6(8);
                break;
            case R.id.btnDragon_7:
                //harga dragon raja investment fund
                harga = 210000;
                namaTopUp = btn_pil7.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn7(8);
                break;
            case R.id.btnDragon_8:
                //harga dragon raja investment fundII
                harga = 299000;
                namaTopUp = btn_pil8.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn8(8);
                break;
            case R.id.btnFf_1:
                //harga ff 5 diamonds
                harga = 1000;
                namaTopUp = btn_pil1.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn1(8);
                break;
            case R.id.btnFf_2:
                //harga ff 12 diamonds
                harga = 2000;
                namaTopUp = btn_pil2.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn2(8);
                break;
            case R.id.btnFf_3:
                //harga ff 50 diamonds
                harga = 8000;
                namaTopUp = btn_pil3.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn3(8);
                break;
            case R.id.btnFf_4:
                //harga ff 70 diamonds
                harga = 10000;
                namaTopUp = btn_pil4.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn4(8);
                break;
            case R.id.btnFf_5:
                //harga ff 140 diamonds
                harga = 20000;
                namaTopUp = btn_pil5.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn5(8);
                break;
            case R.id.btnFf_6:
                //harga ff 355 diamonds
                harga = 50000;
                namaTopUp = btn_pil6.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn6(8);
                break;
            case R.id.btnFf_7:
                //harga ff 720 diamonds
                harga = 100000;
                namaTopUp = btn_pil7.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn7(8);
                break;
            case R.id.btnFf_8:
                //harga ff 1450 diamonds
                harga = 200000;
                namaTopUp = btn_pil8.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn8(8);
                break;
            case R.id.btnLol_1:
                //harga LOL 125 wild cores
                harga = 15000;
                namaTopUp = btn_pil1.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn1(7);
                break;
            case R.id.btnLol_2:
                //harga LOL 420 wild cores
                harga = 49000;
                namaTopUp = btn_pil2.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn2(7);
                break;
            case R.id.btnLol_3:
                //harga LOL 700 wild cores
                harga = 75000;
                namaTopUp = btn_pil3.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn3(7);
                break;
            case R.id.btnLol_4:
                //harga LOL 1375 wild cores
                harga = 145000;
                namaTopUp = btn_pil4.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn4(7);
                break;
            case R.id.btnLol_5:
                //harga LOL 2400 wild cores
                harga = 240000;
                namaTopUp = btn_pil5.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn5(7);
                break;
            case R.id.btnLol_6:
                //harga LOL 4000 wild cores
                harga = 395000;
                namaTopUp = btn_pil6.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn6(7);
                break;
            case R.id.btnLol_7:
                //harga LOL 8150 wild cores
                harga = 790000;
                namaTopUp = btn_pil7.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn7(7);
                break;
            case R.id.btnLords_1:
                //harga lords mobile 34 diamonds
                harga = 4000;
                namaTopUp = btn_pil1.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn1(6);
                break;
            case R.id.btnLords_2:
                //harga lords mobile 67 diamonds
                harga = 9000;
                namaTopUp = btn_pil2.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn2(6);
                break;
            case R.id.btnLords_3:
                //harga lords mobile 134 diamonds
                harga = 18000;
                namaTopUp = btn_pil3.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn3(6);
                break;
            case R.id.btnLords_4:
                //harga lords mobile 335 diamonds
                harga = 49000;
                namaTopUp = btn_pil4.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn4(6);
                break;
            case R.id.btnLords_5:
                //harga lords mobile 670 diamonds
                harga = 90000;
                namaTopUp = btn_pil5.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn5(6);
                break;
            case R.id.btnLords_6:
                //harga lords mobile 1676 diamonds
                harga = 240000;
                namaTopUp = btn_pil6.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn6(6);
                break;
            case R.id.btnMlbb_1:
                //harga mobile legends 59 diamonds
                harga = 14000;
                namaTopUp = btn_pil1.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn1(8);
                break;
            case R.id.btnMlbb_2:
                //harga mobile legends 85 diamonds
                harga = 20000;
                namaTopUp = btn_pil2.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn2(8);
                break;
            case R.id.btnMlbb_3:
                //harga mobile legends 170 diamonds
                harga = 43000;
                namaTopUp = btn_pil3.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn3(8);
                break;
            case R.id.btnMlbb_4:
                //harga mobile legends 240 diamonds
                harga = 60000;
                namaTopUp = btn_pil4.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn4(8);
                break;
            case R.id.btnMlbb_5:
                //harga mobile legends 296 diamonds
                harga = 75000;
                namaTopUp = btn_pil5.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn5(8);
                break;
            case R.id.btnMlbb_6:
                //harga mobile legends 408 diamonds
                harga = 102000;
                namaTopUp = btn_pil6.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn6(8);
                break;
            case R.id.btnMlbb_7:
                //harga mobile legends 568 diamonds
                harga = 141000;
                namaTopUp = btn_pil7.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn7(8);
                break;
            case R.id.btnMlbb_8:
                //harga mobile legends 875 diamonds
                harga = 215000;
                namaTopUp = btn_pil8.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn8(8);
                break;
            case R.id.btnPubg_1:
                //harga pubg mobile 263 uc
                harga = 44000;
                namaTopUp = btn_pil1.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn1(7);
                break;
            case R.id.btnPubg_2:
                //harga pubg mobile 525 uc
                harga = 89000;
                namaTopUp = btn_pil2.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn2(7);
                break;
            case R.id.btnPubg_3:
                //harga pubg mobile 788 uc
                harga = 129000;
                namaTopUp = btn_pil3.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn3(7);
                break;
            case R.id.btnPubg_4:
                //harga pubg mobile 1050 uc
                harga = 179000;
                namaTopUp = btn_pil4.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn4(7);
                break;
            case R.id.btnPubg_5:
                //harga pubg mobile 1375 uc
                harga = 219000;
                namaTopUp = btn_pil5.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn5(7);
                break;
            case R.id.btnPubg_6:
                //harga pubg mobile 1638 uc
                harga = 259000;
                namaTopUp = btn_pil6.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn6(7);
                break;
            case R.id.btnPubg_7:
                //harga pubg mobile 1900 uc
                harga = 309000;
                namaTopUp = btn_pil7.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn7(7);
                break;
            case R.id.btnAov_1:
                //harga aov 7 vouchers
                harga = 2000;
                namaTopUp = btn_pil1.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn1(8);
                break;
            case R.id.btnAov_2:
                //harga aov 18 vouchers
                harga = 5000;
                namaTopUp = btn_pil2.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn2(8);
                break;
            case R.id.btnAov_3:
                //harga aov 40 vouchers
                harga = 10000;
                namaTopUp = btn_pil3.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn3(8);
                break;
            case R.id.btnAov_4:
                //harga aov 90 vouchers
                harga = 40000;
                namaTopUp = btn_pil4.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn4(8);
                break;
            case R.id.btnAov_5:
                //harga aov 230 vouchers
                harga = 50000;
                namaTopUp = btn_pil5.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn5(8);
                break;
            case R.id.btnAov_6:
                //harga aov 470 vouchers
                harga = 100000;
                namaTopUp = btn_pil6.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn6(8);
                break;
            case R.id.btnAov_7:
                //harga aov 950 vouchers
                harga = 200000;
                namaTopUp = btn_pil7.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn7(8);
                break;
            case R.id.btnAov_8:
                //harga aov 1430 vouchers
                harga = 300000;
                namaTopUp = btn_pil8.getText().toString();
                tv_Harga.setText(String.format("Rp %,d",harga));
                checklistBtn8(8);
                break;
            case R.id.btnContent_Beli:
                //membuat program hanya mengeluarkan pesan saja jika id tidak ada
                if(ed_Id.getText().toString().equals("")){
                    Toast.makeText(this, "Masukan Id Dulu", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent BayarIntent = new Intent(Content_Activity.this, BayarActivity.class);
                //user hanya untuk prioritas untuk intent
                BayarIntent.putExtra("slider", imageSlider);
                BayarIntent.putExtra("checkimg", check);
                BayarIntent.putExtra("title", title);
                BayarIntent.putExtra("id", Integer.parseInt(ed_Id.getText().toString()));
                BayarIntent.putExtra("nama_TopUp", namaTopUp);
                BayarIntent.putExtra("harga", harga);
                BayarIntent.putExtra("user", getIntent().getParcelableExtra("user"));
                startActivity(BayarIntent);
                finish();
                break;
        }
    }
}