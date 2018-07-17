package com.example.android.goldenshoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class BasketActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);


        Button order = (Button) findViewById(R.id.button);
        order.setOnClickListener(this);



        BottomNavigationView navigationSearch = (BottomNavigationView) findViewById(R.id.navigation_search);
        navigationSearch.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                Intent main = new Intent(BasketActivity.this, MainActivity.class);
                                startActivity(main);
                                break;
                            case R.id.navigation_look:
                                Intent search = new Intent(BasketActivity.this, SearchActivity.class);
                                startActivity(search);
                                break;
                            case R.id.navigation_basket:
                                Intent basket = new Intent(BasketActivity.this, BasketActivity.class);
                                startActivity(basket);
                                break;
                            case R.id.navigation_favourite:
                                Intent favourite = new Intent(BasketActivity.this, FavouritesActivity.class);
                                startActivity(favourite);
                                break;
                            case R.id.navigation_account:
                                Intent account = new Intent(BasketActivity.this, AccountActivity.class);
                                startActivity(account);
                                break;
                        }
                        return false;
                    }
                });

    }

    public void onClick(View view){
        Intent checkout = new Intent(BasketActivity.this, CheckoutActivity.class);
        startActivity(checkout);
    }
}
