package com.example.restaurantsapplication.restaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.restaurantsapplication.R;
import com.example.restaurantsapplication.adapter.ItemAdapter;
import com.example.restaurantsapplication.model.Item;
import com.example.restaurantsapplication.server.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantsActivity extends AppCompatActivity {

    ItemAdapter.ItemClickListener listener;

    ItemAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        itemList=new ArrayList<>();

         recyclerView= findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        setOnClickListener();
        adapter=new ItemAdapter(this,itemList ,listener);

        getRestaurants();




    }

    public void getRestaurants(){
        Call<List<Item>> restaurantList= RetrofitClient.getService().getRestaurants();

        restaurantList.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if(response.isSuccessful()){
                    Log.e("success", response.body().toString());
                List<Item> resp=response.body();
                itemList= (ArrayList<Item>) resp;
                adapter.setData(resp);
                recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Log.e("success", t.getLocalizedMessage());


            }
        });

    }

    private void setOnClickListener() {
        listener=new ItemAdapter.ItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                    Log.d("item list",String.valueOf(itemList.size()));
                    String name=itemList.get(position).getName();
                    String description=itemList.get(position).getDescription();

                    Intent intent=new Intent(getApplicationContext(), RestaurantDetailsActivity.class);
                    intent.putExtra("title", name);
                    intent.putExtra("subtitle",description);
                    startActivityForResult(intent,200);

            }
        };
    }


}