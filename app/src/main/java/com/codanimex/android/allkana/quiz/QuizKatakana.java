package com.codanimex.android.allkana.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.codanimex.android.allkana.R;
import com.codanimex.android.allkana.database.Katakana;

import java.util.List;
import java.util.Random;

public class QuizKatakana extends AppCompatActivity {

    static int answerCount = 0;
    static int okCount = 0;
    static int wrongCount = 0;
    List<Katakana> katakanaListArray;
    KatakanaElement katakanaAnswerArray[];
    TextView questionView;
    TextView okAnswers;
    TextView wrongAnswers;
    EditText answerEdit;

    public static KatakanaElement[] randomizeArray(KatakanaElement[] array) {
        Random rgen = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            KatakanaElement temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }
        return array;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_katakana);
        arrayAnswerFiller();
        katakanaAnswerArray = randomizeArray(katakanaAnswerArray);
        questionView = (TextView) findViewById(R.id.katakanaQuestion);
        questionView.setText(katakanaAnswerArray[answerCount].getKatakanaKana());
    }

    public void arrayAnswerFiller() {
        katakanaListArray = Katakana.listAll(Katakana.class);
        katakanaAnswerArray = new KatakanaElement[katakanaListArray.size()];
        for (int i = 0; i < katakanaListArray.size(); i++) {
            katakanaAnswerArray[i] = new KatakanaElement();
        }
        for (int i = 0; i < katakanaListArray.size(); i++) {
            katakanaAnswerArray[i].setKatakanaKana(katakanaListArray.get(i).katakana);
            katakanaAnswerArray[i].setKatakanaRomaji(katakanaListArray.get(i).katakanaRomaji);
        }
    }

    public void onAnswerClicked(View view) {
        answerEdit = (EditText) findViewById(R.id.katakanaAnswer);
        questionView = (TextView) findViewById(R.id.katakanaQuestion);
        okAnswers = (TextView) findViewById(R.id.ok_answers);
        wrongAnswers = (TextView) findViewById(R.id.wrong_answers);
        String answer = answerEdit.getText().toString().toUpperCase();
        try {
            String questionKana = katakanaAnswerArray[answerCount].getKatakanaRomaji().toUpperCase();
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
            questionView.setText(katakanaAnswerArray[answerCount].getKatakanaKana());
        } catch (ArrayIndexOutOfBoundsException exception) {
            //passa ai risultati
        }
    }
}
