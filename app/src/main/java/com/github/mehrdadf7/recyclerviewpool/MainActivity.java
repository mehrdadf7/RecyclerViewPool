package com.github.mehrdadf7.recyclerviewpool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        ItemAdapter itemAdapter = new ItemAdapter(buildItemList());

        recyclerView.setAdapter(itemAdapter);

        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private List<Item> buildItemList() {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            items.add(new Item("Title " + i, buildSubItemList()));
        }
        return items;
    }


    private List<SubItem> buildSubItemList() {
        List<SubItem> subItems = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            subItems.add(new SubItem(R.drawable.ic_android_black_24dp, "Sub Item " + i, "Desc " + i));
        }
        return subItems;
    }
}
