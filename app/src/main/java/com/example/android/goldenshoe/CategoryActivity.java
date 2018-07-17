package com.example.android.goldenshoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

import java.lang.reflect.Field;
import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    ImageView heart;


    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ArrayList<Shoes> shoez = new ArrayList<>();
        shoez.add(new Shoes("Aztec Sandals", 22.99, R.drawable.aztec));
        shoez.add(new Shoes("Studded Straps", 21.99, R.drawable.sandal1));
        shoez.add(new Shoes("Merciful Tiger", 24.99, R.drawable.sandal5));
        shoez.add(new Shoes("Aztec Flip", 17.99, R.drawable.sandal3));
        shoez.add(new Shoes("Gladiator Win", 19.99, R.drawable.sandal4));
        shoez.add(new Shoes("Comfy Toe Post", 34.99, R.drawable.sandal2));
        shoez.add(new Shoes("Diamonte Sandals", 29.99, R.drawable.aztec_sandals));


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
        disableShiftMode(navigationSearch);

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
    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView nw) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) nw.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }

}
