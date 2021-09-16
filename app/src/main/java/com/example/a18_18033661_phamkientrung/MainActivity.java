package com.example.a18_18033661_phamkientrung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import com.example.a18_18033661_phamkientrung.Entity.Burger;

import java.util.LinkedList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    //private RecycleViewAdapter adapter;
    private LinkedList<Burger> linkedList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.search);
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        linkedList.add(new Burger("Peter Luger", 44.00, R.drawable.a, (float) 4.2));
        linkedList.add(new Burger("Peter Luger", 44.00, R.drawable.b, (float) 4.2));
        linkedList.add(new Burger("Peter Luger", 44.00, R.drawable.c, (float) 4.2));
        linkedList.add(new Burger("Angus Burger", 24.00, R.drawable.d, (float) 2.2));
        linkedList.add(new Burger("Angus Burger", 24.00, R.drawable.e, (float) 2.2));
        linkedList.add(new Burger("Angus Burger", 24.00, R.drawable.f, (float) 2.2));

        //recyclerView = findViewById(R.id.recycleView);
        //adapter = new RecycleViewAdapter(linkedList, this);
        //recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }

    private void filter(String toString) {
        LinkedList<Burger> list = new LinkedList<>();
        for(Burger burger : linkedList){
            if(burger.getTen().toLowerCase().contains(toString.toLowerCase())){
                list.add(burger);
            }
        }
        //adapter.filterList(list);
    }
}