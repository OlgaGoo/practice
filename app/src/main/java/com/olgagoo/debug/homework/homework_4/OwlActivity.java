package com.olgagoo.debug.homework.homework_4;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.olgagoo.debug.homework.R;

public class OwlActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button createPieBnt;
    private AnimationDrawable owlAnimation;
    private View.OnClickListener btnClc;
    private EditText input1;
    private EditText input2;
    private EditText input3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owl);

        imageView = (ImageView) findViewById(R.id.owlAnimation);
        imageView.setBackgroundResource(R.drawable.owl_animation);

        input1 = (EditText) findViewById(R.id.piePArt1);
        input2 = (EditText) findViewById(R.id.piePArt2);
        input3 = (EditText) findViewById(R.id.piePArt3);


        owlAnimation = (AnimationDrawable) imageView.getBackground();
        owlAnimation.start();

        final Intent pieActivity = new Intent(this, PieChartActivity.class);

        createPieBnt = (Button) findViewById(R.id.createPieChartBtn);

        btnClc = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityWithPie();
            }
        };

        createPieBnt.setOnClickListener(btnClc);
    }


    private void startActivityWithPie() {
        if (TextUtils.isEmpty((input1.getText())) || TextUtils.isEmpty(input2.getText()) || TextUtils.isEmpty(input3.getText())) {
            Toast.makeText(this, "Error: Link is empty", Toast.LENGTH_SHORT).show();
            return;

        }

        PieChartActivity.showPie(OwlActivity.this, Integer.parseInt(input1.getText().toString()), Integer.parseInt(input2.getText().toString()), Integer.parseInt(input3.getText().toString()));

    }



    @Override
    public void onResume(){
        super.onResume();
        owlAnimation.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        owlAnimation.stop();
    }


}
