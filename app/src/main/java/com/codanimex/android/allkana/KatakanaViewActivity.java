package com.codanimex.android.allkana;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class KatakanaViewActivity extends AppCompatActivity {

    TextView romajiKana;
    TextView katakanaKana;
    String katakanaTitle;
    String romajiTitle;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katakana_view);
        intent = getIntent();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        katakanaTitle = intent.getStringExtra("katakana_title");
        romajiTitle = intent.getStringExtra("romaji_title");
        romajiKana = (TextView) findViewById(R.id.romaji_dialog_title);
        katakanaKana = (TextView) findViewById(R.id.katakana_dialog_title);
        katakanaKana.setText(katakanaTitle);
        romajiKana.setText(romajiTitle);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onPlayButtonClicked(View view) {
        MediaPlayer kanaSound;
        switch (romajiTitle) {
            case "a":
                kanaSound = MediaPlayer.create(this, R.raw.a);
                kanaSound.start();
                break;
            case "i":
                kanaSound = MediaPlayer.create(this, R.raw.i);
                kanaSound.start();
                break;
            case "u":
                kanaSound = MediaPlayer.create(this, R.raw.u);
                kanaSound.start();
                break;
            case "e":
                kanaSound = MediaPlayer.create(this, R.raw.e);
                kanaSound.start();
                break;
            case "o":
                kanaSound = MediaPlayer.create(this, R.raw.o);
                kanaSound.start();
                break;
            case "ka":
                kanaSound = MediaPlayer.create(this, R.raw.ka);
                kanaSound.start();
                break;
            case "ki":
                kanaSound = MediaPlayer.create(this, R.raw.ki);
                kanaSound.start();
                break;
            case "ku":
                kanaSound = MediaPlayer.create(this, R.raw.ku);
                kanaSound.start();
                break;
            case "ke":
                kanaSound = MediaPlayer.create(this, R.raw.ke);
                kanaSound.start();
                break;
            case "ko":
                kanaSound = MediaPlayer.create(this, R.raw.ko);
                kanaSound.start();
                break;
            case "ta":
                kanaSound = MediaPlayer.create(this, R.raw.ta);
                kanaSound.start();
                break;
            case "chi":
                kanaSound = MediaPlayer.create(this, R.raw.chi);
                kanaSound.start();
                break;
            case "tsu":
                kanaSound = MediaPlayer.create(this, R.raw.tsu);
                kanaSound.start();
                break;
            case "te":
                kanaSound = MediaPlayer.create(this, R.raw.te);
                kanaSound.start();
                break;
            case "to":
                kanaSound = MediaPlayer.create(this, R.raw.to);
                kanaSound.start();
                break;
            case "sa":
                kanaSound = MediaPlayer.create(this, R.raw.sa);
                kanaSound.start();
                break;
            case "shi":
                kanaSound = MediaPlayer.create(this, R.raw.shi);
                kanaSound.start();
                break;
            case "su":
                kanaSound = MediaPlayer.create(this, R.raw.su);
                kanaSound.start();
                break;
            case "se":
                kanaSound = MediaPlayer.create(this, R.raw.se);
                kanaSound.start();
                break;
            case "so":
                kanaSound = MediaPlayer.create(this, R.raw.so);
                kanaSound.start();
                break;
            case "na":
                kanaSound = MediaPlayer.create(this, R.raw.na);
                kanaSound.start();
                break;
            case "ni":
                kanaSound = MediaPlayer.create(this, R.raw.ni);
                kanaSound.start();
                break;
            case "nu":
                kanaSound = MediaPlayer.create(this, R.raw.nu);
                kanaSound.start();
                break;
            case "ne":
                kanaSound = MediaPlayer.create(this, R.raw.ne);
                kanaSound.start();
                break;
            case "no":
                kanaSound = MediaPlayer.create(this, R.raw.no);
                kanaSound.start();
                break;
            case "ma":
                kanaSound = MediaPlayer.create(this, R.raw.ma);
                kanaSound.start();
                break;
            case "mi":
                kanaSound = MediaPlayer.create(this, R.raw.mi);
                kanaSound.start();
                break;
            case "mu":
                kanaSound = MediaPlayer.create(this, R.raw.mu);
                kanaSound.start();
                break;
            case "me":
                kanaSound = MediaPlayer.create(this, R.raw.me);
                kanaSound.start();
                break;
            case "mo":
                kanaSound = MediaPlayer.create(this, R.raw.mo);
                kanaSound.start();
                break;
            case "ha":
                kanaSound = MediaPlayer.create(this, R.raw.ha);
                kanaSound.start();
                break;
            case "hi":
                kanaSound = MediaPlayer.create(this, R.raw.hi);
                kanaSound.start();
                break;
            case "fu":
                kanaSound = MediaPlayer.create(this, R.raw.fu);
                kanaSound.start();
                break;
            case "he":
                kanaSound = MediaPlayer.create(this, R.raw.he);
                kanaSound.start();
                break;
            case "ho":
                kanaSound = MediaPlayer.create(this, R.raw.ho);
                kanaSound.start();
                break;
            case "ra":
                kanaSound = MediaPlayer.create(this, R.raw.ra);
                kanaSound.start();
                break;
            case "ri":
                kanaSound = MediaPlayer.create(this, R.raw.ri);
                kanaSound.start();
                break;
            case "ru":
                kanaSound = MediaPlayer.create(this, R.raw.ru);
                kanaSound.start();
                break;
            case "re":
                kanaSound = MediaPlayer.create(this, R.raw.re);
                kanaSound.start();
                break;
            case "ro":
                kanaSound = MediaPlayer.create(this, R.raw.ro);
                kanaSound.start();
                break;
            case "wa":
                kanaSound = MediaPlayer.create(this, R.raw.wa);
                kanaSound.start();
                break;
            case "wo":
                kanaSound = MediaPlayer.create(this, R.raw.wo);
                kanaSound.start();
                break;
            case "ya":
                kanaSound = MediaPlayer.create(this, R.raw.ya);
                kanaSound.start();
                break;
            case "yu":
                kanaSound = MediaPlayer.create(this, R.raw.yu);
                kanaSound.start();
                break;
            case "yo":
                kanaSound = MediaPlayer.create(this, R.raw.yo);
                kanaSound.start();
                break;
            case "n":
                kanaSound = MediaPlayer.create(this, R.raw.n);
                kanaSound.start();
                break;
            case "ga":
                kanaSound = MediaPlayer.create(this, R.raw.ga);
                kanaSound.start();
                break;
            case "gi":
                kanaSound = MediaPlayer.create(this, R.raw.gi);
                kanaSound.start();
                break;
            case "gu":
                kanaSound = MediaPlayer.create(this, R.raw.gu);
                kanaSound.start();
                break;
            case "ge":
                kanaSound = MediaPlayer.create(this, R.raw.ge);
                kanaSound.start();
                break;
            case "go":
                kanaSound = MediaPlayer.create(this, R.raw.go);
                kanaSound.start();
                break;
            case "za":
                kanaSound = MediaPlayer.create(this, R.raw.za);
                kanaSound.start();
                break;
            case "ji":
                kanaSound = MediaPlayer.create(this, R.raw.ji);
                kanaSound.start();
                break;
            case "zu":
                kanaSound = MediaPlayer.create(this, R.raw.zu);
                kanaSound.start();
                break;
            case "ze":
                kanaSound = MediaPlayer.create(this, R.raw.ze);
                kanaSound.start();
                break;
            case "zo":
                kanaSound = MediaPlayer.create(this, R.raw.zo);
                kanaSound.start();
                break;
            case "da":
                kanaSound = MediaPlayer.create(this, R.raw.da);
                kanaSound.start();
                break;
            case "de":
                kanaSound = MediaPlayer.create(this, R.raw.de);
                kanaSound.start();
                break;
            case "do":
                kanaSound = MediaPlayer.create(this, R.raw.doo);
                kanaSound.start();
                break;
            case "ba":
                kanaSound = MediaPlayer.create(this, R.raw.ba);
                kanaSound.start();
                break;
            case "bi":
                kanaSound = MediaPlayer.create(this, R.raw.bi);
                kanaSound.start();
                break;
            case "bu":
                kanaSound = MediaPlayer.create(this, R.raw.bu);
                kanaSound.start();
                break;
            case "be":
                kanaSound = MediaPlayer.create(this, R.raw.be);
                kanaSound.start();
                break;
            case "bo":
                kanaSound = MediaPlayer.create(this, R.raw.bo);
                kanaSound.start();
                break;
            case "pa":
                kanaSound = MediaPlayer.create(this, R.raw.pa);
                kanaSound.start();
                break;
            case "pi":
                kanaSound = MediaPlayer.create(this, R.raw.pi);
                kanaSound.start();
                break;
            case "pu":
                kanaSound = MediaPlayer.create(this, R.raw.pu);
                kanaSound.start();
                break;
            case "pe":
                kanaSound = MediaPlayer.create(this, R.raw.pe);
                kanaSound.start();
                break;
            case "po":
                kanaSound = MediaPlayer.create(this, R.raw.po);
                kanaSound.start();
                break;
            case "kya":
                kanaSound = MediaPlayer.create(this, R.raw.kya);
                kanaSound.start();
                break;
            case "kyu":
                kanaSound = MediaPlayer.create(this, R.raw.kyu);
                kanaSound.start();
                break;
            case "kyo":
                kanaSound = MediaPlayer.create(this, R.raw.kyo);
                kanaSound.start();
                break;
            case "sha":
                kanaSound = MediaPlayer.create(this, R.raw.sha);
                kanaSound.start();
                break;
            case "shu":
                kanaSound = MediaPlayer.create(this, R.raw.shu);
                kanaSound.start();
                break;
            case "sho":
                kanaSound = MediaPlayer.create(this, R.raw.sho);
                kanaSound.start();
                break;
            case "cha":
                kanaSound = MediaPlayer.create(this, R.raw.cha);
                kanaSound.start();
                break;
            case "chu":
                kanaSound = MediaPlayer.create(this, R.raw.chu);
                kanaSound.start();
                break;
            case "cho":
                kanaSound = MediaPlayer.create(this, R.raw.cho);
                kanaSound.start();
                break;
            case "nya":
                kanaSound = MediaPlayer.create(this, R.raw.nya);
                kanaSound.start();
                break;
            case "nyu":
                kanaSound = MediaPlayer.create(this, R.raw.nyu);
                kanaSound.start();
                break;
            case "nyo":
                kanaSound = MediaPlayer.create(this, R.raw.nyo);
                kanaSound.start();
                break;
            case "mya":
                kanaSound = MediaPlayer.create(this, R.raw.mya);
                kanaSound.start();
                break;
            case "myu":
                kanaSound = MediaPlayer.create(this, R.raw.myu);
                kanaSound.start();
                break;
            case "myo":
                kanaSound = MediaPlayer.create(this, R.raw.myo);
                kanaSound.start();
                break;
            case "hya":
                kanaSound = MediaPlayer.create(this, R.raw.hya);
                kanaSound.start();
                break;
            case "hyu":
                kanaSound = MediaPlayer.create(this, R.raw.hyu);
                kanaSound.start();
                break;
            case "hyo":
                kanaSound = MediaPlayer.create(this, R.raw.hyo);
                kanaSound.start();
                break;
            case "rya":
                kanaSound = MediaPlayer.create(this, R.raw.rya);
                kanaSound.start();
                break;
            case "ryu":
                kanaSound = MediaPlayer.create(this, R.raw.ryu);
                kanaSound.start();
                break;
            case "ryo":
                kanaSound = MediaPlayer.create(this, R.raw.ryo);
                kanaSound.start();
                break;
            case "gya":
                kanaSound = MediaPlayer.create(this, R.raw.gya);
                kanaSound.start();
                break;
            case "gyu":
                kanaSound = MediaPlayer.create(this, R.raw.gyu);
                kanaSound.start();
                break;
            case "gyo":
                kanaSound = MediaPlayer.create(this, R.raw.gyo);
                kanaSound.start();
                break;
            case "ja":
                kanaSound = MediaPlayer.create(this, R.raw.ja);
                kanaSound.start();
                break;
            case "ju":
                kanaSound = MediaPlayer.create(this, R.raw.ju);
                kanaSound.start();
                break;
            case "jo":
                kanaSound = MediaPlayer.create(this, R.raw.jo);
                kanaSound.start();
                break;
            case "bya":
                kanaSound = MediaPlayer.create(this, R.raw.bya);
                kanaSound.start();
                break;
            case "byu":
                kanaSound = MediaPlayer.create(this, R.raw.byu);
                kanaSound.start();
                break;
            case "byo":
                kanaSound = MediaPlayer.create(this, R.raw.byo);
                kanaSound.start();
                break;
            case "pya":
                kanaSound = MediaPlayer.create(this, R.raw.pya);
                kanaSound.start();
                break;
            case "pyu":
                kanaSound = MediaPlayer.create(this, R.raw.pyu);
                kanaSound.start();
                break;
            case "pyo":
                kanaSound = MediaPlayer.create(this, R.raw.pyo);
                kanaSound.start();
                break;
        }
    }
}
