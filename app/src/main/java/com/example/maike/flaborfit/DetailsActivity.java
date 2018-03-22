package com.example.maike.flaborfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox mCheckBox1;
    private CheckBox mCheckBox2;
    private CheckBox mCheckBox3;
    private CheckBox mCheckBox4;
    private CheckBox mCheckBox5;

    private String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView exerciseTitle = findViewById(R.id.exerciseTitle);
        mTitle = getIntent().getStringExtra(MainActivity.EXTRA_ITEM_TITLE);

        if(mTitle != null && !mTitle.isEmpty()) {
            exerciseTitle.setText(mTitle);
        }

        setupCheckBoxes();
    }

    private void setupCheckBoxes() {
        mCheckBox1 = findViewById(R.id.weight_checkbox1);
        mCheckBox2 = findViewById(R.id.weight_checkbox2);
        mCheckBox3 = findViewById(R.id.weight_checkbox3);
        mCheckBox4 = findViewById(R.id.weight_checkbox4);
        mCheckBox5 = findViewById(R.id.weight_checkbox5);

        mCheckBox1.setOnClickListener(this);
        mCheckBox2.setOnClickListener(this);
        mCheckBox3.setOnClickListener(this);
        mCheckBox4.setOnClickListener(this);
        mCheckBox5.setOnClickListener(this);

        // restore checkboxes from sharedpreferences (if stored)
        mCheckBox1.setChecked(SharedPrefs.getBoolean(this, mTitle + "_check1"));
        mCheckBox2.setChecked(SharedPrefs.getBoolean(this, mTitle + "_check2"));
        mCheckBox3.setChecked(SharedPrefs.getBoolean(this, mTitle + "_check3"));
        mCheckBox4.setChecked(SharedPrefs.getBoolean(this, mTitle + "_check4"));
        mCheckBox5.setChecked(SharedPrefs.getBoolean(this, mTitle + "_check5"));
    }

    /*
    De volgende keys worden gebruikt om alle checkboxes van de verschillende activiteiten te onderscheiden
    SharedPreferences gebruikt deze om in dit geval booleans op te slaan en ze weer uit het geheugen te kunnen halen
    Het is niet een super elegante methode en kan beter met andere datastructuren, maar het is voor het voorbeeld :)
    Yoga_check1     Weight Lifting_check1       Cardio_check1
    Yoga_check2     Weight Lifting_check2       Cardio_check2
    Yoga_check3     Weight Lifting_check3       Cardio_check3
    Yoga_check4     Weight Lifting_check4       Cardio_check4
    Yoga_check5     Weight Lifting_check5       Cardio_check5
     */

    @Override
    public void onClick(View v) {
        if (mTitle == null) return; // moet niet voorkomen

        // bij elke checkbox worden alle waarden opgeslagen in sharedpreferences, zodat ze in de mainactivity kunnen worden uitgelezen
        // en ook hier weer hersteld kunnen worden
        SharedPrefs.setBoolean(this, mTitle + "_check1", mCheckBox1.isChecked()); // in het geval van yoga de key is "Yoga_check1"
        SharedPrefs.setBoolean(this, mTitle + "_check2", mCheckBox2.isChecked());
        SharedPrefs.setBoolean(this, mTitle + "_check3", mCheckBox3.isChecked());
        SharedPrefs.setBoolean(this, mTitle + "_check4", mCheckBox4.isChecked());
        SharedPrefs.setBoolean(this, mTitle + "_check5", mCheckBox5.isChecked());

        // de status van de checkboxes is te zien in LogCat
        Log.d(DetailsActivity.class.getSimpleName(), "onClick: " +
                        "\nCheckBox1: " + mCheckBox1.isChecked() +
                        "\nCheckBox2: " + mCheckBox2.isChecked() +
                        "\nCheckBox3: " + mCheckBox3.isChecked() +
                        "\nCheckBox4: " + mCheckBox4.isChecked() +
                        "\nCheckBox5: " + mCheckBox5.isChecked()

        );
    }
}
