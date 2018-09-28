package com.olgagoo.debug.homework.homework_4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.olgagoo.debug.homework.R;

public class PieChartActivity extends AppCompatActivity {
    public static final String PIE_PART_1 = "PIE_PART_1";
    public static final String PIE_PART_2 = "PIE_PART_2";
    public static final String PIE_PART_3 = "PIE_PART_3";
    PieChartDrawer pie;

    public static void showPie(Activity activity, int userpiePart1, int userpiePart2, int userpiePart3){

        Intent intent = new Intent(activity,PieChartActivity.class);

        intent.putExtra(PIE_PART_1, userpiePart1);
        intent.putExtra(PIE_PART_2, userpiePart2);
        intent.putExtra(PIE_PART_3, userpiePart3);

        activity.startActivity(intent);
        // activity.overridePendingTransition(R.anim.ischezaet,R.anim.poyavlyaetsya); // when start
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        Intent intent = getIntent();

        int piePart1 = intent.getIntExtra(PIE_PART_1,0);
        int piePart2 = intent.getIntExtra(PIE_PART_2,0);
        int piePart3 = intent.getIntExtra(PIE_PART_3,0);

        pie = (PieChartDrawer) findViewById(R.id.myPie);
        pie.setPieparts(piePart1,piePart2,piePart3);


    }


}
