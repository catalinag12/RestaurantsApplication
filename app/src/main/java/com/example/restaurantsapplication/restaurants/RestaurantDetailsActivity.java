package com.example.restaurantsapplication.restaurants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.restaurantsapplication.adapter.CustomAdapter;
import com.example.restaurantsapplication.R;
import com.example.restaurantsapplication.model.Image;
import com.example.restaurantsapplication.model.Item;
import com.example.restaurantsapplication.util.SharedPrefUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private RecyclerView recyclerView;
    List<Image> imagesArray;
    private TextView tvTitle;
    private TextView tvSubtitle;
    CustomAdapter customAdapter;
    private MapView mapView;
    String title = "Title";
    String subtitle = "Subtitle";
    Float latitude=0.0f;
    Float longitude=0.0f;
    Integer id;
    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        tvTitle = findViewById(R.id.list_item_text);
        tvSubtitle = findViewById(R.id.list_item_secondary_text);
        mapView=findViewById(R.id.map);
        myToolbar=findViewById(R.id.my_toolbar);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title = extras.getString("title");
            subtitle = extras.getString("subtitle");
            latitude=extras.getFloat("latitude");
            longitude=extras.getFloat("longitude");
            id=extras.getInt("id");
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

        myToolbar.setTitle(title);
        setSupportActionBar(myToolbar);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng latLng=new LatLng(latitude,longitude);
        googleMap.addMarker(new MarkerOptions().position(latLng).title(title));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    private Menu  menu;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        this.menu = menu;
        if(SharedPrefUtil.isFavourite(this, id)){

            this.menu.findItem(R.id.action_favorite).setVisible(true);
            this.menu.findItem(R.id.action_not_favorite).setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

            item.setVisible(false);
            if(R.id.action_favorite == item.getItemId()){
                SharedPrefUtil.addOrRemoveItem(this,id);
                this.menu.findItem(R.id.action_not_favorite).setVisible(true);
            }
            if(R.id.action_not_favorite == item.getItemId()){
                SharedPrefUtil.addOrRemoveItem(this,id);
                this.menu.findItem(R.id.action_favorite).setVisible(true);
            }

            return super.onOptionsItemSelected(item);

    }



}

