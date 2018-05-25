package com.codanimex.android.allkana.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.codanimex.android.allkana.MainActivity;
import com.codanimex.android.allkana.R;

public class ShowResultKatakana extends AppCompatActivity {

    Intent intent;
    int okAnswers;
    int wrongAnswers;
    TextView okAnswersView, wrongAnswersView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result_katakana);
        intent = getIntent();
        okAnswers = intent.getIntExtra("okAnswers", 0);
        wrongAnswers = intent.getIntExtra("wrongAnswers", 0);

        okAnswersView = findViewById(R.id.okResult);
        wrongAnswersView = findViewById(R.id.wrongResult);

        okAnswersView.setText(String.valueOf(okAnswers));
        wrongAnswersView.setText(String.valueOf(wrongAnswers));
    }

    public void onBackHomeClicked(View view) {
        Intent backToHomeIntent = new Intent(this, MainActivity.class);
        startActivity(backToHomeIntent);
    }
}
