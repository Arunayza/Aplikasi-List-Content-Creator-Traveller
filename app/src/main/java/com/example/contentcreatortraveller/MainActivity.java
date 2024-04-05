package com.example.contentcreatortraveller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTraveler;
    private ArrayList<Traveler> list = new ArrayList<>();
    private ListTrvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTraveler = findViewById(R.id.rv_traveler);
        rvTraveler.setHasFixedSize(true);

        list.addAll(TravelerData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvTraveler.setLayoutManager(new LinearLayoutManager(this));

        ListTrvAdapter listTravelAdapter = new ListTrvAdapter(list);
        rvTraveler.setAdapter(listTravelAdapter);

        listTravelAdapter.setOnItemClickCallback(new ListTrvAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Traveler data) {
                showSelectedTraveler(data);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about_page) {
            showIcon();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showIcon() {
        Intent aboutIntent = new Intent(MainActivity.this, About.class);
        startActivity(aboutIntent);
    }

    private void showSelectedTraveler(Traveler trv) {
        Intent moveWithDataIntent = new Intent(MainActivity.this, DetailActivity.class);
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_TRAVELER, trv.getAlias());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_NAMA, trv.getNama());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_PHOTO, trv.getPhoto());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_DESK, trv.getDeskripsi());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_NEGARA, trv.getNegara());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_TTL, trv.getTTL());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_IG, trv.getIg());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_YT, trv.getYt());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_TIKTOK, trv.getTiktok());
        startActivity(moveWithDataIntent);
    }
}
