package com.example.maike.flaborfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView exerciseTitle = findViewById(R.id.exerciseTitle);
        ImageView weightImage = findViewById(R.id.weightImage);

        String title = getIntent().getStringExtra(MainActivity.EXTRA_ITEM_TITLE);

        if(title != null && !title.isEmpty()) {
            exerciseTitle.setText(title);
        }
    }
}
