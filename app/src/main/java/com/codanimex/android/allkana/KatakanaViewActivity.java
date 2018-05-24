package com.codanimex.android.allkana;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.codanimex.android.allkana.database.Katakana;

public class KatakanaViewActivity extends AppCompatActivity {

    TextView romajiKana;
    TextView katakanaKana;
    Katakana katakana;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katakana_view);
        intent = getIntent();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Long katakanaID = intent.getLongExtra("katakana_id", 0);
        katakana = Katakana.findById(Katakana.class, katakanaID);
        romajiKana = (TextView) findViewById(R.id.romaji_dialog_title);
        katakanaKana = (TextView) findViewById(R.id.katakana_dialog_title);
        katakanaKana.setText(katakana.katakana);
        romajiKana.setText(katakana.katakanaRomaji);
    }

    public void onPlayButtonClicked(View view) {
        MediaPlayer katakanaSound;
        switch (katakana.katakanaRomaji.toLowerCase()) {
            case "a":
                katakanaSound = MediaPlayer.create(this, R.raw.a);
                katakanaSound.start();
                break;
            case "i":
                katakanaSound = MediaPlayer.create(this, R.raw.i);
                katakanaSound.start();
                break;
            case "u":
                katakanaSound = MediaPlayer.create(this, R.raw.u);
                katakanaSound.start();
                break;
            case "e":
                katakanaSound = MediaPlayer.create(this, R.raw.e);
                katakanaSound.start();
                break;
            case "o":
                katakanaSound = MediaPlayer.create(this, R.raw.o);
                katakanaSound.start();
                break;
            case "ka":
                katakanaSound = MediaPlayer.create(this, R.raw.ka);
                katakanaSound.start();
                break;
            case "ki":
                katakanaSound = MediaPlayer.create(this, R.raw.ki);
                katakanaSound.start();
                break;
            case "ku":
                katakanaSound = MediaPlayer.create(this, R.raw.ku);
                katakanaSound.start();
                break;
            case "ke":
                katakanaSound = MediaPlayer.create(this, R.raw.ke);
                katakanaSound.start();
                break;
            case "ko":
                katakanaSound = MediaPlayer.create(this, R.raw.ko);
                katakanaSound.start();
                break;
            case "ta":
                katakanaSound = MediaPlayer.create(this, R.raw.ta);
                katakanaSound.start();
                break;
            case "chi":
                katakanaSound = MediaPlayer.create(this, R.raw.chi);
                katakanaSound.start();
                break;
            case "tsu":
                katakanaSound = MediaPlayer.create(this, R.raw.tsu);
                katakanaSound.start();
                break;
            case "te":
                katakanaSound = MediaPlayer.create(this, R.raw.te);
                katakanaSound.start();
                break;
            case "to":
                katakanaSound = MediaPlayer.create(this, R.raw.to);
                katakanaSound.start();
                break;
            case "sa":
                katakanaSound = MediaPlayer.create(this, R.raw.sa);
                katakanaSound.start();
                break;
            case "shi":
                katakanaSound = MediaPlayer.create(this, R.raw.shi);
                katakanaSound.start();
                break;
            case "su":
                katakanaSound = MediaPlayer.create(this, R.raw.su);
                katakanaSound.start();
                break;
            case "se":
                katakanaSound = MediaPlayer.create(this, R.raw.se);
                katakanaSound.start();
                break;
            case "so":
                katakanaSound = MediaPlayer.create(this, R.raw.so);
                katakanaSound.start();
                break;
            case "na":
                katakanaSound = MediaPlayer.create(this, R.raw.na);
                katakanaSound.start();
                break;
            case "ni":
                katakanaSound = MediaPlayer.create(this, R.raw.ni);
                katakanaSound.start();
                break;
            case "nu":
                katakanaSound = MediaPlayer.create(this, R.raw.nu);
                katakanaSound.start();
                break;
            case "ne":
                katakanaSound = MediaPlayer.create(this, R.raw.ne);
                katakanaSound.start();
                break;
            case "no":
                katakanaSound = MediaPlayer.create(this, R.raw.no);
                katakanaSound.start();
                break;
            case "ma":
                katakanaSound = MediaPlayer.create(this, R.raw.ma);
                katakanaSound.start();
                break;
            case "mi":
                katakanaSound = MediaPlayer.create(this, R.raw.mi);
                katakanaSound.start();
                break;
            case "mu":
                katakanaSound = MediaPlayer.create(this, R.raw.mu);
                katakanaSound.start();
                break;
            case "me":
                katakanaSound = MediaPlayer.create(this, R.raw.me);
                katakanaSound.start();
                break;
            case "mo":
                katakanaSound = MediaPlayer.create(this, R.raw.mo);
                katakanaSound.start();
                break;
            case "ha":
                katakanaSound = MediaPlayer.create(this, R.raw.ha);
                katakanaSound.start();
                break;
            case "hi":
                katakanaSound = MediaPlayer.create(this, R.raw.hi);
                katakanaSound.start();
                break;
            case "fu":
                katakanaSound = MediaPlayer.create(this, R.raw.fu);
                katakanaSound.start();
                break;
            case "he":
                katakanaSound = MediaPlayer.create(this, R.raw.he);
                katakanaSound.start();
                break;
            case "ho":
                katakanaSound = MediaPlayer.create(this, R.raw.ho);
                katakanaSound.start();
                break;
            case "ra":
                katakanaSound = MediaPlayer.create(this, R.raw.ra);
                katakanaSound.start();
                break;
            case "ri":
                katakanaSound = MediaPlayer.create(this, R.raw.ri);
                katakanaSound.start();
                break;
            case "ru":
                katakanaSound = MediaPlayer.create(this, R.raw.ru);
                katakanaSound.start();
                break;
            case "re":
                katakanaSound = MediaPlayer.create(this, R.raw.re);
                katakanaSound.start();
                break;
            case "ro":
                katakanaSound = MediaPlayer.create(this, R.raw.ro);
                katakanaSound.start();
                break;
            case "wa":
                katakanaSound = MediaPlayer.create(this, R.raw.wa);
                katakanaSound.start();
                break;
            case "wo":
                katakanaSound = MediaPlayer.create(this, R.raw.wo);
                katakanaSound.start();
                break;
            case "ya":
                katakanaSound = MediaPlayer.create(this, R.raw.ya);
                katakanaSound.start();
                break;
            case "yu":
                katakanaSound = MediaPlayer.create(this, R.raw.yu);
                katakanaSound.start();
                break;
            case "yo":
                katakanaSound = MediaPlayer.create(this, R.raw.yo);
                katakanaSound.start();
                break;
            case "n":
                katakanaSound = MediaPlayer.create(this, R.raw.n);
                katakanaSound.start();
                break;
            case "ga":
                katakanaSound = MediaPlayer.create(this, R.raw.ga);
                katakanaSound.start();
                break;
            case "gi":
                katakanaSound = MediaPlayer.create(this, R.raw.gi);
                katakanaSound.start();
                break;
            case "gu":
                katakanaSound = MediaPlayer.create(this, R.raw.gu);
                katakanaSound.start();
                break;
            case "ge":
                katakanaSound = MediaPlayer.create(this, R.raw.ge);
                katakanaSound.start();
                break;
            case "go":
                katakanaSound = MediaPlayer.create(this, R.raw.go);
                katakanaSound.start();
                break;
            case "za":
                katakanaSound = MediaPlayer.create(this, R.raw.za);
                katakanaSound.start();
                break;
            case "ji":
                katakanaSound = MediaPlayer.create(this, R.raw.ji);
                katakanaSound.start();
                break;
            case "zu":
                katakanaSound = MediaPlayer.create(this, R.raw.zu);
                katakanaSound.start();
                break;
            case "ze":
                katakanaSound = MediaPlayer.create(this, R.raw.ze);
                katakanaSound.start();
                break;
            case "zo":
                katakanaSound = MediaPlayer.create(this, R.raw.zo);
                katakanaSound.start();
                break;
            case "da":
                katakanaSound = MediaPlayer.create(this, R.raw.da);
                katakanaSound.start();
                break;
            case "de":
                katakanaSound = MediaPlayer.create(this, R.raw.de);
                katakanaSound.start();
                break;
            case "do":
                katakanaSound = MediaPlayer.create(this, R.raw.doo);
                katakanaSound.start();
                break;
            case "ba":
                katakanaSound = MediaPlayer.create(this, R.raw.ba);
                katakanaSound.start();
                break;
            case "bi":
                katakanaSound = MediaPlayer.create(this, R.raw.bi);
                katakanaSound.start();
                break;
            case "bu":
                katakanaSound = MediaPlayer.create(this, R.raw.bu);
                katakanaSound.start();
                break;
            case "be":
                katakanaSound = MediaPlayer.create(this, R.raw.be);
                katakanaSound.start();
                break;
            case "bo":
                katakanaSound = MediaPlayer.create(this, R.raw.bo);
                katakanaSound.start();
                break;
            case "pa":
                katakanaSound = MediaPlayer.create(this, R.raw.pa);
                katakanaSound.start();
                break;
            case "pi":
                katakanaSound = MediaPlayer.create(this, R.raw.pi);
                katakanaSound.start();
                break;
            case "pu":
                katakanaSound = MediaPlayer.create(this, R.raw.pu);
                katakanaSound.start();
                break;
            case "pe":
                katakanaSound = MediaPlayer.create(this, R.raw.pe);
                katakanaSound.start();
                break;
            case "po":
                katakanaSound = MediaPlayer.create(this, R.raw.po);
                katakanaSound.start();
                break;
            case "kya":
                katakanaSound = MediaPlayer.create(this, R.raw.kya);
                katakanaSound.start();
                break;
            case "kyu":
                katakanaSound = MediaPlayer.create(this, R.raw.kyu);
                katakanaSound.start();
                break;
            case "kyo":
                katakanaSound = MediaPlayer.create(this, R.raw.kyo);
                katakanaSound.start();
                break;
            case "sha":
                katakanaSound = MediaPlayer.create(this, R.raw.sha);
                katakanaSound.start();
                break;
            case "shu":
                katakanaSound = MediaPlayer.create(this, R.raw.shu);
                katakanaSound.start();
                break;
            case "sho":
                katakanaSound = MediaPlayer.create(this, R.raw.sho);
                katakanaSound.start();
                break;
            case "cha":
                katakanaSound = MediaPlayer.create(this, R.raw.cha);
                katakanaSound.start();
                break;
            case "chu":
                katakanaSound = MediaPlayer.create(this, R.raw.chu);
                katakanaSound.start();
                break;
            case "cho":
                katakanaSound = MediaPlayer.create(this, R.raw.cho);
                katakanaSound.start();
                break;
            case "nya":
                katakanaSound = MediaPlayer.create(this, R.raw.nya);
                katakanaSound.start();
                break;
            case "nyu":
                katakanaSound = MediaPlayer.create(this, R.raw.nyu);
                katakanaSound.start();
                break;
            case "nyo":
                katakanaSound = MediaPlayer.create(this, R.raw.nyo);
                katakanaSound.start();
                break;
            case "mya":
                katakanaSound = MediaPlayer.create(this, R.raw.mya);
                katakanaSound.start();
                break;
            case "myu":
                katakanaSound = MediaPlayer.create(this, R.raw.myu);
                katakanaSound.start();
                break;
            case "myo":
                katakanaSound = MediaPlayer.create(this, R.raw.myo);
                katakanaSound.start();
                break;
            case "hya":
                katakanaSound = MediaPlayer.create(this, R.raw.hya);
                katakanaSound.start();
                break;
            case "hyu":
                katakanaSound = MediaPlayer.create(this, R.raw.hyu);
                katakanaSound.start();
                break;
            case "hyo":
                katakanaSound = MediaPlayer.create(this, R.raw.hyo);
                katakanaSound.start();
                break;
            case "rya":
                katakanaSound = MediaPlayer.create(this, R.raw.rya);
                katakanaSound.start();
                break;
            case "ryu":
                katakanaSound = MediaPlayer.create(this, R.raw.ryu);
                katakanaSound.start();
                break;
            case "ryo":
                katakanaSound = MediaPlayer.create(this, R.raw.ryo);
                katakanaSound.start();
                break;
            case "gya":
                katakanaSound = MediaPlayer.create(this, R.raw.gya);
                katakanaSound.start();
                break;
            case "gyu":
                katakanaSound = MediaPlayer.create(this, R.raw.gyu);
                katakanaSound.start();
                break;
            case "gyo":
                katakanaSound = MediaPlayer.create(this, R.raw.gyo);
                katakanaSound.start();
                break;
            case "ja":
                katakanaSound = MediaPlayer.create(this, R.raw.ja);
                katakanaSound.start();
                break;
            case "ju":
                katakanaSound = MediaPlayer.create(this, R.raw.ju);
                katakanaSound.start();
                break;
            case "jo":
                katakanaSound = MediaPlayer.create(this, R.raw.jo);
                katakanaSound.start();
                break;
            case "bya":
                katakanaSound = MediaPlayer.create(this, R.raw.bya);
                katakanaSound.start();
                break;
            case "byu":
                katakanaSound = MediaPlayer.create(this, R.raw.byu);
                katakanaSound.start();
                break;
            case "byo":
                katakanaSound = MediaPlayer.create(this, R.raw.byo);
                katakanaSound.start();
                break;
            case "pya":
                katakanaSound = MediaPlayer.create(this, R.raw.pya);
                katakanaSound.start();
                break;
            case "pyu":
                katakanaSound = MediaPlayer.create(this, R.raw.pyu);
                katakanaSound.start();
                break;
            case "pyo":
                katakanaSound = MediaPlayer.create(this, R.raw.pyo);
                katakanaSound.start();
                break;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
