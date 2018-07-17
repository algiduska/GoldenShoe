package com.example.android.goldenshoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CheckoutActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);


        Button order = (Button) findViewById(R.id.button);
        order.setOnClickListener(this);



        BottomNavigationView navigationSearch = (BottomNavigationView) findViewById(R.id.navigation_search);
        navigationSearch.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                Intent main = new Intent(CheckoutActivity.this, MainActivity.class);
                                startActivity(main);
                                break;
                            case R.id.navigation_look:
                                Intent search = new Intent(CheckoutActivity.this, SearchActivity.class);
                                startActivity(search);
                                break;
                            case R.id.navigation_basket:
                                Intent basket = new Intent(CheckoutActivity.this, BasketActivity.class);
                                startActivity(basket);
                                break;
                            case R.id.navigation_favourite:
                                Intent favourite = new Intent(CheckoutActivity.this, FavouritesActivity.class);
                                startActivity(favourite);
                                break;
                            case R.id.navigation_account:
                                Intent account = new Intent(CheckoutActivity.this, AccountActivity.class);
                                startActivity(account);
                                break;
                        }
                        return false;
                    }
                });

    }

    public void onClick(View view){
        Toast.makeText(CheckoutActivity.this, "Your order was successfully submitted", Toast.LENGTH_SHORT).show();
        Intent checkout = new Intent(CheckoutActivity.this, MainActivity.class);
        startActivity(checkout);
    }
}
