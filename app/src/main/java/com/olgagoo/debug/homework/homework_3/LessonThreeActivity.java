package com.olgagoo.debug.homework.homework_3;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.olgagoo.debug.homework.R;
import com.squareup.picasso.Picasso;

public class LessonThreeActivity extends AppCompatActivity {
    public static final String EXTRA_IMAGE_URL = "EXTRA_IMAGE_URL";
    SimpleDraweeView frescoImage;
    EditText input;
    Button btnShowImage;
    View.OnClickListener btnShowImageClk;

    public static void showImage(Activity activity, String url) {

        Intent intent = new Intent(activity, LessonThreeActivity.class);

        intent.putExtra(EXTRA_IMAGE_URL, String.valueOf(url));

        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_lesson_three);

        frescoImage = (SimpleDraweeView) findViewById(R.id.fresco_image);
        input = (EditText) findViewById(R.id.link_input);
        btnShowImage = (Button) findViewById(R.id.show_image_btn);

        Intent intent = getIntent();

        final String link = intent.getStringExtra(EXTRA_IMAGE_URL);

        btnShowImageClk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartActivity();
                finish();
            }
        };
        btnShowImage.setOnClickListener(btnShowImageClk);
        updateImageView(frescoImage,link);


    }

    private void restartActivity() {
        if (TextUtils.isEmpty((input.getText()))) {
            return;
        }

        LessonThreeActivity.showImage(LessonThreeActivity.this, String.valueOf(input.getText()));
    }

    private void updateImageView(SimpleDraweeView image,String link){
        if(link != null){
            Uri uri = Uri.parse(link);
            image.setImageURI(uri);
        } else{
           return;
        }
    }
}
