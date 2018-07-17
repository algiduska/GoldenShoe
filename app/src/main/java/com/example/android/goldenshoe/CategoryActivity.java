package com.example.android.goldenshoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    ImageView heart;


    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ArrayList<Shoes> shoez = new ArrayList<>();
        shoez.add(new Shoes("Aztec Sandals", 22.99, R.drawable.aztec));
        shoez.add(new Shoes("Lace Sandals", 21.99, R.drawable.aztec));
        shoez.add(new Shoes("Blue Tiger", 24.99, R.drawable.aztec));
        shoez.add(new Shoes("Aztec Flip", 17.99, R.drawable.aztec));
        shoez.add(new Shoes("Be Active", 19.99, R.drawable.aztec));
        shoez.add(new Shoes("Comfy Sandals", 34.99, R.drawable.aztec));
        shoez.add(new Shoes("Diamonte Sandals", 29.99, R.drawable.aztec));
        shoez.add(new Shoes("Jewelled Sandals", 26.99, R.drawable.aztec));
        shoez.add(new Shoes("Toe Post Sandals", 25.99, R.drawable.aztec));
        shoez.add(new Shoes("Glitter Sliders", 20.99, R.drawable.aztec));

        ShoesAdapter adapter = new ShoesAdapter(this, shoez);

        ListView listView = (ListView) findViewById(R.id.shoes_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Intent item = new Intent(CategoryActivity.this, ItemActivity.class);
                startActivity(item);
            }
        });



        heart = (ImageView) findViewById(R.id.heart);



        BottomNavigationView navigationSearch = (BottomNavigationView) findViewById(R.id.navigation_search);
        navigationSearch.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                Intent main = new Intent(CategoryActivity.this, MainActivity.class);
                                startActivity(main);
                                break;
                            case R.id.navigation_look:
                                Intent search = new Intent(CategoryActivity.this, SearchActivity.class);
                                startActivity(search);
                                break;
                            case R.id.navigation_basket:
                                Intent basket = new Intent(CategoryActivity.this, BasketActivity.class);
                                startActivity(basket);
                                break;
                            case R.id.navigation_favourite:
                                Intent favourite = new Intent(CategoryActivity.this, FavouritesActivity.class);
                                startActivity(favourite);
                                break;
                            case R.id.navigation_account:
                                Intent account = new Intent(CategoryActivity.this, AccountActivity.class);
                                startActivity(account);
                                break;
                        }
                        return false;
                    }
                });
    }

}
