package com.example.sabaq;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class show extends AppCompatActivity {
    ListView listViewTasbeeh;
    DbHelper db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        listViewTasbeeh = findViewById(R.id.listViewStudent);

        db = new DbHelper(show.this);

        List<SabaqDiary> list = db.getAllData();

        List<String> myStringList = new ArrayList<>();
        int count = 0;
        while(count<list.size()){
            myStringList.add("Date: "+list.get(count).getDate());
            myStringList.add("Student Name: "+list.get(count).getStudentName());
            myStringList.add("Sabaq Para: "+list.get(count).getSabaqPara());
            myStringList.add("Sabaq Status : "+list.get(count).getSabaqStatus());
            myStringList.add("Sabaqii Para: "+list.get(count).getSabaqiiPara());
            myStringList.add("Sabaqii Status : "+list.get(count).getSabaqiiStatus());
            myStringList.add("Manzil Para: "+list.get(count).getManzilPara());
            myStringList.add("Manzil Status : "+list.get(count).getManzilStatus());
            count++;

        }
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(show.this, android.R.layout.simple_list_item_1, myStringList);
        listViewTasbeeh.setAdapter(arrayAdapter);
    }
}