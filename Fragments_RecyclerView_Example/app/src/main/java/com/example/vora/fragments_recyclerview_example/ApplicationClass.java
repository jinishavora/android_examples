package com.example.vora.fragments_recyclerview_example;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people = new ArrayList<Person>();

        people.add(new Person("Chuck Norris", "1231443536"));
        people.add(new Person("John Rambo", "1221343536"));
        people.add(new Person("Nelson Madela", "121235543536"));
    }
}
