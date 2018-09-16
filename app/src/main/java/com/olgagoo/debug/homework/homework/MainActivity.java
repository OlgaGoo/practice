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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button inverse = (Button) findViewById(R.id.inverse_button);
        final TextView textViewOne = (TextView) findViewById(R.id.textView);
        final TextView textViewTwo = (TextView) findViewById(R.id.textView2);


        View.OnClickListener inverseBtn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        };

    }
}
