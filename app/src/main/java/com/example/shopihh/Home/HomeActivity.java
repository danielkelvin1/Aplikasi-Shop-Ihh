package com.example.shopihh.Home;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.MenuItem;


import com.example.shopihh.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView btm_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btm_nav = findViewById(R.id.bottom_navigation);

        //setting fragment pertama kali yang keluar
        if(!getIntent().getStringExtra("check").isEmpty()) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentHome()).commit();
        }else{
            btm_nav.setSelectedItemId(R.id.btmMenu_Profile);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentAccount()).commit();
        }

        btm_nav.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment =null;

                switch (item.getItemId()){
                    case R.id.btmMenu_Home:
                        selectedFragment = new FragmentHome();
                        break;
                    case R.id.btmMenu_Profile:
                        selectedFragment = new FragmentAccount();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();

                return true;
            }
        });

    }
}