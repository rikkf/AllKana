package com.codanimex.android.allkana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * Created by Riccardo on 01/09/2017.
 */

public class HiraganaLearn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hiragana_layout);
    }

    public void onLearnHiraganaClicked(View view) {
        Intent intent = new Intent(this, HiraganaTab.class);
        startActivity(intent);
    }

    public void onQuizHiraganaClicked(View view) {
    }
}
