package com.example.mp_final;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mp_final.databinding.ActivityGridBinding;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {
    private ActivityGridBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityGridBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        getSupportActionBar().hide();

        Log.d("grid", "activity start");

        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                Button button = new Button(this);
                button.setBackgroundResource(R.drawable.gridbutton_layout);
                viewBinding.gridLayout.addView(button, 51, 51);
            }
        }

        ArrayList<Data> dataArrayList = (ArrayList<Data>) getIntent().getSerializableExtra("list");

        DataRVAdapter dataRVAdapter = new DataRVAdapter(dataArrayList);
        viewBinding.recyclerview.setAdapter(dataRVAdapter);
        viewBinding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
}
