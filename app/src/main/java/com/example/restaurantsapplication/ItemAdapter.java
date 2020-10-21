package com.example.restaurantsapplication;

import android.content.Context;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restaurantsapplication.model.Item;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
   private ArrayList<Item> items;

   private Context context;

   public ItemAdapter(Context context, ArrayList<Item> items){
       this.items=items;
       this.context=context;
   }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant,parent,false);
        return new ItemViewHolder(view);
        //cand cream prima oara viewurile
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        //cand trebuie sa se afiseze un item nou se afiseaza asta
        //trebuie sa populam datele
        Item item=items.get(position);
        holder.title.setText(item.getTitle());
        holder.subtitle.setText(item.getSubtitle());
        holder.image.setImageDrawable(ContextCompat.getDrawable(context,item.getIcon()));
    }

    @Override
    public int getItemCount() {
        return items.size();
        //marimea intregii liste
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        private AppCompatImageView image;
        private AppCompatTextView title;
        private AppCompatTextView subtitle;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.list_item_icon);
            title=itemView.findViewById(R.id.list_item_text);
            subtitle=itemView.findViewById(R.id.list_item_secondary_text);

        }
    }
}
