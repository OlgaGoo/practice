package com.olgagoo.debug.homework.homework_7;

import android.app.Fragment;
import android.app.FragmentTransaction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.olgagoo.debug.homework.R;

public class ContactsList extends AppCompatActivity {
    Fragment fargment_one;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);

        fargment_one = new FragmentList();

        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frgmCont,fargment_one);

        fragmentTransaction.commit();


    }
}