package com.example.shubham.engifestapp.Activities;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.shubham.engifestapp.R;

public class EventDetailActivity extends AppCompatActivity {

    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8;
    Button button,rules,venue,date,register;
    ImageView imageView;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        imageView = findViewById(R.id.image_master);
        textView1 = findViewById(R.id.about_event);
        textView2 = findViewById(R.id.eventdate);
        textView3 = findViewById(R.id.eventtime);
        textView4 = findViewById(R.id.master_venue);
        textView5= (TextView)findViewById(R.id.eventvenue);
        textView7 = findViewById(R.id.rulesregul);
        textView6 = findViewById(R.id.rules_event);
        textView8 = findViewById(R.id.offlink);
        // Linkify.addLinks(textView5,Linkify.WEB_URLS);
        button = findViewById(R.id.regbutton);
        scrollView = findViewById(R.id.scroll_View);

        date = findViewById(R.id.date_time);
        rules = findViewById(R.id.rules_regulations);
        venue = findViewById(R.id.venue);
        register = findViewById(R.id.register_link);

       date.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.scrollTo(0,textView2.getTop());
                    }
                });
           }
       });

       venue.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               new Handler().post(new Runnable() {
                   @Override
                   public void run() {
                       scrollView.scrollTo(0,textView4.getBottom());
                   }
               });
           }
       });

       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               new Handler().post(new Runnable() {
                   @Override
                   public void run() {
                       scrollView.scrollTo(0,button.getTop());
                   }
               });
           }
       });

       rules.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               new Handler().post(new Runnable() {
                   @Override
                   public void run() {
                       scrollView.scrollTo(0,textView7.getTop());
                   }
               });
           }
       });

    }
}
