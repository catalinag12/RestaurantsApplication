package com.example.restaurantsapplication.restaurants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.restaurantsapplication.adapter.CustomAdapter;
import com.example.restaurantsapplication.R;
import com.example.restaurantsapplication.model.Image;
import com.example.restaurantsapplication.model.Item;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private RecyclerView recyclerView;
    List<Image> imagesArray;
    private TextView tvTitle;
    private TextView tvSubtitle;
    CustomAdapter customAdapter;
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        tvTitle = findViewById(R.id.list_item_text);
        tvSubtitle = findViewById(R.id.list_item_secondary_text);
        mapView=findViewById(R.id.map);

        String title = "Title";
        String subtitle = "Subtitle";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title = extras.getString("title");
            subtitle = extras.getString("subtitle");
        }

        tvTitle.setText(title.toString());
        tvSubtitle.setText(subtitle.toString());

        recyclerView = findViewById(R.id.images_recycler_view);
        imagesArray = new ArrayList<>();


        Intent i=getIntent();
        imagesArray= (List<Image>) i.getSerializableExtra("photos");

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                RestaurantDetailsActivity.this, LinearLayoutManager.HORIZONTAL, false
        );
        recyclerView.setLayoutManager(layoutManager);

        customAdapter = new CustomAdapter(RestaurantDetailsActivity.this, (ArrayList<Image>) imagesArray);
        recyclerView.setAdapter(customAdapter);

        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this::onMapReady);
        mapView.onResume();

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}