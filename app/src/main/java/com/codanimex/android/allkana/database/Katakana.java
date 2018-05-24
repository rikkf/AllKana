package com.codanimex.android.allkana.database;

import com.orm.SugarRecord;


public class Katakana extends SugarRecord {
    public String katakana;
    public String katakanaRomaji;

    public Katakana() {
    }

    public Katakana(String katakana, String katakanaRomaji) {
        this.katakana = katakana;
        this.katakanaRomaji = katakanaRomaji;
    }
}