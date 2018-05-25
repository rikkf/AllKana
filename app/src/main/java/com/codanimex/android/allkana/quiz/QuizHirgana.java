package com.codanimex.android.allkana.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.codanimex.android.allkana.R;
import com.codanimex.android.allkana.database.Hiragana;

import java.util.List;
import java.util.Random;

public class QuizHirgana extends AppCompatActivity {

    static int answerCount = 0;
    static int okCount = 0;
    static int wrongCount = 0;
    List<Hiragana> hiraganaListArray;
    HiraganaElement hiraganaAnswerArray[];
    TextView questionView;
    TextView okAnswers;
    TextView wrongAnswers;
    EditText answerEdit;

    public static HiraganaElement[] randomizeArray(HiraganaElement[] array) {
        Random rgen = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            HiraganaElement temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }
        return array;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_hirgana);
        arrayAnswerFiller();
        hiraganaAnswerArray = randomizeArray(hiraganaAnswerArray);
        questionView = findViewById(R.id.hiraganaQuestion);
        questionView.setText(hiraganaAnswerArray[answerCount].getHiraganaKana());
    }

    public void arrayAnswerFiller() {
        hiraganaListArray = Hiragana.listAll(Hiragana.class);
        hiraganaAnswerArray = new HiraganaElement[hiraganaListArray.size()];
        for (int i = 0; i < hiraganaListArray.size(); i++) {
            hiraganaAnswerArray[i] = new HiraganaElement();
        }
        for (int i = 0; i < hiraganaListArray.size(); i++) {
            hiraganaAnswerArray[i].setHiraganaKana(hiraganaListArray.get(i).hiragana);
            hiraganaAnswerArray[i].setHiraganaRomaji(hiraganaListArray.get(i).hiraganaRomaji);
        }
    }

    public void onAnswerClicked(View view) {
        answerEdit = findViewById(R.id.hiraganaAnswer);
        questionView = findViewById(R.id.hiraganaQuestion);
        okAnswers = findViewById(R.id.ok_answers);
        wrongAnswers = findViewById(R.id.wrong_answers);
        String answer = answerEdit.getText().toString().toUpperCase();
        try {
            String questionKana = hiraganaAnswerArray[answerCount].getHiraganaRomaji().toUpperCase();
            if (answer.equals(questionKana)) {
                okCount++;
                answerCount++;
                okAnswers.setText(String.valueOf(okCount));
            } else {
                wrongCount++;
                answerCount++;
                wrongAnswers.setText(String.valueOf(wrongCount));
            }
            answerEdit.setText("");
            questionView.setText(hiraganaAnswerArray[answerCount].getHiraganaKana());
        } catch (ArrayIndexOutOfBoundsException exception) {
            Intent hiraganaResults = new Intent(this, ShowResultHiragana.class);
            hiraganaResults.putExtra("okAnswers", okCount);
            hiraganaResults.putExtra("wrongAnswers", wrongCount);
            startActivity(hiraganaResults);
        }
    }
}
