package com.example.restaurantsapplication.restaurants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.restaurantsapplication.adapter.CustomAdapter;
import com.example.restaurantsapplication.R;
import com.example.restaurantsapplication.model.Image;
import com.example.restaurantsapplication.model.Item;

import java.util.ArrayList;

public class RestaurantDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    ArrayList<Image> imagesArray;
    private TextView tvTitle;
    private TextView tvSubtitle;
    CustomAdapter customAdapter;
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        tvTitle=findViewById(R.id.list_item_text);
        tvSubtitle=findViewById(R.id.list_item_secondary_text);

        String title="Title";
        String subtitle="Subtitle";
        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            title=extras.getString("title");
            subtitle=extras.getString("subtitle");
        }

        tvTitle.setText(title.toString());
        tvSubtitle.setText(subtitle.toString());

        recyclerView=findViewById(R.id.images_recycler_view);
        imagesArray=new ArrayList<>();
        for(int i=0;i<10;i++){
            Image image=new Image(R.drawable.ic_launcher_background);

            imagesArray.add(image);


            LinearLayoutManager layoutManager=new LinearLayoutManager(
                  RestaurantDetailsActivity.this, LinearLayoutManager.HORIZONTAL,false
            );
            recyclerView.setLayoutManager(layoutManager);

            customAdapter=new CustomAdapter(RestaurantDetailsActivity.this,imagesArray);
            recyclerView.setAdapter(customAdapter);

        }


    }
}