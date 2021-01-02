package com.example.shopihh.Home.Content;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopihh.Home.HomeActivity;
import com.example.shopihh.R;

public class BayarActivity extends AppCompatActivity {
    private TextView tv_Harga, tv_Id, tv_Topup, tv_Message;
    private EditText ed_Bayar;
    private Button btn_Bayar;
    private ImageView img_slider;
    private int harga, slider;
    private String id;

    //jika ditekan back tombol di hp maka akan kembali ke content activity
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent contentIntent = new Intent(BayarActivity.this, Content_Activity.class);
            contentIntent.putExtra("checkimg", getIntent().getIntExtra("checkimg", 0));
            contentIntent.putExtra("slider", slider);
            contentIntent.putExtra("user", getIntent().getParcelableExtra("user"));
            contentIntent.putExtra("check", "check");
            contentIntent.putExtra("title", getIntent().getStringExtra("title"));
            contentIntent.putExtra("id", getIntent().getIntExtra("id",0));
            startActivity(contentIntent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar);

        //menghubungkan textview, edittext, button dari xml ke class
        tv_Harga = findViewById(R.id.tvBayar_Harga);
        tv_Id = findViewById(R.id.tvBayar_Id);
        tv_Topup = findViewById(R.id.tvBayar_TopUp);
        tv_Message = findViewById(R.id.tvBayar_message);
        ed_Bayar = findViewById(R.id.edBayar_Bayar);
        btn_Bayar = findViewById(R.id.btnBayar_Bayar);
        img_slider = findViewById(R.id.imgBayar_Slider);

        id = String.valueOf(getIntent().getIntExtra("id",0));
        String namaJual = getIntent().getStringExtra("nama_TopUp");
        harga = getIntent().getIntExtra("harga", 0);
        slider = getIntent().getIntExtra("slider",0);
        //mengambil string Rp
        String buffer = tv_Harga.getText().toString();

        //set text view
        tv_Id.setText("id: "+id);
        tv_Topup.setText("Top Up: "+namaJual);
        tv_Harga.setText("harga: "+buffer+String.format("%,d",harga));
        img_slider.setImageResource(slider);


        //jika di klik akan dihitung pembayaran
        btn_Bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int bayar = Integer.parseInt(ed_Bayar.getText().toString());
                bayar -=harga;

                //jika lebih dari sama dengan 0 maka akan ke menu utama dan menampilkan pesan top
                //up berhasil
                if(bayar>=0){
                    tv_Message.setVisibility(View.VISIBLE);
                    Toast.makeText(BayarActivity.this, "Uang anda kembali Rp "+
                            String.format("%,d",bayar), Toast.LENGTH_SHORT).show();
                    //di handler ada 3000 = 3 detik akan berpindah
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(BayarActivity.this, "Top Up Berhasil", Toast.LENGTH_SHORT).show();
                            Intent HomeIntent = new Intent(BayarActivity.this, HomeActivity.class);
                            //check dan user hanya prioritas saat perpindahan intent
                            HomeIntent.putExtra("check", "check");
                            HomeIntent.putExtra("user", getIntent().getParcelableExtra("user"));
                            startActivity(HomeIntent);
                            finish();
                            //di delay 3000 = 3 detik
                        }
                    },3000);
                }else{
                    Toast.makeText(BayarActivity.this, "Pembayaran Kurang "+String.format(
                            "Rp %,d",bayar), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}