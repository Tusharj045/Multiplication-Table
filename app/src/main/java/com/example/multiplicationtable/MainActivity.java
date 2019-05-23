package com.example.multiplicationtable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTablesListView;

    public void generateTimesTable(int timesTableNumber) {
        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int j = 1; j <= 10; j++) {
            timesTableContent.add("\t\t"+Integer.toString(timesTableNumber)+" x "+Integer.toString(j)+" = "+ Integer.toString(j * timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timesTableContent);

        timesTablesListView.setAdapter(arrayAdapter);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTablesSeekBar = findViewById(R.id.timesTablesSeekBar);
        timesTablesListView = findViewById(R.id.timesTablesListView);

        int max = 20;
        int startingPosition = 10;
        TextView textTitle=(TextView) findViewById(R.id.textTitle);
        textTitle.setText("Multiplication Table of "+Integer.toString(startingPosition));
        timesTablesSeekBar.setMax(max);
        timesTablesSeekBar.setProgress(startingPosition);

        generateTimesTable(startingPosition);


        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTableNumber;


                //textTitle.setText("Multiplication Table of "+Integer.toString(timesTableNumber));

                if (i < min) {
                    timesTableNumber = min;
                    timesTablesSeekBar.setProgress(min);
                } else {
                    timesTableNumber = i;
                }


                Log.i("Seekbar Value", Integer.toString(timesTableNumber));
                TextView textTitle=(TextView) findViewById(R.id.textTitle);
                textTitle.setText("Multiplication Table of "+Integer.toString(timesTableNumber));



                generateTimesTable(timesTableNumber);
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
