package com.codanimex.android.allkana.database;

import android.media.MediaPlayer;

import com.orm.SugarRecord;


public class Katakana extends SugarRecord {
    String katakana;
    String katakanaRomaji;
    MediaPlayer katakanaSound;

    public Katakana() {
    }

    public Katakana(String katakana, String katakanaRomaji, MediaPlayer katakanaSound) {
        this.katakana = katakana;
        this.katakanaRomaji = katakanaRomaji;
        this.katakanaSound = katakanaSound;
    }
}