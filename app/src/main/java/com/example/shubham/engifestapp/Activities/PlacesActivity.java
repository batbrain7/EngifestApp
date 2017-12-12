package com.example.shubham.engifestapp.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shubham.engifestapp.CustomView.CircularIndexView;
import com.example.shubham.engifestapp.Interfaces.OnIndexChangeListener;
import com.example.shubham.engifestapp.R;

public class PlacesActivity extends AppCompatActivity {

    private TextView textView;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        textView = findViewById(R.id.navigate_text);

        fab = findViewById(R.id.navigation_icon);
        CircularIndexView circularIndexView = findViewById(R.id.circular_view);
        circularIndexView.setOnIndexChangeListener(new OnIndexChangeListener() {
            @Override
            public void OnIndexChange(final String place) {

                textView.setText("Get directions to " + place);

                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (place) {

                            case "MECH C" :
                                NavigateInDTU("Canteen");
                                break;
                            case "SPS Halls":
                                NavigateInDTU("SPS - 13");
                                break;
                            case "Clock Tower":
                                NavigateInDTU("Training and Placement Department");
                                break;
                            case "Edusat Hall":
                                NavigateInDTU("Dr. BR Ambedkar Auditorium");
                                break;
                            case "Hostel Road":
                                NavigateInDTU("CV Raman Hostel");
                                break;
                            case "Transit Hostel Ground":
                                NavigateInDTU("Ramanujan Hostel");
                                break;
                            default:
                                NavigateInDTU(place);
                        }
                    }
                });
            }
        });
        circularIndexView.setIndexPlace("BR Ambedkar Auditorium");
 //       textView.setText("BR AMBEDKAR AUDITORIUM");

    }

    public void NavigateInDTU(String pname) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q="+pname+",DTU+,Delhi"));
        startActivity(intent);
    }
}
