package com.sanjeet.cameraxapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sanjeet.cameraxapp.R;
import com.sanjeet.cameraxapp.model.ImageData;

import java.util.List;

/**
 * Created by SANJEET KUMAR on 23,February,2021, sk698166@gmail.com
 **/

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {

    Context context;
    List<ImageData> imageDataArrayList;

    public ImageAdapter(Context context, List<ImageData> imageDataArrayList) {
        this.context = context;
        this.imageDataArrayList = imageDataArrayList;
    }

    @NonNull
    @Override
    public ImageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_row_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.MyViewHolder holder, int position) {

        ImageData imageData = imageDataArrayList.get(position);
        Glide.with(context).load(imageData.getImageUrl()).into(holder.image);
        holder.name.setText(imageData.getImageName());
        holder.date.setText(imageData.getImageDate());
    }

    @Override
    public int getItemCount() {
        return imageDataArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, date;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageId);
            name = itemView.findViewById(R.id.nameId);
            date = itemView.findViewById(R.id.dateId);
        }
    }
}
