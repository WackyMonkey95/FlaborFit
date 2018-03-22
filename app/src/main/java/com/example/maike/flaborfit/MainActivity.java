package com.example.maike.flaborfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String EXTRA_ITEM_TITLE = "extra.item.title";
    public static final String EXERCISE_WEIGHTS = "Weight Lifting";
    public static final String EXERCISE_YOGA = "Yoga";
    public static final String EXERCISE_CARDIO = "Cardio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.weight).setOnClickListener(this);
        findViewById(R.id.yoga).setOnClickListener(this);
        findViewById(R.id.cardio).setOnClickListener(this);


    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.weight:
                loadDetailActivity(EXERCISE_WEIGHTS);
                break;
            case R.id.yoga:
                loadDetailActivity(EXERCISE_YOGA);
                break;
            case R.id.cardio:
                loadDetailActivity(EXERCISE_CARDIO);
                break;
            default:
                break;


        }
    }
    private void loadDetailActivity(String weightTitle){
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(MainActivity.EXTRA_ITEM_TITLE, weightTitle);
        startActivity(intent);
        //kan dit anders
    }
}