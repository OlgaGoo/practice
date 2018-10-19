package com.olgagoo.debug.homework.homework_7;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.olgagoo.debug.homework.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentList extends android.app.Fragment{
    View view;
    private RecyclerView myRcView;
    private List<Contact> contactList;


    public FragmentList() {
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contacts_list, container,false);
        myRcView = (RecyclerView) view.findViewById(R.id.contact_rc_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getActivity(),contactList);
        myRcView.setLayoutManager( new LinearLayoutManager(getActivity()));
        myRcView.setAdapter(recyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contactList = new ArrayList<>();
        contactList.add(new Contact("George", "Nillson", R.drawable.ic_image_black_24dp));
        contactList.add(new Contact("Viktor", "Newman", R.drawable.ic_launcher_background));
        contactList.add(new Contact("Poul", "Petterson", R.drawable.ic_image_black_24dp));
        contactList.add(new Contact("Anna", "Poul", R.drawable.ic_launcher_background));
        contactList.add(new Contact("Richard", "Castle", R.drawable.ic_image_black_24dp));
        contactList.add(new Contact("Alex", "Mitch", R.drawable.ic_image_black_24dp));

    }
}
