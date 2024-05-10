package com.example.finalchance;

import static androidx.appcompat.R.layout.support_simple_spinner_dropdown_item;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class FuseActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
        Spinner d_spin;
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fuse_main);
            d_spin = (Spinner) findViewById(R.id.select);
            Populate();
            d_spin.setOnItemSelectedListener(this);

        }

    private  void Populate(){
            EDatabaseAdapter eDatabaseAdapter = new EDatabaseAdapter(getApplicationContext());
            List<String> names = eDatabaseAdapter.sendNames();
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, support_simple_spinner_dropdown_item, names);
            d_spin.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            EDatabaseAdapter eDatabaseAdapter = new EDatabaseAdapter(getApplicationContext());
            List<String> recipes = eDatabaseAdapter.sendRecipes();
            TextView D_REC = findViewById(R.id.recipe_holder);
            String spot = recipes.get(position);
            D_REC.setText(spot);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

