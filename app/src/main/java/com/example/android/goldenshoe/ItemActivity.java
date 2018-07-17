package com.example.android.goldenshoe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class ItemActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        ImageView image = (ImageView) findViewById(R.id.picture);

        Button order = (Button) findViewById(R.id.button);
        order.setOnClickListener(this);



        BottomNavigationView navigationSearch = (BottomNavigationView) findViewById(R.id.navigation_search);
        navigationSearch.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                Intent main = new Intent(ItemActivity.this, MainActivity.class);
                                startActivity(main);
                                break;
                            case R.id.navigation_look:
                                Intent search = new Intent(ItemActivity.this, SearchActivity.class);
                                startActivity(search);
                                break;
                            case R.id.navigation_basket:
                                Intent basket = new Intent(ItemActivity.this, BasketActivity.class);
                                startActivity(basket);
                                break;
                            case R.id.navigation_favourite:
                                Intent favourite = new Intent(ItemActivity.this, FavouritesActivity.class);
                                startActivity(favourite);
                                break;
                            case R.id.navigation_account:
                                Intent account = new Intent(ItemActivity.this, AccountActivity.class);
                                startActivity(account);
                                break;
                        }
                        return false;
                    }
                });

    }

    public void onClick(View view){
        Toast.makeText(ItemActivity.this, "Item was added to the basket", Toast.LENGTH_SHORT).show();
        Intent basket = new Intent(ItemActivity.this, CategoryActivity.class);
        startActivity(basket);
    }
}
