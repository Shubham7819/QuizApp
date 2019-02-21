package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * This app displays a list of questions on animal quiz.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when submit button is clicked.
     */
    public void calculateScore(View view) {
        int score = 0;

        //check whether lion radio button is checked
        //add 2 in score if checked
        RadioButton lionRadioButton = (RadioButton) findViewById(R.id.lion_radio_button);
        if (lionRadioButton.isChecked()) {
            score += 2;
        }

        //check if banana radio button is checked or not
        RadioButton bananaRadioButton = (RadioButton) findViewById(R.id.banana_radio_button);
        if (bananaRadioButton.isChecked()) {
            score += 2;
        }

        //check that only petAnimalCheckBox and wildAnimalCheckBox is checked
        CheckBox childAnimalsCheckBox = (CheckBox) findViewById(R.id.child_animals_checkbox);
        CheckBox petAnimalsCheckBox = (CheckBox) findViewById(R.id.pet_animals_checkbox);
        CheckBox wildAnimalsCheckBox = (CheckBox) findViewById(R.id.wild_animals_checkbox);
        if (petAnimalsCheckBox.isChecked() && wildAnimalsCheckBox.isChecked() ) {
            if ( ! (childAnimalsCheckBox.isChecked()) )
            score += 2;
        }

        //to check firstChoiceCheckBox, secondChoiceCheckBox and thirdChoiceCheckBox
        //are checked, add 2 in score if checked.
        CheckBox firstChoiceCheckBox = (CheckBox) findViewById(R.id.first_choice_checkbox);
        CheckBox secondChoiceCheckBox = (CheckBox) findViewById(R.id.second_choice_checkbox);
        CheckBox thirdChoiceCheckBox = (CheckBox) findViewById(R.id.third_choice_checkbox);
        if (firstChoiceCheckBox.isChecked() && secondChoiceCheckBox.isChecked() &&
                thirdChoiceCheckBox.isChecked()) {
            score += 2;
        }

        //get answer for question 5 in EditText and compare with answer.
        EditText editText = (EditText) findViewById(R.id.answer_field);
        String answer = editText.getText().toString();
        if ("pig".equals(answer)) {
            score += 2;
        }

        String scoreMsg = getString(R.string.score_message_1) + score +
                getString(R.string.score_message_2);

        //show score of user in toast message.
        if (score >= 8) {
            Toast.makeText(this, scoreMsg + getString(R.string.genius_message), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, scoreMsg + getString(R.string.try_again_message), Toast.LENGTH_SHORT).show();
        }

    }
}
