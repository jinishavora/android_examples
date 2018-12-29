package com.example.vora.recyclerview_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Person> people;

    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                people.add(new Person("Susan", "Peters", "plane"));
                myAdapter.notifyDataSetChanged();

            }
        });

        //layoutManager = new LinearLayoutManager(this); //Simple vertical list
        //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false); // linear hotizontal list
        layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false); //Grid vertical or horizontal and span count could be 2, 3, 4,....depending on the no on values displayed in a row/column
        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<Person>();
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Peter", "Jennings", "plane"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Peter", "Jennings", "plane"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Peter", "Jennings", "plane"));
        people.add(new Person("Tom", "Cruise", "plane"));

        myAdapter = new PersonAdapter(this, people);

        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClicked(int index) {

        Toast.makeText(this, "Surname "+people.get(index).getSurname(), Toast.LENGTH_SHORT).show();

    }
}
