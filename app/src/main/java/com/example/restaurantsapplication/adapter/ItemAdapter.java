package com.example.restaurantsapplication.adapter;

import android.content.Context;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.restaurantsapplication.R;
import com.example.restaurantsapplication.model.Item;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
   private List<Item> itemList;

   private Context context;
   private ItemClickListener listener;

   public ItemAdapter(Context context, ArrayList<Item> items, ItemClickListener listener){
       this.itemList=items;
       this.context=context;
       this.listener=listener;
   }


   public void setData(List<Item> itemList){
       this.itemList=itemList;
       notifyDataSetChanged();
   }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        Item item=itemList.get(position);
        String imagePath=item.getIcon();
        String name=item.getName();
        String description=item.getDescription();

        holder.title.setText(item.getName());
        holder.subtitle.setText(item.getDescription());

        Glide.with(holder.itemView.getContext()).load(item.getIcon()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private AppCompatImageView image;
        private AppCompatTextView title;
        private AppCompatTextView subtitle;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.list_item_icon);
            title=itemView.findViewById(R.id.list_item_text);
            subtitle=itemView.findViewById(R.id.list_item_secondary_text);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View itemView) {
            listener.onClick(itemView,getAdapterPosition());

        }
    }

    public interface  ItemClickListener{
       void onClick(View v, int position);
    }
}
