package com.codanimex.android.allkana.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.codanimex.android.allkana.R;

public class QuizResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana_quiz_results);
        Bundle bundle = getIntent().getExtras();
        TextView correctText = (TextView) findViewById(R.id.correctResult);
        TextView incorrectText = (TextView) findViewById(R.id.incorrectResult);
        correctText.setText(bundle.getString("Correct"));
        incorrectText.setText(bundle.getString("Incorrect"));
    }
}
