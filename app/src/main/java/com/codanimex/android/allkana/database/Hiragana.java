package com.codanimex.android.allkana.database;

import com.orm.SugarRecord;


public class Hiragana extends SugarRecord {
    public String hiragana;
    public String hiraganaRomaji;

    public Hiragana() {
    }

    public Hiragana(String hiragana, String hiraganaRomaji) {
        this.hiragana = hiragana;
        this.hiraganaRomaji = hiraganaRomaji;
    }
}