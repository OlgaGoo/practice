package com.olgagoo.debug.homework.homework_7;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.olgagoo.debug.homework.R;
import com.olgagoo.debug.homework.homework_4.PieChartActivity;
import com.olgagoo.debug.homework.homework_4.PieChartDrawer;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class FragmentDetails extends android.support.v4.app.Fragment {
    View view;

    TextView nameField;
    TextView lastNameField;
    ImageView photoView;
    Button edit;
    Button delete;


    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String LAST_NAME = "LAST_NAME";
    public static final String PHOTO = "PHOTO";


    public static void showDetails(ContactsList activity, android.support.v4.app.Fragment fragment, String id, String name, String lastName, int photo) {

        Bundle bundle = new Bundle();

        bundle.putString(ID, id);
        bundle.putString(NAME, name);
        bundle.putString(LAST_NAME, lastName);
        bundle.putInt(PHOTO, photo);

        fragment.setArguments(bundle);

        activity.replaceFragment(fragment);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_details, container, false);
        nameField = (TextView) view.findViewById(R.id.name_on_details);
        lastNameField = (TextView) view.findViewById(R.id.lastname_on_details);
        photoView = (ImageView) view.findViewById(R.id.dialog_photo);

        nameField.setText(getArguments().getString(NAME));
        lastNameField.setText(getArguments().getString(LAST_NAME));
        photoView.setImageResource(getArguments().getInt(PHOTO));
        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
