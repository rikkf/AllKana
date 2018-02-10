package com.codanimex.android.allkana.quiz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.codanimex.android.allkana.R;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;

public class HiraganaQuiz extends AppCompatActivity {

    static final ArrayList mSelectedItems = new ArrayList();

    static String hiraganaListBasics[] = {"あ", "い", "う", "え", "お", "か", "き", "く", "け", "こ", "さ", "し", "す", "せ", "そ", "た", "ち", "つ", "て", "と", "な", "に", "ぬ", "ね", "の", "は", "ひ", "ふ", "へ",
            "ほ", "ま", "み", "む", "め", "も", "や", "ゆ", "よ", "ら", "り", "る", "ろ", "わ", "を", "ん"};

    static String hiraganaListHD[] = {"が", "ぎ", "ぐ", "げ", "ご", "ざ", "じ", "ず", "ぜ", "ぞ", "だ", "ぢ", "づ", "で", "ど", "ば", "び", "ぶ", "べ", "ぼ", "ぱ", "ぴ", "ぷ", "ぺ", "ぽ"};

    static String hiraganaListCombo[] = {"きゃ", "きゅ", "きょ", "しゃ", "しゅ", "しょ", "ちゃ", "ちゅ", "ちょ", "にゃ", "にゅ", "にょ", "ひゃ", "ひゅ", "ひょ", "みゃ", "みゅ", "みょ",
            "りゃ", "りゅ", "りょ", "ぎゃ", "ぎゅ", "ぎょ", "じゃ", "じゅ", "じょ", "びゃ", "びゅ", "びゅ", "びょ", "ぴゃ", "ぴゅ", "ぴょ"};

    static String questionArray[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana_quiz);
        Bundle bundle = getIntent().getExtras();
        switch (bundle.getString("typeOfQuiz")) {
            case "hb":
                Toast t = Toast.makeText(this, "hb", Toast.LENGTH_LONG);
                t.show();
                break;
            case "hiraganahd":
                Toast e = Toast.makeText(this, "hd", Toast.LENGTH_LONG);
                e.show();
                break;
            case "hiraganacombo":
                Toast r = Toast.makeText(this, "combo", Toast.LENGTH_LONG);
                r.show();
                break;
            case "hiraganaall":
                Toast a = Toast.makeText(this, "all", Toast.LENGTH_LONG);
                a.show();
                break;
        }
    }
}


/*if(mSelectedItems.contains("0")) {
                           questionArray = new String[hiraganaListBasics.length];
                           questionArray = hiraganaListBasics;

                        } else {
                            if (mSelectedItems.contains("0") && mSelectedItems.contains("1")) {
                                int length= hiraganaListBasics.length+hiraganaListHD.length;
                                questionArray = new String[length];
                                questionArray = ArrayUtils.addAll(hiraganaListBasics, hiraganaListHD);
                            } else {
                                if (mSelectedItems.contains("1") && mSelectedItems.contains("2")) {
                                    int length= hiraganaListCombo.length+hiraganaListHD.length;
                                    questionArray = new String[length];
                                    questionArray = ArrayUtils.addAll(hiraganaListHD, hiraganaListCombo);
                                } else {
                                    if (mSelectedItems.contains("0") && mSelectedItems.contains("1") && mSelectedItems.contains("2")) {
                                        int length = hiraganaListBasics.length + hiraganaListCombo.length + hiraganaListHD.length;
                                        questionArray = new String[length];
                                        questionArray = ArrayUtils.addAll(hiraganaListBasics, hiraganaListHD);
                                        questionArray = ArrayUtils.addAll(questionArray, hiraganaListCombo);

                                    }

                                }
                            }
                        }*/