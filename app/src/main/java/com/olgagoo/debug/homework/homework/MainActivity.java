package com.olgagoo.debug.homework.homework;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.olgagoo.debug.homework.R;

import static com.olgagoo.debug.homework.R.color.unselected_text_background;

public
class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button inverse;
    TextView textViewOne;
    TextView textViewTwo;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        inverse = (Button) findViewById(R.id.inverse_button);
//        textViewOne = (TextView) findViewById(R.id.textView);
//        textViewTwo = (TextView) findViewById(R.id.textView2);
//
//        //OPTION ONE - Anonymous
//        inverse.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                inverseText(textViewOne,textViewTwo);
//            }
//        });
//
//        textViewOne.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                inverseText(textViewOne,textViewTwo);
//            }
//        });
//
//        textViewTwo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                inverseText(textViewOne,textViewTwo);
//            }
//        });
//
//        //OPTION TWO - with variable
//        View.OnClickListener inverseClc = new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                inverseText(textViewOne,textViewTwo);
//            }
//        };
//        inverse.setOnClickListener(inverseClc);
//        textViewTwo.setOnClickListener(inverseClc);
//        textViewOne.setOnClickListener(inverseClc);
//
//    }

    //OPTION THREE - Implementation
    @Override
    public void onClick(View v) {
        inverseText(textViewOne,textViewTwo);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inverse = (Button) findViewById(R.id.inverse_button);
        textViewOne = (TextView) findViewById(R.id.textView);
        textViewTwo = (TextView) findViewById(R.id.textView2);

        inverse.setOnClickListener(this);
        textViewOne.setOnClickListener(this);
        textViewTwo.setOnClickListener(this);
    }

    /**
     * Inverse Text and TextBackground between TextView One and TextView Two
     * @param textViewOne is first textView
     * @param textViewTwo is second textView
     */
    private void inverseText(TextView textViewOne, TextView textViewTwo) {
        String current = textViewOne.getText().toString();
        String one = (String) getText(R.string.text_view_one);
        if(textViewOne.getText().toString().equals(one)){
            textViewOne.setText(R.string.text_view_two);
            textViewOne.setBackgroundColor(getResources().getColor(R.color.selected_text_background));
            textViewTwo.setText(R.string.text_view_one);
            textViewTwo.setBackgroundColor(getResources().getColor(R.color.unselected_text_background));

        }else {
            textViewOne.setText(R.string.text_view_one);
            textViewOne.setBackgroundColor(getResources().getColor(R.color.unselected_text_background));
            textViewTwo.setText(R.string.text_view_two);
            textViewTwo.setBackgroundColor(getResources().getColor(R.color.selected_text_background));
        }

    }

}
