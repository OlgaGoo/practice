package com.olgagoo.debug.homework.homework_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.olgagoo.debug.homework.R;
import com.olgagoo.debug.homework.homework.LessonOneActivity;
import com.olgagoo.debug.homework.homework_3.LessonThreeActivity;
import com.olgagoo.debug.homework.homework_4.OwlActivity;

public class StartActivity extends AppCompatActivity {
    Button hwOne;
    Button hwTwo;
    Button hwThree;
    Button hwFour;
    View.OnClickListener hwOneClk;
    View.OnClickListener hwTwoClk;
    View.OnClickListener hwThreeClk;
    View.OnClickListener hwFourClk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        hwOne = (Button) findViewById(R.id.menu_btn1);
        hwTwo = (Button) findViewById(R.id.menu_btn2);
        hwThree = (Button) findViewById(R.id.menu_btn3);
        hwFour = (Button) findViewById(R.id.menu_btn4);

        final Intent lessonOneActivity = new Intent(this,LessonOneActivity.class);
        final Intent lessonTwoActivity = new Intent(this,LessonTwoActivity.class);
        final Intent lessonThreeActivity = new Intent(this,LessonThreeActivity.class);
        final Intent lessonFourActivity = new Intent(this,OwlActivity.class);

        hwOneClk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(lessonOneActivity);
            }
        };

        hwTwoClk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(lessonTwoActivity);
            }
        };

        hwThreeClk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(lessonThreeActivity);
            }
        };

        hwFourClk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(lessonFourActivity);
            }
        };

        hwOne.setOnClickListener(hwOneClk);
        hwTwo.setOnClickListener(hwTwoClk);
        hwThree.setOnClickListener(hwThreeClk);
        hwFour.setOnClickListener(hwFourClk);

    }
}

