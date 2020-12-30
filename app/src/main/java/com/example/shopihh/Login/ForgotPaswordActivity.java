package com.example.shopihh.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shopihh.Database.DatabaseHelper;
import com.example.shopihh.Database.loginProperty;
import com.example.shopihh.R;
import com.google.android.material.textfield.TextInputLayout;

public class ForgotPaswordActivity extends AppCompatActivity {

    private Button btn_Data;
    private EditText ed_Username, ed_Password;
    private TextInputLayout ti_Password;
    private DatabaseHelper myDB;
    private Cursor cursor;
    boolean viewControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pasword);

        btn_Data = findViewById(R.id.btnForgot_Data);
        ed_Username = findViewById(R.id.edForgot_Username);
        ed_Password = findViewById(R.id.edForgot_Password);
        ti_Password = findViewById(R.id.tiForgot_Pasword);

        myDB = new DatabaseHelper(this);
        viewControl = true;

        btn_Data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_Data.getText().equals("Search Data")) {
                    searchData();
                }else{
                    if(ed_Password.length() >= 8) {
                        saveData();
                    }else{
                        Toast.makeText(ForgotPaswordActivity.this, "Minimum Panjang Password 8",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        ed_Password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    if(event.getRawX() >= ed_Password.getRight()){
                        if(viewControl) {
                            ed_Password.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                                    R.drawable.view_active_icon, 0);
                            ed_Password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                            ed_Password.setSelection(ed_Password.length());
                            viewControl = false;
                        }else{
                            ed_Password.setCompoundDrawablesWithIntrinsicBounds(0,0,
                                    R.drawable.view_notactive_icon,0);
                            ed_Password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            ed_Password.setSelection(ed_Password.length());
                            viewControl = true;
                        }
                    }
                }

                return false;
            }
        });

    }

    private void saveData(){
        //mendapatkan repository mode membaca
        SQLiteDatabase save = myDB.getWritableDatabase();
        String Password  = ed_Password.getText().toString();
        String Username = ed_Username.getText().toString();
        ContentValues values = new ContentValues();
        values.put(loginProperty.Password, Password);
        long check = save.update(loginProperty.NamaTabel, values, loginProperty.Username+" = '"+Username+"'",null);
        if(check>0){
            Toast.makeText(this, "Berhasil Menganti Kata Sandi", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Tidak Berhasil Menganti Kata Sandi", Toast.LENGTH_SHORT).show();
        }
        save.close();
    }

    private void searchData(){
        //mendapatkan repository mode membaca
        SQLiteDatabase search = myDB.getReadableDatabase();
        String Username = ed_Username.getText().toString();
        cursor = search.rawQuery("SELECT * FROM "+loginProperty.NamaTabel+" WHERE "+
                loginProperty.Username+" = '"+Username+"'",null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            ed_Password.setVisibility(View.VISIBLE);
            ti_Password.setVisibility(View.VISIBLE);
            btn_Data.setText("Save Data");
            Toast.makeText(this, "Data Di Temukan", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Data Tidak Di Temukan", Toast.LENGTH_SHORT).show();
        }
        search.close();
    }
}