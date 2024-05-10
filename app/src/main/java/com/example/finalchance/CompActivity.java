package com.example.finalchance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class CompActivity extends AppCompatActivity {
    EDatabaseAdapter databaseAdapter;
    RecyclerView d_viewer;
    CompAdapter adapter;
    RecyclerView.LayoutManager manager;
    CompAdapter.D_ListListener listener;
    List<Entity> entityList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comp_main);
        setOnClickListener();
        databaseAdapter = new EDatabaseAdapter(this);
        entityList = databaseAdapter.getDATA();
        d_viewer = findViewById(R.id.d_viewer);
        d_viewer.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        d_viewer.setLayoutManager(manager);
        adapter = new CompAdapter(this, entityList, d_viewer,listener);
        d_viewer.setAdapter(adapter);

    }

    private void setOnClickListener() {
        listener = new CompAdapter.D_ListListener() {
            @Override
            public void onClick(View v, int position) {
                Intent i = new Intent(CompActivity.this, CompDPage.class);

                i.putExtra("name", entityList.get(position).getName());
                i.putExtra("type", entityList.get(position).getType());
                i.putExtra("description", entityList.get(position).getDescription());
                i.putExtra("level", entityList.get(position).getLevel());
                i.putExtra("origin", entityList.get(position).getOrigin());
                i.putExtra("imageId", entityList.get(position).getImg());
                startActivity(i);
            }
        };
    }
}

