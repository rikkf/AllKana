package com.codanimex.android.allkana;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.codanimex.android.allkana.database.Hiragana;
import com.codanimex.android.allkana.database.Katakana;
import com.orm.SugarContext;

public class MainActivity extends AppCompatActivity {
    static SharedPreferences infoStatus;
    ProgressBar hiraganaProgress;
    ProgressBar katakanaProgress;
    TextView percentageHiragana;
    TextView percentageKatakana;
    //TODO: Implements quiz!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        SugarContext.init(this.getApplicationContext());
        SharedPreferences firstStartPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!firstStartPrefs.getBoolean("firstTime", false)) {
            SharedPreferences.Editor editor = firstStartPrefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
            hiragana_fill_database();
            katakana_fill_database();
        }
        hiraganaProgress = findViewById(R.id.hiraganaProgressBar);
        katakanaProgress = findViewById(R.id.katakanaProgressBar);
        percentageHiragana = findViewById(R.id.percentage_hiragana_progress);
        percentageKatakana = findViewById(R.id.percentage_katakana_progress);
        infoStatus = getSharedPreferences("com.codanimex.android.allkana", Context.MODE_WORLD_WRITEABLE);
        hiraganaProgress.setProgress(infoStatus.getInt("HiraganaStatus", 0));
        katakanaProgress.setProgress(infoStatus.getInt("KatakanaStatus", 0));
        percentageHiragana.setText(infoStatus.getInt("HiraganaStatus", 0) + "%");
        percentageKatakana.setText(infoStatus.getInt("KatakanaStatus", 0) + "%");
    }

    @Override
    protected void onResume() {
        super.onResume();
        hiraganaProgress = findViewById(R.id.hiraganaProgressBar);
        katakanaProgress = findViewById(R.id.katakanaProgressBar);
        percentageHiragana = findViewById(R.id.percentage_hiragana_progress);
        percentageKatakana = findViewById(R.id.percentage_katakana_progress);
        infoStatus = getSharedPreferences("com.codanimex.android.allkana", Context.MODE_WORLD_WRITEABLE);
        hiraganaProgress.setProgress(infoStatus.getInt("HiraganaStatus", 0));
        katakanaProgress.setProgress(infoStatus.getInt("KatakanaStatus", 0));
        percentageHiragana.setText(infoStatus.getInt("HiraganaStatus", 0) + "%");
        percentageKatakana.setText(infoStatus.getInt("KatakanaStatus", 0) + "%");
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

    public void katakana_fill_database() {
        String katakanaList[] = {"ア", "イ", "ウ", "エ", "オ", "カ", "キ", "ク", "ケ", "コ", "サ", "シ", "ス", "セ", "ソ", "タ", "チ", "ツ", "テ", "ト", "ナ", "ニ", "ヌ",
                "ネ", "ノ", "ハ", "ヒ", "フ", "ヘ", "ホ", "マ", "ミ", "ム", "メ", "モ", "ヤ", "ツ", "ヨ", "ラ", "リ", "ル", "レ", "ロ", "ワ", "ヲ", "ン", "ガ", "ギ", "グ", "ゲ", "ゴ", "ザ", "ジ", "ズ", "ゼ", "ゾ", "ダ", "ヂ", "ヅ", "デ", "ド", "バ", "ビ",
                "ブ", "ベ", "ボ", "パ", "ピ", "プ", "ペ", "ポ", "キャ", "キュ", "キョ", "シャ", "シュ", "ショ", "チャ", "チュ", "チョ", "ニャ", "ニュ", "ニョ", "ヒャ", "ヒュ", "ヒョ", "ミャ",
                "ミュ", "ミョ", "リャ", "リュ", "リョ", "ギャ", "ギュ", "ギョ", "ジャ", "ジュ", "ジョ", "ビャ", "ビュ", "ビョ", "ピャ", "ピュ", "ピョ"};

        String katakanaListRomaji[] = {"A", "I", "U", "E", "O", "KA", "KI", "KU", "KE", "KO", "SA", "SHI", "SU", "SE", "SO", "TA", "CHI", "TSU", "TE", "TO",
                "NA", "NI", "NU", "NE", "NO", "HA", "HI", "FU", "HE", "HO", "MA", "MI", "MU", "ME", "MO", "YA", "YU", "YO", "RA", "RI", "RU", "RE", "RO", "WA", "WO", "N", "GA", "GI", "GU", "GE", "GO", "ZA", "JI", "ZU", "ZE", "ZO", "DA", "DJI", "DZU", "DE", "DO", "BA", "BI",
                "BU", "BE", "BO", "PA", "PI", "PU", "PE", "PO", "KYA", "KYU", "KYO", "SHA", "SHU", "SHO", "CHA", "CHU", "CHO", "NYA", "NYU", "NYO", "HYA", "HYU", "HYO", "MYA",
                "MYU", "MYO", "RYA", "RYU", "RYO", "GYA", "GYU", "GYO", "JA", "JU", "JO", "BYA", "BYU", "BYO", "PYA", "PYU", "PYO"};

        for (int i = 0; i < katakanaList.length; i++) {
            Katakana katakana = new Katakana(katakanaList[i], katakanaListRomaji[i]);
            katakana.save();
        }
    }

    public void hiragana_fill_database() {
        String hiraganaList[] = {"あ", "い", "う", "え", "お", "か", "き", "く", "け", "こ", "さ", "し", "す", "せ", "そ", "た", "ち", "つ", "て", "と", "な", "に", "ぬ",
                "ね", "の", "は", "ひ", "ふ", "へ", "ほ", "ま", "み", "む", "め", "も", "や", "ゆ", "よ", "ら", "り", "る", "れ", "ろ", "わ", "を", "ん", "が", "ぎ", "ぐ", "げ", "ご", "ざ", "じ", "ず", "ぜ", "ぞ", "だ", "ぢ", "づ", "で", "ど", "ば", "び",
                "ぶ", "べ", "ぼ", "ぱ", "ぴ", "ぷ", "ぺ", "ぽ", "きゃ", "きゅ", "きょ", "しゃ", "しゅ", "しょ", "ちゃ", "ちゅ", "ちょ", "にゃ", "にゅ", "にょ", "ひゃ", "ひゅ", "ひょ", "みゃ",
                "みゅ", "みょ", "りゃ", "りゅ", "りょ", "ぎゃ", "ぎゅ", "ぎょ", "じゃ", "じゅ", "じょ", "びゃ", "びゅ", "びょ", "ぴゃ", "ぴゅ", "ぴょ"};

        String hiraganaListRomaji[] = {"A", "I", "U", "E", "O", "KA", "KI", "KU", "KE", "KO", "SA", "SHI", "SU", "SE", "SO", "TA", "CHI", "TSU", "TE", "TO",
                "NA", "NI", "NU", "NE", "NO", "HA", "HI", "FU", "HE", "HO", "MA", "MI", "MU", "ME", "MO", "YA", "YU", "YO", "RA", "RI", "RU", "RE", "RO", "WA", "WO", "N", "GA", "GI", "GU", "GE", "GO", "ZA", "JI", "ZU", "ZE", "ZO", "DA", "DJI", "DZU", "DE", "DO", "BA", "BI",
                "BU", "BE", "BO", "PA", "PI", "PU", "PE", "PO", "KYA", "KYU", "KYO", "SHA", "SHU", "SHO", "CHA", "CHU", "CHO", "NYA", "NYU", "NYO", "HYA", "HYU", "HYO", "MYA",
                "MYU", "MYO", "RYA", "RYU", "RYO", "GYA", "GYU", "GYO", "JA", "JU", "JO", "BYA", "BYU", "BYO", "PYA", "PYU", "PYO"};

        for (int i = 0; i < hiraganaList.length; i++) {
            Hiragana hiragana = new Hiragana(hiraganaList[i], hiraganaListRomaji[i]);
            hiragana.save();
        }
    }
}
