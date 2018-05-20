package com.codanimex.android.allkana;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
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
        hiraganaProgress = (ProgressBar) findViewById(R.id.hiraganaProgressBar);
        katakanaProgress = (ProgressBar) findViewById(R.id.katakanaProgressBar);
        percentageHiragana = (TextView) findViewById(R.id.percentage_hiragana_progress);
        percentageKatakana = (TextView) findViewById(R.id.percentage_katakana_progress);
        infoStatus = getSharedPreferences("com.codanimex.android.allkana", Context.MODE_WORLD_WRITEABLE);
        hiraganaProgress.setProgress(infoStatus.getInt("HiraganaStatus", 0));
        katakanaProgress.setProgress(infoStatus.getInt("KatakanaStatus", 0));
        percentageHiragana.setText(infoStatus.getInt("HiraganaStatus", 0) + "%");
        percentageKatakana.setText(infoStatus.getInt("KatakanaStatus", 0) + "%");
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
            Toast t = Toast.makeText(this, katakanaList.length + "KATA", Toast.LENGTH_LONG);

            MediaPlayer kanaSound = null;
            switch (katakanaListRomaji[i]) {
                case "a":
                    kanaSound = MediaPlayer.create(this, R.raw.a);
                    break;
                case "i":
                    kanaSound = MediaPlayer.create(this, R.raw.i);
                    break;
                case "u":
                    kanaSound = MediaPlayer.create(this, R.raw.u);
                    break;
                case "e":
                    kanaSound = MediaPlayer.create(this, R.raw.e);

                    break;
                case "o":
                    kanaSound = MediaPlayer.create(this, R.raw.o);

                    break;
                case "ka":
                    kanaSound = MediaPlayer.create(this, R.raw.ka);

                    break;
                case "ki":
                    kanaSound = MediaPlayer.create(this, R.raw.ki);

                    break;
                case "ku":
                    kanaSound = MediaPlayer.create(this, R.raw.ku);

                    break;
                case "ke":
                    kanaSound = MediaPlayer.create(this, R.raw.ke);

                    break;
                case "ko":
                    kanaSound = MediaPlayer.create(this, R.raw.ko);

                    break;
                case "ta":
                    kanaSound = MediaPlayer.create(this, R.raw.ta);

                    break;
                case "chi":
                    kanaSound = MediaPlayer.create(this, R.raw.chi);

                    break;
                case "tsu":
                    kanaSound = MediaPlayer.create(this, R.raw.tsu);

                    break;
                case "te":
                    kanaSound = MediaPlayer.create(this, R.raw.te);

                    break;
                case "to":
                    kanaSound = MediaPlayer.create(this, R.raw.to);

                    break;
                case "sa":
                    kanaSound = MediaPlayer.create(this, R.raw.sa);

                    break;
                case "shi":
                    kanaSound = MediaPlayer.create(this, R.raw.shi);

                    break;
                case "su":
                    kanaSound = MediaPlayer.create(this, R.raw.su);

                    break;
                case "se":
                    kanaSound = MediaPlayer.create(this, R.raw.se);

                    break;
                case "so":
                    kanaSound = MediaPlayer.create(this, R.raw.so);

                    break;
                case "na":
                    kanaSound = MediaPlayer.create(this, R.raw.na);

                    break;
                case "ni":
                    kanaSound = MediaPlayer.create(this, R.raw.ni);

                    break;
                case "nu":
                    kanaSound = MediaPlayer.create(this, R.raw.nu);

                    break;
                case "ne":
                    kanaSound = MediaPlayer.create(this, R.raw.ne);

                    break;
                case "no":
                    kanaSound = MediaPlayer.create(this, R.raw.no);

                    break;
                case "ma":
                    kanaSound = MediaPlayer.create(this, R.raw.ma);

                    break;
                case "mi":
                    kanaSound = MediaPlayer.create(this, R.raw.mi);

                    break;
                case "mu":
                    kanaSound = MediaPlayer.create(this, R.raw.mu);

                    break;
                case "me":
                    kanaSound = MediaPlayer.create(this, R.raw.me);

                    break;
                case "mo":
                    kanaSound = MediaPlayer.create(this, R.raw.mo);

                    break;
                case "ha":
                    kanaSound = MediaPlayer.create(this, R.raw.ha);

                    break;
                case "hi":
                    kanaSound = MediaPlayer.create(this, R.raw.hi);

                    break;
                case "fu":
                    kanaSound = MediaPlayer.create(this, R.raw.fu);

                    break;
                case "he":
                    kanaSound = MediaPlayer.create(this, R.raw.he);

                    break;
                case "ho":
                    kanaSound = MediaPlayer.create(this, R.raw.ho);

                    break;
                case "ra":
                    kanaSound = MediaPlayer.create(this, R.raw.ra);

                    break;
                case "ri":
                    kanaSound = MediaPlayer.create(this, R.raw.ri);

                    break;
                case "ru":
                    kanaSound = MediaPlayer.create(this, R.raw.ru);

                    break;
                case "re":
                    kanaSound = MediaPlayer.create(this, R.raw.re);

                    break;
                case "ro":
                    kanaSound = MediaPlayer.create(this, R.raw.ro);

                    break;
                case "wa":
                    kanaSound = MediaPlayer.create(this, R.raw.wa);

                    break;
                case "wo":
                    kanaSound = MediaPlayer.create(this, R.raw.wo);

                    break;
                case "ya":
                    kanaSound = MediaPlayer.create(this, R.raw.ya);

                    break;
                case "yu":
                    kanaSound = MediaPlayer.create(this, R.raw.yu);

                    break;
                case "yo":
                    kanaSound = MediaPlayer.create(this, R.raw.yo);

                    break;
                case "n":
                    kanaSound = MediaPlayer.create(this, R.raw.n);

                    break;
                case "ga":
                    kanaSound = MediaPlayer.create(this, R.raw.ga);

                    break;
                case "gi":
                    kanaSound = MediaPlayer.create(this, R.raw.gi);

                    break;
                case "gu":
                    kanaSound = MediaPlayer.create(this, R.raw.gu);

                    break;
                case "ge":
                    kanaSound = MediaPlayer.create(this, R.raw.ge);

                    break;
                case "go":
                    kanaSound = MediaPlayer.create(this, R.raw.go);

                    break;
                case "za":
                    kanaSound = MediaPlayer.create(this, R.raw.za);

                    break;
                case "ji":
                    kanaSound = MediaPlayer.create(this, R.raw.ji);

                    break;
                case "zu":
                    kanaSound = MediaPlayer.create(this, R.raw.zu);

                    break;
                case "ze":
                    kanaSound = MediaPlayer.create(this, R.raw.ze);

                    break;
                case "zo":
                    kanaSound = MediaPlayer.create(this, R.raw.zo);

                    break;
                case "da":
                    kanaSound = MediaPlayer.create(this, R.raw.da);

                    break;
                case "de":
                    kanaSound = MediaPlayer.create(this, R.raw.de);

                    break;
                case "do":
                    kanaSound = MediaPlayer.create(this, R.raw.doo);

                    break;
                case "ba":
                    kanaSound = MediaPlayer.create(this, R.raw.ba);

                    break;
                case "bi":
                    kanaSound = MediaPlayer.create(this, R.raw.bi);

                    break;
                case "bu":
                    kanaSound = MediaPlayer.create(this, R.raw.bu);

                    break;
                case "be":
                    kanaSound = MediaPlayer.create(this, R.raw.be);

                    break;
                case "bo":
                    kanaSound = MediaPlayer.create(this, R.raw.bo);

                    break;
                case "pa":
                    kanaSound = MediaPlayer.create(this, R.raw.pa);

                    break;
                case "pi":
                    kanaSound = MediaPlayer.create(this, R.raw.pi);

                    break;
                case "pu":
                    kanaSound = MediaPlayer.create(this, R.raw.pu);

                    break;
                case "pe":
                    kanaSound = MediaPlayer.create(this, R.raw.pe);

                    break;
                case "po":
                    kanaSound = MediaPlayer.create(this, R.raw.po);

                    break;
                case "kya":
                    kanaSound = MediaPlayer.create(this, R.raw.kya);

                    break;
                case "kyu":
                    kanaSound = MediaPlayer.create(this, R.raw.kyu);

                    break;
                case "kyo":
                    kanaSound = MediaPlayer.create(this, R.raw.kyo);

                    break;
                case "sha":
                    kanaSound = MediaPlayer.create(this, R.raw.sha);

                    break;
                case "shu":
                    kanaSound = MediaPlayer.create(this, R.raw.shu);

                    break;
                case "sho":
                    kanaSound = MediaPlayer.create(this, R.raw.sho);

                    break;
                case "cha":
                    kanaSound = MediaPlayer.create(this, R.raw.cha);

                    break;
                case "chu":
                    kanaSound = MediaPlayer.create(this, R.raw.chu);

                    break;
                case "cho":
                    kanaSound = MediaPlayer.create(this, R.raw.cho);

                    break;
                case "nya":
                    kanaSound = MediaPlayer.create(this, R.raw.nya);

                    break;
                case "nyu":
                    kanaSound = MediaPlayer.create(this, R.raw.nyu);

                    break;
                case "nyo":
                    kanaSound = MediaPlayer.create(this, R.raw.nyo);

                    break;
                case "mya":
                    kanaSound = MediaPlayer.create(this, R.raw.mya);

                    break;
                case "myu":
                    kanaSound = MediaPlayer.create(this, R.raw.myu);

                    break;
                case "myo":
                    kanaSound = MediaPlayer.create(this, R.raw.myo);

                    break;
                case "hya":
                    kanaSound = MediaPlayer.create(this, R.raw.hya);

                    break;
                case "hyu":
                    kanaSound = MediaPlayer.create(this, R.raw.hyu);

                    break;
                case "hyo":
                    kanaSound = MediaPlayer.create(this, R.raw.hyo);

                    break;
                case "rya":
                    kanaSound = MediaPlayer.create(this, R.raw.rya);

                    break;
                case "ryu":
                    kanaSound = MediaPlayer.create(this, R.raw.ryu);

                    break;
                case "ryo":
                    kanaSound = MediaPlayer.create(this, R.raw.ryo);

                    break;
                case "gya":
                    kanaSound = MediaPlayer.create(this, R.raw.gya);

                    break;
                case "gyu":
                    kanaSound = MediaPlayer.create(this, R.raw.gyu);

                    break;
                case "gyo":
                    kanaSound = MediaPlayer.create(this, R.raw.gyo);

                    break;
                case "ja":
                    kanaSound = MediaPlayer.create(this, R.raw.ja);

                    break;
                case "ju":
                    kanaSound = MediaPlayer.create(this, R.raw.ju);

                    break;
                case "jo":
                    kanaSound = MediaPlayer.create(this, R.raw.jo);

                    break;
                case "bya":
                    kanaSound = MediaPlayer.create(this, R.raw.bya);

                    break;
                case "byu":
                    kanaSound = MediaPlayer.create(this, R.raw.byu);

                    break;
                case "byo":
                    kanaSound = MediaPlayer.create(this, R.raw.byo);

                    break;
                case "pya":
                    kanaSound = MediaPlayer.create(this, R.raw.pya);

                    break;
                case "pyu":
                    kanaSound = MediaPlayer.create(this, R.raw.pyu);

                    break;
                case "pyo":
                    kanaSound = MediaPlayer.create(this, R.raw.pyo);

                    break;
            }
            Katakana katakana = new Katakana(katakanaList[i], katakanaListRomaji[i], kanaSound);
            katakana.save();
        }
    }

    public void hiragana_fill_database() {
        String hiraganaList[] = {"あ", "い", "う", "え", "お", "か", "き", "く", "け", "こ", "さ", "し", "す", "せ", "そ", "た", "ち", "つ", "て", "と", "な", "に", "ぬ",
                "ね", "の", "は", "ひ", "ふ", "へ", "ほ", "ま", "み", "む", "め", "も", "や", "ゆ", "よ", "ら", "り", "る", "ろ", "わ", "を", "ん", "が", "ぎ", "ぐ", "げ", "ご", "ざ", "じ", "ず", "ぜ", "ぞ", "だ", "ぢ", "づ", "で", "ど", "ば", "び",
                "ぶ", "べ", "ぼ", "ぱ", "ぴ", "ぷ", "ぺ", "ぽ", "きゃ", "きゅ", "きょ", "しゃ", "しゅ", "しょ", "ちゃ", "ちゅ", "ちょ", "にゃ", "にゅ", "にょ", "ひゃ", "ひゅ", "ひょ", "みゃ",
                "みゅ", "みょ", "りゃ", "りゅ", "りょ", "ぎゃ", "ぎゅ", "ぎょ", "じゃ", "じゅ", "じょ", "びゃ", "びゅ", "びゅ", "びょ", "ぴゃ", "ぴゅ", "ぴょ"};

        String hiraganaListRomaji[] = {"A", "I", "U", "E", "O", "KA", "KI", "KU", "KE", "KO", "SA", "SHI", "SU", "SE", "SO", "TA", "CHI", "TSU", "TE", "TO",
                "NA", "NI", "NU", "NE", "NO", "HA", "HI", "FU", "HE", "HO", "MA", "MI", "MU", "ME", "MO", "YA", "YU", "YO", "RA", "RI", "RU", "RE", "RO", "WA", "WO", "N", "GA", "GI", "GU", "GE", "GO", "ZA", "JI", "ZU", "ZE", "ZO", "DA", "DJI", "DZU", "DE", "DO", "BA", "BI",
                "BU", "BE", "BO", "PA", "PI", "PU", "PE", "PO", "KYA", "KYU", "KYO", "SHA", "SHU", "SHO", "CHA", "CHU", "CHO", "NYA", "NYU", "NYO", "HYA", "HYU", "HYO", "MYA",
                "MYU", "MYO", "RYA", "RYU", "RYO", "GYA", "GYU", "GYO", "JA", "JU", "JO", "BYA", "BYU", "BYO", "PYA", "PYU", "PYO"};

        for (int i = 0; i < hiraganaList.length; i++) {
            Toast t = Toast.makeText(this, hiraganaList.length + "HIRA", Toast.LENGTH_LONG);
            MediaPlayer kanaSound = null;
            switch (hiraganaListRomaji[i]) {
                case "a":
                    kanaSound = MediaPlayer.create(this, R.raw.a);

                    break;
                case "i":
                    kanaSound = MediaPlayer.create(this, R.raw.i);

                    break;
                case "u":
                    kanaSound = MediaPlayer.create(this, R.raw.u);

                    break;
                case "e":
                    kanaSound = MediaPlayer.create(this, R.raw.e);

                    break;
                case "o":
                    kanaSound = MediaPlayer.create(this, R.raw.o);

                    break;
                case "ka":
                    kanaSound = MediaPlayer.create(this, R.raw.ka);

                    break;
                case "ki":
                    kanaSound = MediaPlayer.create(this, R.raw.ki);

                    break;
                case "ku":
                    kanaSound = MediaPlayer.create(this, R.raw.ku);

                    break;
                case "ke":
                    kanaSound = MediaPlayer.create(this, R.raw.ke);

                    break;
                case "ko":
                    kanaSound = MediaPlayer.create(this, R.raw.ko);

                    break;
                case "ta":
                    kanaSound = MediaPlayer.create(this, R.raw.ta);

                    break;
                case "chi":
                    kanaSound = MediaPlayer.create(this, R.raw.chi);

                    break;
                case "tsu":
                    kanaSound = MediaPlayer.create(this, R.raw.tsu);

                    break;
                case "te":
                    kanaSound = MediaPlayer.create(this, R.raw.te);

                    break;
                case "to":
                    kanaSound = MediaPlayer.create(this, R.raw.to);

                    break;
                case "sa":
                    kanaSound = MediaPlayer.create(this, R.raw.sa);

                    break;
                case "shi":
                    kanaSound = MediaPlayer.create(this, R.raw.shi);

                    break;
                case "su":
                    kanaSound = MediaPlayer.create(this, R.raw.su);

                    break;
                case "se":
                    kanaSound = MediaPlayer.create(this, R.raw.se);

                    break;
                case "so":
                    kanaSound = MediaPlayer.create(this, R.raw.so);

                    break;
                case "na":
                    kanaSound = MediaPlayer.create(this, R.raw.na);

                    break;
                case "ni":
                    kanaSound = MediaPlayer.create(this, R.raw.ni);

                    break;
                case "nu":
                    kanaSound = MediaPlayer.create(this, R.raw.nu);

                    break;
                case "ne":
                    kanaSound = MediaPlayer.create(this, R.raw.ne);

                    break;
                case "no":
                    kanaSound = MediaPlayer.create(this, R.raw.no);

                    break;
                case "ma":
                    kanaSound = MediaPlayer.create(this, R.raw.ma);

                    break;
                case "mi":
                    kanaSound = MediaPlayer.create(this, R.raw.mi);

                    break;
                case "mu":
                    kanaSound = MediaPlayer.create(this, R.raw.mu);

                    break;
                case "me":
                    kanaSound = MediaPlayer.create(this, R.raw.me);

                    break;
                case "mo":
                    kanaSound = MediaPlayer.create(this, R.raw.mo);

                    break;
                case "ha":
                    kanaSound = MediaPlayer.create(this, R.raw.ha);

                    break;
                case "hi":
                    kanaSound = MediaPlayer.create(this, R.raw.hi);

                    break;
                case "fu":
                    kanaSound = MediaPlayer.create(this, R.raw.fu);

                    break;
                case "he":
                    kanaSound = MediaPlayer.create(this, R.raw.he);

                    break;
                case "ho":
                    kanaSound = MediaPlayer.create(this, R.raw.ho);

                    break;
                case "ra":
                    kanaSound = MediaPlayer.create(this, R.raw.ra);

                    break;
                case "ri":
                    kanaSound = MediaPlayer.create(this, R.raw.ri);

                    break;
                case "ru":
                    kanaSound = MediaPlayer.create(this, R.raw.ru);

                    break;
                case "re":
                    kanaSound = MediaPlayer.create(this, R.raw.re);

                    break;
                case "ro":
                    kanaSound = MediaPlayer.create(this, R.raw.ro);

                    break;
                case "wa":
                    kanaSound = MediaPlayer.create(this, R.raw.wa);

                    break;
                case "wo":
                    kanaSound = MediaPlayer.create(this, R.raw.wo);

                    break;
                case "ya":
                    kanaSound = MediaPlayer.create(this, R.raw.ya);

                    break;
                case "yu":
                    kanaSound = MediaPlayer.create(this, R.raw.yu);

                    break;
                case "yo":
                    kanaSound = MediaPlayer.create(this, R.raw.yo);

                    break;
                case "n":
                    kanaSound = MediaPlayer.create(this, R.raw.n);

                    break;
                case "ga":
                    kanaSound = MediaPlayer.create(this, R.raw.ga);

                    break;
                case "gi":
                    kanaSound = MediaPlayer.create(this, R.raw.gi);

                    break;
                case "gu":
                    kanaSound = MediaPlayer.create(this, R.raw.gu);

                    break;
                case "ge":
                    kanaSound = MediaPlayer.create(this, R.raw.ge);

                    break;
                case "go":
                    kanaSound = MediaPlayer.create(this, R.raw.go);

                    break;
                case "za":
                    kanaSound = MediaPlayer.create(this, R.raw.za);

                    break;
                case "ji":
                    kanaSound = MediaPlayer.create(this, R.raw.ji);

                    break;
                case "zu":
                    kanaSound = MediaPlayer.create(this, R.raw.zu);

                    break;
                case "ze":
                    kanaSound = MediaPlayer.create(this, R.raw.ze);

                    break;
                case "zo":
                    kanaSound = MediaPlayer.create(this, R.raw.zo);

                    break;
                case "da":
                    kanaSound = MediaPlayer.create(this, R.raw.da);

                    break;
                case "de":
                    kanaSound = MediaPlayer.create(this, R.raw.de);

                    break;
                case "do":
                    kanaSound = MediaPlayer.create(this, R.raw.doo);

                    break;
                case "ba":
                    kanaSound = MediaPlayer.create(this, R.raw.ba);

                    break;
                case "bi":
                    kanaSound = MediaPlayer.create(this, R.raw.bi);

                    break;
                case "bu":
                    kanaSound = MediaPlayer.create(this, R.raw.bu);

                    break;
                case "be":
                    kanaSound = MediaPlayer.create(this, R.raw.be);

                    break;
                case "bo":
                    kanaSound = MediaPlayer.create(this, R.raw.bo);

                    break;
                case "pa":
                    kanaSound = MediaPlayer.create(this, R.raw.pa);

                    break;
                case "pi":
                    kanaSound = MediaPlayer.create(this, R.raw.pi);

                    break;
                case "pu":
                    kanaSound = MediaPlayer.create(this, R.raw.pu);

                    break;
                case "pe":
                    kanaSound = MediaPlayer.create(this, R.raw.pe);

                    break;
                case "po":
                    kanaSound = MediaPlayer.create(this, R.raw.po);

                    break;
                case "kya":
                    kanaSound = MediaPlayer.create(this, R.raw.kya);

                    break;
                case "kyu":
                    kanaSound = MediaPlayer.create(this, R.raw.kyu);

                    break;
                case "kyo":
                    kanaSound = MediaPlayer.create(this, R.raw.kyo);

                    break;
                case "sha":
                    kanaSound = MediaPlayer.create(this, R.raw.sha);

                    break;
                case "shu":
                    kanaSound = MediaPlayer.create(this, R.raw.shu);

                    break;
                case "sho":
                    kanaSound = MediaPlayer.create(this, R.raw.sho);

                    break;
                case "cha":
                    kanaSound = MediaPlayer.create(this, R.raw.cha);

                    break;
                case "chu":
                    kanaSound = MediaPlayer.create(this, R.raw.chu);

                    break;
                case "cho":
                    kanaSound = MediaPlayer.create(this, R.raw.cho);

                    break;
                case "nya":
                    kanaSound = MediaPlayer.create(this, R.raw.nya);

                    break;
                case "nyu":
                    kanaSound = MediaPlayer.create(this, R.raw.nyu);

                    break;
                case "nyo":
                    kanaSound = MediaPlayer.create(this, R.raw.nyo);

                    break;
                case "mya":
                    kanaSound = MediaPlayer.create(this, R.raw.mya);

                    break;
                case "myu":
                    kanaSound = MediaPlayer.create(this, R.raw.myu);

                    break;
                case "myo":
                    kanaSound = MediaPlayer.create(this, R.raw.myo);

                    break;
                case "hya":
                    kanaSound = MediaPlayer.create(this, R.raw.hya);

                    break;
                case "hyu":
                    kanaSound = MediaPlayer.create(this, R.raw.hyu);

                    break;
                case "hyo":
                    kanaSound = MediaPlayer.create(this, R.raw.hyo);

                    break;
                case "rya":
                    kanaSound = MediaPlayer.create(this, R.raw.rya);

                    break;
                case "ryu":
                    kanaSound = MediaPlayer.create(this, R.raw.ryu);

                    break;
                case "ryo":
                    kanaSound = MediaPlayer.create(this, R.raw.ryo);

                    break;
                case "gya":
                    kanaSound = MediaPlayer.create(this, R.raw.gya);

                    break;
                case "gyu":
                    kanaSound = MediaPlayer.create(this, R.raw.gyu);

                    break;
                case "gyo":
                    kanaSound = MediaPlayer.create(this, R.raw.gyo);

                    break;
                case "ja":
                    kanaSound = MediaPlayer.create(this, R.raw.ja);

                    break;
                case "ju":
                    kanaSound = MediaPlayer.create(this, R.raw.ju);

                    break;
                case "jo":
                    kanaSound = MediaPlayer.create(this, R.raw.jo);

                    break;
                case "bya":
                    kanaSound = MediaPlayer.create(this, R.raw.bya);

                    break;
                case "byu":
                    kanaSound = MediaPlayer.create(this, R.raw.byu);

                    break;
                case "byo":
                    kanaSound = MediaPlayer.create(this, R.raw.byo);

                    break;
                case "pya":
                    kanaSound = MediaPlayer.create(this, R.raw.pya);

                    break;
                case "pyu":
                    kanaSound = MediaPlayer.create(this, R.raw.pyu);

                    break;
                case "pyo":
                    kanaSound = MediaPlayer.create(this, R.raw.pyo);

                    break;
            }

            Hiragana hiragana = new Hiragana(hiraganaList[i], hiraganaListRomaji[i], kanaSound);
            hiragana.save();
        }
    }
}
