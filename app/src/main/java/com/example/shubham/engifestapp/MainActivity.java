package com.example.shubham.engifestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.shubham.engifestapp.Activities.EventDetailActivity;
import com.example.shubham.engifestapp.Activities.PlacesActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void IntentOpen(View view) {
        Intent intent = new Intent(MainActivity.this, EventDetailActivity.class);
        startActivity(intent);
    }
}
