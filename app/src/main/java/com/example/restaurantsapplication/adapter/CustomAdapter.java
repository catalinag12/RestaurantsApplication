package com.example.restaurantsapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.restaurantsapplication.R;
import com.example.restaurantsapplication.model.Image;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    ArrayList<Image> imageArrayList;
    Context context;

    public CustomAdapter(Context context, ArrayList<Image> images){
        this.context=context;
        this.imageArrayList=images;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item,parent,false);
        return new CustomAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {

        holder.imageView.setImageResource(imageArrayList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return imageArrayList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_view);

        }
    }
}
