package com.codanimex.android.allkana.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.codanimex.android.allkana.R;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HiraganaQuiz extends AppCompatActivity {

    static String hiraganaListBasics[] = {"あ", "い", "う", "え", "お", "か", "き", "く", "け", "こ", "さ", "し", "す", "せ", "そ", "た", "ち", "つ", "て", "と", "な", "に", "ぬ",
            "ね", "の", "は", "ひ", "ふ", "へ", "ほ", "ま", "み", "む", "め", "も", "や", "ゆ", "よ", "ら", "り", "る", "ろ", "わ", "を", "ん"};

    static String hiraganaListHD[] = {"が", "ぎ", "ぐ", "げ", "ご", "ざ", "じ", "ず", "ぜ", "ぞ", "だ", "ぢ", "づ", "で", "ど", "ば", "び",
            "ぶ", "べ", "ぼ", "ぱ", "ぴ", "ぷ", "ぺ", "ぽ"};

    static String hiraganaListCombo[] = {"きゃ", "きゅ", "きょ", "しゃ", "しゅ", "しょ", "ちゃ", "ちゅ", "ちょ", "にゃ", "にゅ", "にょ", "ひゃ", "ひゅ", "ひょ", "みゃ",
            "みゅ", "みょ", "りゃ", "りゅ", "りょ", "ぎゃ", "ぎゅ", "ぎょ", "じゃ", "じゅ", "じょ", "びゃ", "びゅ", "びゅ", "びょ", "ぴゃ", "ぴゅ", "ぴょ"};

    static String hiraganaListBasicsAnswer[] = {"A", "I", "U", "E", "O", "KA", "KI", "KU", "KE", "KO", "SA", "SHI", "SU", "SE", "SO", "TA", "CHI", "TSU", "TE", "TO",
            "NA", "NI", "NU", "NE", "NO", "HA", "HI", "FU", "HE", "HO", "MA", "MI", "MU", "ME", "MO", "YA", "YU", "YO", "RA", "RI", "RU", "RE", "RO", "WA", "WO", "N"};

    static String hiraganaListHDAnswer[] = {"GA", "GI", "GU", "GE", "GO", "ZA", "JI", "ZU", "ZE", "ZO", "DA", "DJI", "DZU", "DE", "DO", "BA", "BI",
            "BU", "BE", "BO", "PA", "PI", "PU", "PE", "PO"};

    static String hiraganaListComboAnswer[] = {"KYA", "KYU", "KYO", "SHA", "SHU", "SHO", "CHA", "CHU", "CHO", "NYA", "NYU", "NYO", "HYA", "HYU", "HYO", "MYA",
            "MYU", "MYO", "RYA", "RYU", "RYO", "GYA", "GYU", "GYO", "JA", "JU", "JO", "BYA", "BYU", "BYO", "PYA", "PYU", "PYO"};

    static String hiraganaQuestionArray[];

    static String hiraganaAnswerArray[];

    static TextView hiraganaAnswer;

    static List<Number> numbers;

    static int n;

    static Button hiraganaAnswerButton1;
    static Button hiraganaAnswerButton2;
    static Button hiraganaAnswerButton3;

    static int correctAnswerHiragana = 0;
    static int incorrectAnswerHiragana = 0;

    static TextView correctHiraganaText;
    static TextView incorrectHiraganaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana_quiz);
        Bundle bundle = getIntent().getExtras();
        numbers = new ArrayList<>();
        switch (bundle.getString("typeOfQuiz")) {
            case "hb":
                hiraganaQuestionArray = hiraganaListBasics.clone();
                hiraganaAnswerArray = hiraganaListBasicsAnswer.clone();
                for (int i = 0; i < hiraganaAnswerArray.length; i++) {
                    numbers.add(i);
                }
                break;
            case "hiraganahd":
                hiraganaQuestionArray = hiraganaListHD.clone();
                hiraganaAnswerArray = hiraganaListHDAnswer.clone();
                for (int i = 0; i < hiraganaAnswerArray.length; i++) {
                    numbers.add(i);
                }
                break;
            case "hiraganacombo":
                hiraganaQuestionArray = hiraganaListCombo.clone();
                hiraganaAnswerArray = hiraganaListComboAnswer.clone();
                for (int i = 0; i < hiraganaAnswerArray.length; i++) {
                    numbers.add(i);
                }
                break;
            case "hiraganaall":
                //TODO (2) : Correct All Array, 'cause it's not in order
                hiraganaQuestionArray = ArrayUtils.addAll(hiraganaListBasics, hiraganaListHD);
                hiraganaQuestionArray = ArrayUtils.addAll(hiraganaQuestionArray, hiraganaListCombo);
                hiraganaAnswerArray = ArrayUtils.addAll(hiraganaListBasicsAnswer, hiraganaListHDAnswer);
                hiraganaAnswerArray = ArrayUtils.addAll(hiraganaAnswerArray, hiraganaListComboAnswer);
                for (int i = 0; i < hiraganaAnswerArray.length; i++) {
                    numbers.add(i);
                }
                break;
        }
        answerGeneratorHiragana();
    }

    public void answerGeneratorHiragana() {
        try {
            hiraganaAnswer = (TextView) findViewById(R.id.hiraganaAnswer);
            Random rand = new Random();

            n = rand.nextInt(numbers.size());

            List<String> correctAnswerList = new ArrayList<>();
            correctAnswerList.add(hiraganaAnswerArray[numbers.get(n).intValue()]);
            correctAnswerList.add(hiraganaAnswerArray[rand.nextInt(hiraganaAnswerArray.length)]);
            correctAnswerList.add(hiraganaAnswerArray[rand.nextInt(hiraganaAnswerArray.length - 1) + 1]);

            Collections.shuffle(correctAnswerList);

            hiraganaAnswerButton1 = (Button) findViewById(R.id.hiraganaOneButton);
            hiraganaAnswerButton2 = (Button) findViewById(R.id.hiraganaTwoButton);
            hiraganaAnswerButton3 = (Button) findViewById(R.id.hiraganaThreeButton);

            if (correctAnswerList.get(0).equals(hiraganaAnswerArray[numbers.get(n).intValue()])) {
                hiraganaAnswerButton1.setContentDescription("True");
                hiraganaAnswerButton2.setContentDescription("False");
                hiraganaAnswerButton3.setContentDescription("False");
            } else {
                if (correctAnswerList.get(1).equals(hiraganaAnswerArray[numbers.get(n).intValue()])) {
                    hiraganaAnswerButton1.setContentDescription("False");
                    hiraganaAnswerButton2.setContentDescription("True");
                    hiraganaAnswerButton3.setContentDescription("False");
                } else {
                    hiraganaAnswerButton1.setContentDescription("False");
                    hiraganaAnswerButton2.setContentDescription("False");
                    hiraganaAnswerButton3.setContentDescription("True");
                }
            }

            hiraganaAnswerButton1.setText(correctAnswerList.get(0));
            hiraganaAnswerButton2.setText(correctAnswerList.get(1));
            hiraganaAnswerButton3.setText(correctAnswerList.get(2));


            hiraganaAnswer.setText(hiraganaQuestionArray[numbers.get(n).intValue()]);
            numbers.remove(n);
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    // TODO (1) : Correct Basics quiz
    public void onAnswerClicked(View view) {
        Button buttonClicked = (Button) findViewById(view.getId());
        Intent resultIntent = new Intent(this, QuizResults.class);
        try {
            if (numbers.size() == 1 && hiraganaAnswerArray.length == 46) {
                Toast c = Toast.makeText(this, "FINE1", Toast.LENGTH_SHORT);
                c.show();
                if (buttonClicked.getContentDescription().equals("True")) {
                    correctAnswerHiragana++;
                    correctHiraganaText = (TextView) findViewById(R.id.correctAnswerHiragana);
                    correctHiraganaText.setText(String.valueOf(correctAnswerHiragana));
                    Toast e = Toast.makeText(this, "Giusto", Toast.LENGTH_SHORT);
                    e.show();
                } else {
                    incorrectAnswerHiragana++;
                    incorrectHiraganaText = (TextView) findViewById(R.id.incorrectAnswerHiragana);
                    incorrectHiraganaText.setText(String.valueOf(incorrectAnswerHiragana));
                    Toast d = Toast.makeText(this, "Sbagliato", Toast.LENGTH_SHORT);
                    d.show();
                }
                resultIntent.putExtra("Correct", String.valueOf(correctAnswerHiragana));
                resultIntent.putExtra("Incorrect", String.valueOf(incorrectAnswerHiragana));
                correctAnswerHiragana = 0;
                incorrectAnswerHiragana = 0;
                startActivity(resultIntent);
                finish();
            } else {
                if (numbers.size() == 0) {
                    if (buttonClicked.getContentDescription().equals("True")) {
                        correctAnswerHiragana++;
                        correctHiraganaText = (TextView) findViewById(R.id.correctAnswerHiragana);
                        correctHiraganaText.setText(String.valueOf(correctAnswerHiragana));
                        Toast c = Toast.makeText(this, "Giusto", Toast.LENGTH_SHORT);
                        c.show();
                    } else {
                        incorrectAnswerHiragana++;
                        incorrectHiraganaText = (TextView) findViewById(R.id.incorrectAnswerHiragana);
                        incorrectHiraganaText.setText(String.valueOf(incorrectAnswerHiragana));
                        Toast c = Toast.makeText(this, "Sbagliato", Toast.LENGTH_SHORT);
                        c.show();
                    }
                    resultIntent.putExtra("Correct", String.valueOf(correctAnswerHiragana));
                    resultIntent.putExtra("Incorrect", String.valueOf(incorrectAnswerHiragana));
                    correctAnswerHiragana = 0;
                    incorrectAnswerHiragana = 0;
                    startActivity(resultIntent);
                    finish();
                } else {
                    if (buttonClicked.getContentDescription().equals("True")) {
                        correctAnswerHiragana++;
                        correctHiraganaText = (TextView) findViewById(R.id.correctAnswerHiragana);
                        correctHiraganaText.setText(String.valueOf(correctAnswerHiragana));
                        Toast c = Toast.makeText(this, "Giusto", Toast.LENGTH_SHORT);
                        c.show();
                        answerGeneratorHiragana();
                    } else {
                        incorrectAnswerHiragana++;
                        incorrectHiraganaText = (TextView) findViewById(R.id.incorrectAnswerHiragana);
                        incorrectHiraganaText.setText(String.valueOf(incorrectAnswerHiragana));
                        Toast c = Toast.makeText(this, "Sbagliato", Toast.LENGTH_SHORT);
                        c.show();
                        answerGeneratorHiragana();
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Toast c = Toast.makeText(this, "OPS", Toast.LENGTH_SHORT);
            c.show();
        }
    }
}