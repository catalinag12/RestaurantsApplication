package com.example.restaurantsapplication.restaurants;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.restaurantsapplication.ItemAdapter;
import com.example.restaurantsapplication.R;
import com.example.restaurantsapplication.model.Item;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

    //setam recycler view ul in activitate
    RecyclerView recyclerView= findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
    ItemAdapter adapter=new ItemAdapter(this, getMockedItems());
    recyclerView.setAdapter(adapter);

}
    private ArrayList<Item> getMockedItems(){
        ArrayList<Item> items =new ArrayList<>();
        items.add(new Item(R.drawable.ic_launcher_background,"The Clink Restaurant","The Clink Restaurant at HMP Brixton opened in February 2014 as the third restaurant operated by The Clink Charity in the UK and offers up to 30 prisoners full-time work within the restaurant and kitchen. Prisoners train towards gaining nationally recognised City & Guilds NVQs before returning to their cells at the end of the working day. Upon their release, The Clink Charity helps graduates find employment within the catering and hospitality industry. The restaurant is a flagship example of a unique charitable project that is committed to reducing reoffending rates, in partnership with HMPS. The restaurant positively promotes the rehabilitation and reintegration of prisoners and also champions the wealth of quality, fresh and organic produce available throughout the UK with many vegetables and herbs being sourced from the prison gardens. The restaurant is located in the former Governor's house built in 1819, the 120-cover restaurant is available for exclusive hire. Breakfast is served from Monday to Friday between 8:15am and 10:30am, and lunch is served from Monday to Friday between 12pm and 3pm. "));

        return items;

    }
}