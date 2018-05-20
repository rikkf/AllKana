package com.codanimex.android.allkana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Riccardo on 01/09/2017.
 */

public class KatakanaLearn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.katakana_layout);
    }

    public void onLearnKatakanaClicked(View view) {
        Intent intent = new Intent(this, KatakanaTab.class);
        startActivity(intent);
    }
}
