package com.example.shopihh.Home.PengaturanAccount;


import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shopihh.Database.DatabaseHelper;
import com.example.shopihh.Database.loginProperty;
import com.example.shopihh.Home.HomeActivity;
import com.example.shopihh.R;
import com.example.shopihh.User;

public class PengaturanAccountActivity extends AppCompatActivity {
    private EditText edt_Nama, edt_Username,  edt_Telp, edt_Email, edt_Alamat;
    private Button btn_Simpan;
    private Spinner sp_Jk;
    private DatabaseHelper myDB;
    private User userEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan_account);


        edt_Nama = findViewById(R.id.edtPengaturan_Nama);
        edt_Username = findViewById(R.id.edtPengaturan_Username);
        sp_Jk = findViewById(R.id.spPengaturan_Jk);
        edt_Telp = findViewById(R.id.edtPengaturan_Telp);
        edt_Email = findViewById(R.id.edtPengaturan_Email);
        edt_Alamat = findViewById(R.id.edtPengaturan_Alamat);
        btn_Simpan = findViewById(R.id.btnPengaturan_Simpan);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.JK, R.layout.spinner_color_pengaturan
        );
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_pengaturan);
        sp_Jk.setAdapter(adapter);

        //inisilisasi untuk mendapatkan kenteks dari myDB
        myDB = new DatabaseHelper(this);

        //mengambil data dari activity sebelumnya
        User user = getIntent().getParcelableExtra("user");
        //set data
        edt_Nama.setText(user.getNama());
        edt_Username.setText(user.getUsername());

        if(user.getJk().equals("Pria")) {
            sp_Jk.setSelection(0);
        }else{
            sp_Jk.setSelection(1);
        }
        edt_Telp.setText(user.getTel());
        edt_Email.setText(user.getEmail());
        edt_Alamat.setText(user.getAlamat());

        btn_Simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editData();
                //check berguna untuk control fragment
                String check = "";
                Intent BackIntent = new Intent(PengaturanAccountActivity.this, HomeActivity.class);
                BackIntent.putExtra("check", check);
                BackIntent.putExtra("user", userEdit);
                startActivity(BackIntent);
                finish();
            }
        });

        //menyetel username tidak bisa di edit
        edt_Username.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

    }

    private void editData(){

        SQLiteDatabase edit = myDB.getWritableDatabase();
        ContentValues values = new ContentValues();
        userEdit = new User();

        userEdit.setUsername(edt_Username.getText().toString());
        userEdit.setNama(edt_Nama.getText().toString());
        userEdit.setJk(sp_Jk.getSelectedItem().toString());
        userEdit.setTel(edt_Telp.getText().toString());
        userEdit.setEmail(edt_Email.getText().toString());
        userEdit.setAlamat(edt_Alamat.getText().toString());

        values.put(loginProperty.Nama, userEdit.getNama());
        values.put(loginProperty.JK, userEdit.getJk());
        values.put(loginProperty.Telepon, userEdit.getTel());
        values.put(loginProperty.Email, userEdit.getEmail());
        values.put(loginProperty.Alamat, userEdit.getAlamat());

        long check = edit.update(loginProperty.NamaTabel, values, loginProperty.Username+" = '"+userEdit.getUsername()+"'",
                null);
        if(check>0){
            Toast.makeText(this, "Data Berhasil Di Simpan", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Data Gagal Di Simpan", Toast.LENGTH_SHORT).show();
        }
        edit.close();
    }
}


