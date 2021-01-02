package com.example.shopihh.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.shopihh.Home.InfoAcount.infoActivity;
import com.example.shopihh.Home.PengaturanAccount.PengaturanAccountActivity;
import com.example.shopihh.R;
import com.example.shopihh.User;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentAccount extends Fragment implements View.OnClickListener {
    private TextView tv_nama, tv_username, tv_jk;
    private Button btn_Info, btn_Setting;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //popback agar fragkment jika pencet kembali langsung keluar dari aplikasi
        getActivity().getSupportFragmentManager().popBackStack();
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv_nama = view.findViewById(R.id.tvAccount_nama);
        tv_username = view.findViewById(R.id.tvAccount_username);
        tv_jk = view.findViewById(R.id.tvAccount_jk);
        btn_Info = view.findViewById(R.id.btnAccount_info);
        btn_Setting = view.findViewById(R.id.btnAccount_setting);

        //mengambil object user memakai intent parcelabel
        User user = getActivity().getIntent().getParcelableExtra("user");
        //set data ke xml
        tv_nama.setText(user.getNama());
        tv_username.setText(user.getUsername());
        tv_jk.setText(user.getJk());

        btn_Info.setOnClickListener(this);
        btn_Setting.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btnAccount_info:
                Intent infoIntent = new Intent(getActivity().getApplication(), infoActivity.class);
                startActivity(infoIntent);
                break;
            case R.id.btnAccount_setting:
                User user = getActivity().getIntent().getParcelableExtra("user");
                //check deiberi nilai agar mendadakan object user ada
                String check = "check";
                Intent settingIntent = new Intent(getActivity().getApplication(), PengaturanAccountActivity.class);
                settingIntent.putExtra("user",user);
                settingIntent.putExtra("check", check);
                startActivity(settingIntent);
                break;
        }

    }
}
