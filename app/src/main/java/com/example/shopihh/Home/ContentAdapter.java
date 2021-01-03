package com.example.shopihh.Home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shopihh.Home.Content.Content_Activity;
import com.example.shopihh.R;
import com.example.shopihh.User;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentHolder> {
    String title[];
    Context context;
    int images[];
    int slider[];
    User user;

    //construktor agar dapat context paling penting dan data lainya yang berguna
    public ContentAdapter(Context ct, int img[], String title[], int slider[], User user){
        this.context = ct;
        this.images = img;
        this.title = title;
        this.slider = slider;
        this.user = user;
    }

    @NonNull
    @Override
    public ContentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //membuat sub layout baru
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.list_item, parent, false);

        //retrun class holder agar bisa di akses di bindViewHolder
        return new ContentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentHolder holder, final int position) {
        //jika ingin mengakses atau set harus mengunakan holder karena disana ada item dari holder class

        holder.title.setText(title[position]);
        holder.icon.setImageResource(images[position]);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ContentIntent = new Intent(context, Content_Activity.class);
                ContentIntent.putExtra("title", title[position]);
                ContentIntent.putExtra("checkimg", images[position]);
                ContentIntent.putExtra("user", user);
                ContentIntent.putExtra("slider", slider[position]);
                context.startActivity(ContentIntent);
                //finish dari context
                ((Activity) context).finish();
            }
        });
    }

    //fungsi ini berguna untuk menentukan banyaknya item
    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ContentHolder extends RecyclerView.ViewHolder {
        //holder berguna untuk menghubungkan class ke xml
        TextView title;
        ImageView icon;
        ConstraintLayout constraintLayout;
        public ContentHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvList_title);
            icon = itemView.findViewById(R.id.imgList_icon);
            constraintLayout = itemView.findViewById(R.id.contentLayout);
        }
    }
}
