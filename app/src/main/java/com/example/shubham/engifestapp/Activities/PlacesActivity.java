package com.example.shubham.engifestapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.shubham.engifestapp.CustomView.CircularIndexView;
import com.example.shubham.engifestapp.Interfaces.OnIndexChangeListener;
import com.example.shubham.engifestapp.R;

public class PlacesActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        textView = (TextView)findViewById(R.id.text_title);

        CircularIndexView circularIndexView = (CircularIndexView) findViewById(R.id.circular_view);
        circularIndexView.setOnIndexChangeListener(new OnIndexChangeListener() {
            @Override
            public void OnIndexChange(String place) {
                textView.setText(place);
            }
        });
        circularIndexView.setIndexPlace("BR AMBEDKAR AUDITORIUM");
        textView.setText("BR AMBEDKAR AUDITORIUM");

    }
}
