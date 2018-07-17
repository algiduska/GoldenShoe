package com.example.android.goldenshoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textviewTitle;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        textviewTitle = (TextView) findViewById(R.id.actionbar_textview);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                Intent main = new Intent(MainActivity.this, MainActivity.class);
                                startActivity(main);
                                break;
                            case R.id.navigation_look:
                                Intent search = new Intent(MainActivity.this, SearchActivity.class);
                                startActivity(search);
                                break;
                            case R.id.navigation_basket:
                                Intent basket = new Intent(MainActivity.this, BasketActivity.class);
                                startActivity(basket);
                                break;
                            case R.id.navigation_favourite:
                                Intent favourite = new Intent(MainActivity.this, FavouritesActivity.class);
                                startActivity(favourite);
                                break;
                            case R.id.navigation_account:
                                Intent account = new Intent(MainActivity.this, AccountActivity.class);
                                startActivity(account);
                                break;
                        }
                        return false;
                    }
                });

    }

}
