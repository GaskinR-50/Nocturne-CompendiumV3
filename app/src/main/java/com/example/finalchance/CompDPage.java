package com.example.finalchance;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalchance.databinding.DpagexmlBinding;

public class CompDPage extends AppCompatActivity {
    DpagexmlBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DpagexmlBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if(intent != null){

            String name = intent.getStringExtra("name");
            String type = intent.getStringExtra("type");
            String description = intent.getStringExtra("description");
            String level = intent.getStringExtra("level");
            String origin = intent.getStringExtra("origin");
            byte[] imageid = intent.getByteArrayExtra("imageId");


            binding.dName.setText(name);
            binding.dType.setText(type);
            binding.dDescription.setText(description);
            binding.dLevel.setText(level);
            binding.dOrigin.setText(origin);
            binding.dImage.setImageBitmap(BitmapFactory.decodeByteArray(imageid,0, imageid.length));
        }
    }
}
