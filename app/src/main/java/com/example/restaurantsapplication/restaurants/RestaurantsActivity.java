package com.example.restaurantsapplication.restaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.restaurantsapplication.ItemAdapter;
import com.example.restaurantsapplication.R;
import com.example.restaurantsapplication.RestaurantDetailsActivity;
import com.example.restaurantsapplication.model.Item;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantsActivity extends AppCompatActivity {

    ItemAdapter.ItemClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

    //setam recycler view ul in activitate
        RecyclerView recyclerView= findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        setOnClickListener();
        ItemAdapter adapter=new ItemAdapter(this, getMockedItems(),listener);
        recyclerView.setAdapter(adapter);


}

    private void setOnClickListener() {
        listener=new ItemAdapter.ItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent=new Intent(getApplicationContext(), RestaurantDetailsActivity.class);
                intent.putExtra("title",getMockedItems().get(position).getTitle());
                intent.putExtra("subtitle",getMockedItems().get(position).getSubtitle());
                startActivity(intent);
            }
        };
    }

    private ArrayList<Item> getMockedItems(){
        ArrayList<Item> items =new ArrayList<>();
        items.add(new Item(R.drawable.ic_launcher_background,"The Clink Restaurant","The Clink Restaurant at HMP Brixton opened in February 2014 as the third restaurant operated by The Clink Charity in the UK and offers up to 30 prisoners full-time work within the restaurant and kitchen. Prisoners train towards gaining nationally recognised City & Guilds NVQs before returning to their cells at the end of the working day. Upon their release, The Clink Charity helps graduates find employment within the catering and hospitality industry. The restaurant is a flagship example of a unique charitable project that is committed to reducing reoffending rates, in partnership with HMPS. The restaurant positively promotes the rehabilitation and reintegration of prisoners and also champions the wealth of quality, fresh and organic produce available throughout the UK with many vegetables and herbs being sourced from the prison gardens. The restaurant is located in the former Governor's house built in 1819, the 120-cover restaurant is available for exclusive hire. Breakfast is served from Monday to Friday between 8:15am and 10:30am, and lunch is served from Monday to Friday between 12pm and 3pm. "));
        items.add(new Item(R.drawable.ic_launcher_background,"The Chelsea Corner","Authentic Italian for us always means the freshest ingredients that are rightly dictated by the season. Everything here is homemade and sourced with love and passion, from our daily landed fish to vegetables from New Covent Garden Market. The Chelsea Corner offers a rich Italian menu choice and something for everyone."));
        items.add(new Item(R.drawable.ic_launcher_background,"Companero","Compañero is the new Street Tapas brought to you by Nikolaus Greig and utilising his vast experience in food & wine. After many years working in successful restaurants he has taken his cooking skills and knowledge a step further. Compañero is a street food concept that will exhibit fine Spanish Tapas in Londons best locations. "));
        items.add(new Item(R.drawable.ic_launcher_background,"Chez Antoinette Victoria","Chez Antoinette is a French Bistro. You can visit us from Breakfast, Brunch and all day long either for just a coffee, lunch, afternoon tea, a glass of wine or a dinner. We serve simple food yet authentic and tasteful French food. If you are just passing by we have a great deli for your lunch take away"));

        return items;

    }
}