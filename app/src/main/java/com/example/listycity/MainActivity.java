package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    private int selected_position=-1;
    EditText cityInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        cityInput = findViewById(R.id.input);

        String[] cities = {
                "Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin",
                "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"
        };

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList((cities)));

        cityAdapter = new ArrayAdapter<>(this,R.layout.content,dataList);

        cityList.setAdapter(cityAdapter);

        Button addButton= findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String city = cityInput.getText().toString();

                if (!city.isEmpty()) {
                    dataList.add(city);
                    cityAdapter.notifyDataSetChanged();
                    cityInput.setText("");
                }
            }
        });
        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                selected_position=position;
            }
        });
        Button deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dataList.remove(selected_position);
                cityAdapter.notifyDataSetChanged();
                selected_position=-1;
            }
        });
    }

}