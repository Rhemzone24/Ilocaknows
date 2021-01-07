package com.example.ilocaknows;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.myList);
        List<String> myList = new ArrayList<>();
        myList.add("Takbo");myList.add("Maglakad");
        myList.add("Explanasyon"); myList.add("Pangalan");
        myList.add("Magkano");myList.add("Pupunta nako");
        myList.add("Buwan"); myList.add("Usok");
        myList.add("Bundok");myList.add("Puti");
        myList.add("Gabi"); myList.add("Umaga");
        myList.add("Tanghali");myList.add("Hapon");

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search_icon);
        SearchView searchView =  (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search here");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                arrayAdapter.getFilter().filter(s);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    public class DatabaseTable {
        private final DatabaseOpenHelper databaseOpenHelper;

        public DatabaseTable(Context context) {
            databaseOpenHelper = new DatabaseOpenHelper(context);
        }
    }
}