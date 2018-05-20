package com.codanimex.android.allkana.database;

import android.media.MediaPlayer;

import com.orm.SugarRecord;


public class Hiragana extends SugarRecord {
    String hiragana;
    String hiraganaRomaji;
    MediaPlayer hiraganaSound;

    public Hiragana() {
    }

    public Hiragana(String hiragana, String hiraganaRomaji, MediaPlayer hiraganaSound) {
        this.hiragana = hiragana;
        this.hiraganaRomaji = hiraganaRomaji;
        this.hiraganaSound = hiraganaSound;
    }
}