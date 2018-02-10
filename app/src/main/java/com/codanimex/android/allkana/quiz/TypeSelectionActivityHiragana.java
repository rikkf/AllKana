package com.codanimex.android.allkana.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import com.codanimex.android.allkana.R;

public class TypeSelectionActivityHiragana extends AppCompatActivity {

    static RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_selection_hiragana);
    }

    public void onGoClicked(View view) {
        Intent intent = new Intent(this, HiraganaQuiz.class);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupHiragana);
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.hb:
                intent.putExtra("typeOfQuiz", "hb");
                break;
            case R.id.Hiraganahd:
                intent.putExtra("typeOfQuiz", "hiraganahd");
                break;
            case R.id.HiraganaCombo:
                intent.putExtra("typeOfQuiz", "hiraganacombo");
                break;
            case R.id.HiraganaAll:
                intent.putExtra("typeOfQuiz", "hiraganaall");
                break;
        }
        startActivity(intent);
    }
}
