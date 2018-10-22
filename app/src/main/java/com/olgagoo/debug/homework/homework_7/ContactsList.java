package com.olgagoo.debug.homework.homework_7;


import android.app.FragmentTransaction;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import com.olgagoo.debug.homework.R;

public class ContactsList extends AppCompatActivity {
    Fragment fargment_one;
    Fragment fargment_two;
    FragmentManager fragmentManager = getSupportFragmentManager();
    android.support.v4.app.FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contacts_list);
        addFragment();

    }

    public void addFragment(){
        fargment_one = new FragmentList();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frgmCont,fargment_one);
        fragmentTransaction.commit();
    }


    public void replaceFragment(Fragment fragment){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frgmCont,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}
