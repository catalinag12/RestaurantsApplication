package com.example.restaurantsapplication;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.restaurantsapplication.restaurants.RestaurantsActivity;

public class SplashActivity extends AppCompatActivity {
   private static final int _splashTime=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
                Intent transitionIntent=new Intent(getApplicationContext(), RestaurantsActivity.class);
                startActivity(transitionIntent);
            }
        }, _splashTime);

    }


}