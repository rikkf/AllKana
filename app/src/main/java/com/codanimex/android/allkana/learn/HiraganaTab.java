package com.codanimex.android.allkana.learn;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.codanimex.android.allkana.HiraganaViewActivity;
import com.codanimex.android.allkana.R;

/**
 * Created by Riccardo on 04/09/2017.
 */

public class HiraganaTab extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana_tab);
        getIntent();
    }

    public void onHiraganaSelected(View view) {
        Button kanaButton = (Button) findViewById(view.getId());
        Intent intent = new Intent(this, HiraganaViewActivity.class);
        String hiraganaTitle = kanaButton.getText().toString();
        String romajiTitle = kanaButton.getContentDescription().toString();
        intent.putExtra("hiragana_title", hiraganaTitle);
        intent.putExtra("romaji_title", romajiTitle);
        startActivity(intent);
    }

}
