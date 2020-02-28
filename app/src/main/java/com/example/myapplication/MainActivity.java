package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static int min = 1;
    final static int max = 20;
    final static int starter = 10;
    ArrayList<String> prodList;


    void populateList(int multiplicand) {

        prodList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            prodList.add(String.format("%d * %d = %d", i, multiplicand, i * multiplicand));
        }

        ArrayAdapter<String> prodListAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, prodList);

        ListView prodListView = (ListView) findViewById(R.id.productListView);
        prodListView.setAdapter(prodListAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar mulSeekBar = (SeekBar) findViewById(R.id.multiplicandSeekBar);
        mulSeekBar.setMax(max);
        mulSeekBar.setProgress(starter);
        populateList(starter);

        mulSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress < min) {
                    progress = min;
                    seekBar.setProgress(min);
                }

                populateList(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
