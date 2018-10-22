package com.olgagoo.debug.homework.homework_7;

import android.app.Activity;
import android.app.Dialog;
import android.app.ListActivity;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.olgagoo.debug.homework.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    ContactsList mActivity;
    List<Contact> data;

    public RecyclerViewAdapter(ContactsList activity, List<Contact> data) {
        this.mActivity = activity;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mActivity).inflate(R.layout.item_contact, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);


        myViewHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mActivity, "Click on " + String.valueOf(myViewHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();

                FragmentDetails fragmentDetails = new FragmentDetails();

                fragmentDetails.showDetails(
                        mActivity,
                        fragmentDetails,
                        data.get(myViewHolder.getAdapterPosition()).getId(),
                        data.get(myViewHolder.getAdapterPosition()).getName(),
                        data.get(myViewHolder.getAdapterPosition()).getLastname(),
                        data.get(myViewHolder.getAdapterPosition()).getPhoto());
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvName.setText(data.get(position).getName());
        holder.tvLastName.setText(data.get(position).getLastname());
        holder.tvPhoto.setImageResource(data.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        private TextView tvLastName;
        private ImageView tvPhoto;
        private LinearLayout item_contact;




        public MyViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.contact_name);
            tvLastName = (TextView) itemView.findViewById(R.id.contact_last_name);
            tvPhoto = (ImageView) itemView.findViewById(R.id.contact_image);
            item_contact = (LinearLayout) itemView.findViewById(R.id.item_contact);
        }
    }
}
