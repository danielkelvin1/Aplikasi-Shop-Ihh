package com.example.shopihh.Home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopihh.R;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentHolder> {
    String title[];
    Context context;
    int images[];
    int dataSlider[];

    public ContentAdapter(Context ct, int img[], String title[], int slider[]){
        this.context = ct;
        this.images = img;
        this.title = title;
        this.dataSlider = slider;
    }

    @NonNull
    @Override
    public ContentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.list_item, parent, false);

        return new ContentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentHolder holder, final int position) {
        holder.title.setText(title[position]);
        holder.icon.setImageResource(images[position]);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ContentIntent = new Intent(context, ContentActivity.class);
                ContentIntent.putExtra("title", title[position]);
                ContentIntent.putExtra("slider", dataSlider[position]);
                context.startActivity(ContentIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ContentHolder extends RecyclerView.ViewHolder {
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
