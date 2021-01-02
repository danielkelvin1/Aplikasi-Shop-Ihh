package com.example.shopihh.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.shopihh.Database.DatabaseHelper;
import com.example.shopihh.Database.loginProperty;
import com.example.shopihh.R;

public class SignUpActivity extends AppCompatActivity {

    private EditText ed_Username, ed_Password, ed_Nama, ed_Telp, ed_Email, ed_Alamat;
    private Button btn_SignUp;
    private RadioButton rbPria, rbPerempuan;
    private DatabaseHelper myDB;
    //untuk mengubah view
    private boolean viewControl;

    private String setUsername, setPassword, setNama, setJK, setTelp, setEmail, setAlamat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //menghubungkan Edit Text dan Button activity ke class
        ed_Username = findViewById(R.id.edSignUp_Username);
        ed_Password = findViewById(R.id.edSignUp_Password);
        ed_Nama = findViewById(R.id.edSignUp_Nama);
        rbPria = findViewById(R.id.rbSignUp_Pria);
        rbPerempuan = findViewById(R.id.rbSignUp_Perempuan);
        ed_Telp = findViewById(R.id.edSignUp_NoTelp);
        ed_Email = findViewById(R.id.edSignUp_Email);
        ed_Alamat = findViewById(R.id.edSignUp_Alamat);
        btn_SignUp = findViewById(R.id.btnSignUp_SignUp);
        rbPria = findViewById(R.id.rbSignUp_Pria);
        rbPerempuan = findViewById(R.id.rbSignUp_Perempuan);

         viewControl= true;

        //inisialisasai untuk mendapatkan konteks dari my db
        myDB = new DatabaseHelper(this);

        //jika gambar view di tekan akan menganti warnanya menajdi gelap atau abu-abu
        ed_Password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //untuk mengambil nilai touch kanan
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

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


        btn_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData();
                if(setPassword.length()>=8) {
                    String text = saveData();
                    Toast.makeText(getBaseContext(), text, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getBaseContext(), "Minimum Panjang Password 8", Toast.LENGTH_SHORT).show();
                };

            }
        });


    }

    private String saveData(){
        //mendapatkan repository dengan mode menulis
        SQLiteDatabase create = myDB.getWritableDatabase();
        //membuat Map Baru , Yang berisi Nama Dan Kolom dan data yang ingin dimasukan
        ContentValues values = new ContentValues();
        values.put(loginProperty.Username, setUsername);
        values.put(loginProperty.Password, setPassword);
        values.put(loginProperty.Nama, setNama);
        values.put(loginProperty.JK, setJK);
        values.put(loginProperty.Telepon, setTelp);
        values.put(loginProperty.Email, setEmail);
        values.put(loginProperty.Alamat, setAlamat);

        //menambahkan data di database
        long result = create.insert(loginProperty.NamaTabel, null, values);
        create.close();
        if(result == -1){
            return "Data Gagal Di Tambahkan Atau Username Sudah Di Gunakan";
        }else{
            create.close();
            return "Data Berhasil Di Simpan";
        }
    }

    //fungsi ini digunakan untuk set data dari xml
    private void setData(){
     setUsername = ed_Username.getText().toString();
     setPassword = ed_Password.getText().toString();
     setNama = ed_Nama.getText().toString();

     if(rbPerempuan.isChecked()){
         setJK = rbPerempuan.getText().toString();
     }else if(rbPria.isChecked()){
         setJK = rbPria.getText().toString();
     }

     setTelp = ed_Telp.getText().toString();
     setEmail = ed_Email.getText().toString();
     setAlamat = ed_Alamat.getText().toString();
    }

}