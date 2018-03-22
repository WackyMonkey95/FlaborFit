package com.example.maike.flaborfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Textview exerciseTilte = (Textview) finViewById(R.id.weightTitle)
        TextView exerciseTitle = findViewById(R.id.exerciseTitle);
        ImageView weightImage = findViewById(R.id.weightImage);

    }
}
