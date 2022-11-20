package com.example.mp_final;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mp_final.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding viewBinding;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        getSupportActionBar().hide();

        ArrayList<Data> dataArrayList = new ArrayList<>();
        ArrayList<Integer> colorList = new ArrayList<>();

        DataRVAdapter dataRVAdapter = new DataRVAdapter(dataArrayList);
        viewBinding.recyclerview.setAdapter(dataRVAdapter);
        viewBinding.recyclerview.setLayoutManager(new LinearLayoutManager(this));

        //걍...랜덤으로 정해버려
        colorList.add(Color.RED);
        colorList.add(Color.BLUE);
        colorList.add(Color.GREEN);
        colorList.add(Color.GRAY);
        colorList.add(Color.BLACK);
        colorList.add(Color.YELLOW);
        colorList.add(Color.MAGENTA);
        colorList.add(Color.DKGRAY);
        colorList.add(Color.CYAN);
        colorList.add(Color.WHITE);

        Log.d("main", colorList + "");

        viewBinding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = viewBinding.nameEdit.getText().toString();
                Integer row = Integer.parseInt(viewBinding.rowEdit.getText().toString());
                Integer col = Integer.parseInt(viewBinding.colEdit.getText().toString());
                Integer height = Integer.parseInt(viewBinding.heightEdit.getText().toString());
                Integer color = colorList.get(i);
                i += 1;
                Data data = new Data(name, row, col, height, color);

                viewBinding.nameEdit.setText("");
                viewBinding.rowEdit.setText("");
                viewBinding.colEdit.setText("");
                viewBinding.heightEdit.setText("");

                dataArrayList.add(data);
                dataRVAdapter.notifyItemChanged(dataArrayList.size());
                Log.d("main", "data add");
            }
        });

        viewBinding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), GridActivity.class);
                intent.putExtra("list", dataArrayList);
                intent.putExtra("color", colorList);

                startActivity(intent);
            }
        });


    }
}