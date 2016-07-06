package com.example.android.androidquizapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkAnswers(View view) {
        correctAnswers = 0;
        boolean perfect;

        checkAnswerOne();
        checkAnswerTwo();
        checkAnswerThree();
        checkAnswerFour();
        checkAnswerFive();

        if (correctAnswers == 5) {
            perfect = true;
            toastMaker(perfect);
        } else {
            perfect = false;
            toastMaker(perfect);
        }
    }

    private void toastMaker(boolean perfect) {
        Context context = getApplicationContext();
        CharSequence text;
        int duration = Toast.LENGTH_SHORT;

        if (perfect) {
            text = "You've managed to correctly answer all questions! Congratulations!";
        } else {
            text = "Sorry, some of your answers are wrong!";
        }

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void checkAnswerOne() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.question_one_answers);
        TextView question = (TextView) findViewById(R.id.question_one);
        int answerId = radioGroup.getCheckedRadioButtonId();

        if (answerId == R.id.question_one_correct_answer) {
            correctAnswers += 1;
            question.setTextColor(Color.parseColor("#303F9F"));
        } else {
            question.setTextColor(Color.parseColor("#FF4081"));
        }
    }

    private void checkAnswerTwo() {
        TextView question = (TextView) findViewById(R.id.question_two);

        CheckBox lollipopCheckbox = (CheckBox) findViewById(R.id.question_two_lollipop);
        CheckBox fruitcakeCheckbox = (CheckBox) findViewById(R.id.question_two_fruitcake);
        CheckBox donutCheckbox = (CheckBox) findViewById(R.id.question_two_donut);
        CheckBox eclairCheckbox = (CheckBox) findViewById(R.id.question_two_eclair);

        boolean hasLollipop = lollipopCheckbox.isChecked();
        boolean hasFruitcake = fruitcakeCheckbox.isChecked();
        boolean hasDonut = donutCheckbox.isChecked();
        boolean hasEclair = eclairCheckbox.isChecked();

        if (hasLollipop && !hasFruitcake && hasDonut && hasEclair) {
            correctAnswers += 1;
            question.setTextColor(Color.parseColor("#303F9F"));
        } else {
            question.setTextColor(Color.parseColor("#FF4081"));
        }
    }

    private void checkAnswerThree() {
        TextView question = (TextView) findViewById(R.id.question_three);

        EditText answerThree = (EditText) findViewById(R.id.question_three_answer);
        String answer = answerThree.getText().toString();

        Log.v("MainActivity", "Answer: " + answer);

        if (answer.equals("Marshmallow")) {
            correctAnswers += 1;
            question.setTextColor(Color.parseColor("#303F9F"));
        } else {
            question.setTextColor(Color.parseColor("#FF4081"));

        }
    }

    private void checkAnswerFour() {
        TextView question = (TextView) findViewById(R.id.question_four);

        EditText answerThree = (EditText) findViewById(R.id.question_four_answer);
        String answer = answerThree.getText().toString();

        if (answer.equals("2009")) {
            correctAnswers += 1;
            question.setTextColor(Color.parseColor("#303F9F"));
        } else {
            question.setTextColor(Color.parseColor("#FF4081"));
        }
    }

    private void checkAnswerFive() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.question_five_answers);
        TextView question = (TextView) findViewById(R.id.question_five);
        int answerId = radioGroup.getCheckedRadioButtonId();

        if (answerId == R.id.question_five_correct_answer) {
            correctAnswers += 1;
            question.setTextColor(Color.parseColor("#303F9F"));
        } else {
            question.setTextColor(Color.parseColor("#FF4081"));
        }
    }
}
