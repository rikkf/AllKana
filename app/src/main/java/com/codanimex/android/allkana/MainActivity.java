package com.codanimex.android.allkana;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.codanimex.android.allkana.tabs.HiraganaTab;
import com.codanimex.android.allkana.tabs.KatakanaTab;

public class MainActivity extends AppCompatActivity {
    static SharedPreferences infoStatus;
    ProgressBar hiraganaProgress;
    ProgressBar katakanaProgress;
    TextView percentageHiragana;
    TextView percentageKatakana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        hiraganaProgress = (ProgressBar) findViewById(R.id.hiraganaProgressBar);
        katakanaProgress = (ProgressBar) findViewById(R.id.katakanaProgressBar);
        percentageHiragana = (TextView) findViewById(R.id.percentage_hiragana_progress);
        percentageKatakana = (TextView) findViewById(R.id.percentage_katakana_progress);
        infoStatus = getSharedPreferences("com.codanimex.android.allkana", Context.MODE_WORLD_WRITEABLE);
        hiraganaProgress.setProgress(infoStatus.getInt("HiraganaStatus", 0));
        katakanaProgress.setProgress(infoStatus.getInt("KatakanaStatus", 0));
        percentageHiragana.setText(infoStatus.getInt("HiraganaStatus", 0)+"%");
        percentageKatakana.setText(infoStatus.getInt("KatakanaStatus", 0)+"%");
    }

    @Override
    protected void onResume() {
        super.onResume();
        hiraganaProgress = (ProgressBar) findViewById(R.id.hiraganaProgressBar);
        katakanaProgress = (ProgressBar) findViewById(R.id.katakanaProgressBar);
        percentageHiragana = (TextView) findViewById(R.id.percentage_hiragana_progress);
        percentageKatakana = (TextView) findViewById(R.id.percentage_katakana_progress);
        infoStatus = getSharedPreferences("com.codanimex.android.allkana", Context.MODE_WORLD_WRITEABLE);
        hiraganaProgress.setProgress(infoStatus.getInt("HiraganaStatus", 0));
        katakanaProgress.setProgress(infoStatus.getInt("KatakanaStatus", 0));
        percentageHiragana.setText(infoStatus.getInt("HiraganaStatus", 0)+"%");
        percentageKatakana.setText(infoStatus.getInt("KatakanaStatus", 0)+"%");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);//Menu Resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.theme:
                Toast.makeText(getApplicationContext(), "Theme Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.rate:
                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                }
                return true;
            case R.id.support:
                Toast.makeText(getApplicationContext(), "Support Selected", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void onHiraganaLearnClicked(View view) {
        Intent intent = new Intent(this, HiraganaLearn.class);
        this.onPause();
        infoStatus = getSharedPreferences("com.codanimex.android.allkana", Context.MODE_WORLD_WRITEABLE);
        infoStatus.edit().putInt("HiraganaStatus", 25).apply();
        startActivity(intent);
    }

    public void onKatakanaLearnClicked(View view) {
        Intent intent = new Intent(this, KatakanaLearn.class);
        this.onPause();
        infoStatus = getSharedPreferences("com.codanimex.android.allkana", Context.MODE_WORLD_WRITEABLE);
        infoStatus.edit().putInt("KatakanaStatus", 35).apply();
        startActivity(intent);
    }
}
