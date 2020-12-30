package com.example.shopihh.Login;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
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
import com.example.shopihh.Home.HomeActivity;
import com.example.shopihh.R;
import com.example.shopihh.User;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_SignUp, btn_Login, btn_ForgotPswd;
    private EditText ed_Username, ed_Password;
    private DatabaseHelper myDB;
    private Cursor cursor;
    private boolean viewControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_SignUp = findViewById(R.id.btnLogin_SignUp);
        btn_Login = findViewById(R.id.btnLogin_Login);
        btn_ForgotPswd = findViewById(R.id.btnLogin_ForgotPswd);
        ed_Username = findViewById(R.id.edLogin_Username);
        ed_Password = findViewById(R.id.edLogin_Password);

        //inisilaisasai untuk mendapatkan context
        myDB = new DatabaseHelper(this);

        viewControl = true;

        btn_SignUp.setOnClickListener(this);
        btn_Login.setOnClickListener(this);
        btn_ForgotPswd.setOnClickListener(this);

        ed_Password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_UP){
                    if(event.getRawX() >= ed_Password.getRight()){
                        //menyleksi touch gambar dan view password
                        if(viewControl) {
                            ed_Password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.password_icon, 0,
                                    R.drawable.view_active_icon, 0);
                            ed_Password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                            ed_Password.setSelection(ed_Password.length());
                            viewControl=false;
                        }else{
                            ed_Password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.password_icon,
                                    0, R.drawable.view_notactive_icon, 0);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin_SignUp:
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                break;
            case R.id.btnLogin_Login:
                if(ed_Password.length() >= 8) {
                    searchData();
                }else{
                    Toast.makeText(getBaseContext(), "Minimum Panjang Password 8", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnLogin_ForgotPswd:
                startActivity(new Intent(LoginActivity.this, ForgotPaswordActivity.class));
                break;
        }
    }

    private void searchData(){
        //mendapatkan repository mode membaca
        SQLiteDatabase search = myDB.getReadableDatabase();
        String username = ed_Username.getText().toString();
        String password = ed_Password.getText().toString();

        cursor = search.rawQuery("SELECT * FROM "+ loginProperty.NamaTabel+
                " WHERE "+loginProperty.Username+" = '"+username+"' AND "+loginProperty.Password+
                " = '"+password+"'",null);
        cursor.moveToFirst();

        if(cursor.getCount() > 0){
            //jika data di temukan
            Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show();
            Intent HomeIntent = new Intent(LoginActivity.this, HomeActivity.class);
            User user = new User();
            user.setUsername(cursor.getString(0).toString());
            user.setPassword(cursor.getString(1).toString());
            user.setNama(cursor.getString(2).toString());
            user.setJk(cursor.getString(3).toString());
            user.setTel(cursor.getString(4).toString());
            user.setEmail(cursor.getString(5).toString());
            user.setAlamat(cursor.getString(6).toString());

            //kegunaan check untuk control fragment pada saat pertama
            String check = "check";
            HomeIntent.putExtra("user", user);
            HomeIntent.putExtra("check",check);
            startActivity(HomeIntent);
            finish();
        }else{
            //jika data tidak di temukan
            Toast.makeText(this, "gagal", Toast.LENGTH_SHORT).show();
        }
        search.close();
    }

}