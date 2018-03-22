package com.example.maike.flaborfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String EXTRA_ITEM_TITLE = "extra_item_key";
    public static final String EXERCISE_WEIGHTS = "Weight Lifting";
    public static final String EXERCISE_YOGA = "Yoga";
    public static final String EXERCISE_CARDIO = "Cardio";

    private TextView mWeightPercentage;
    private TextView mYogaPercentage;
    private TextView mCardioPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.weight).setOnClickListener(this);
        findViewById(R.id.yoga).setOnClickListener(this);
        findViewById(R.id.cardio).setOnClickListener(this);

        mWeightPercentage = findViewById(R.id.textView_weight_percentage);
        mYogaPercentage = findViewById(R.id.textView_yoga_percentage);
        mCardioPercentage = findViewById(R.id.textView_cardio_percentage);

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
        //kan dit anders --> yes, maar dit is de meest normale manieren tussen activities
    }

    @Override
    protected void onResume() {
        super.onResume();

        calculatePercentages(EXERCISE_CARDIO);
        calculatePercentages(EXERCISE_WEIGHTS);
        calculatePercentages(EXERCISE_YOGA);
    }

    // dit kan compacter, net zoals de methoden in details activity, maar het is 'gemakkelijker' te begrijpen zo
    private void calculatePercentages(String exercise) {
        int percentage = 0;
        if (SharedPrefs.getBoolean(this, exercise + "_check1")) // returns true or false
            percentage += 20;
        if (SharedPrefs.getBoolean(this, exercise + "_check2"))
            percentage += 20;
        if (SharedPrefs.getBoolean(this, exercise + "_check3"))
            percentage += 20;
        if (SharedPrefs.getBoolean(this, exercise + "_check4"))
            percentage += 20;
        if (SharedPrefs.getBoolean(this, exercise + "_check5"))
            percentage += 20;

        if (exercise.equals(EXERCISE_CARDIO))
            mCardioPercentage.setText(percentage + "%");
        if (exercise.equals(EXERCISE_WEIGHTS))
            mWeightPercentage.setText(percentage + "%");
        if (exercise.equals(EXERCISE_YOGA))
            mYogaPercentage.setText(percentage + "%");
    }
}