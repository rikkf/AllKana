package com.codanimex.android.allkana.tabs;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.codanimex.android.allkana.KatakanaViewActivity;
import com.codanimex.android.allkana.R;

/**
 * Created by Riccardo on 04/09/2017.
 */

public class KatakanaTab extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katakana_tab);
        getIntent();
    }

    public void onKatakanaSelected(View view) {
        Button kanaButton = (Button) findViewById(view.getId());
        Intent intent = new Intent(this, KatakanaViewActivity.class);
        String katakanaTitle = kanaButton.getText().toString();
        String romajiTitle = kanaButton.getContentDescription().toString();
        intent.putExtra("katakana_title", katakanaTitle);
        intent.putExtra("romaji_title", romajiTitle);
        startActivity(intent);
    }

}
