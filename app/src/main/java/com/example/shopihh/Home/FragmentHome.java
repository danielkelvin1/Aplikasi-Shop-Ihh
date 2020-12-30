package com.example.shopihh.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shopihh.R;
import com.example.shopihh.User;
import com.synnapps.carouselview.CarouselView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class FragmentHome extends Fragment {
    int imageContent[] = {R.drawable.content_call_of_duty, R.drawable.content_dragon_raja,
            R.drawable.content_ff, R.drawable.content_lol, R.drawable.content_lords_mobile,
            R.drawable.content_mobile_legends, R.drawable.content_pubg, R.drawable.content_aov};

    String[] title={"Call Of Duty", "Dragon Raja", "Free Fire", "LOL", "Lords Mobile",
                "MLBB", "PUBG", "AOV"};

    private RecyclerView recyclerView;
    private TextView tv_Profile;

    //data untuk slider
    private int data[]={R.drawable.content_slide1, R.drawable.content_slide2, R.drawable.content_slide3,
        R.drawable.content_slide4, R.drawable.content_slide5, R.drawable.content_slide6, R.drawable.content_slide7,
        R.drawable.content_slide8};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //popback agar fragkment jika pencet kembali langsung keluar dari aplikasi
        getActivity().getSupportFragmentManager().popBackStack();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        User user = getActivity().getIntent().getParcelableExtra("user");
        tv_Profile = view.findViewById(R.id.tvHome_Profile);
        String buffer = tv_Profile.getText().toString();
        tv_Profile.setText(buffer+" "+user.getNama());



        recyclerView = view.findViewById(R.id.rvHome_Content);
        ContentAdapter contentAdapter = new ContentAdapter(getContext(), imageContent, title, data);
        recyclerView.setAdapter(contentAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

    }


}
