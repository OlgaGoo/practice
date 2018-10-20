package com.olgagoo.debug.homework.homework_7;

import android.app.Dialog;
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

    Context mContext;
    List<Contact> data;
    Dialog myDialog;

    public RecyclerViewAdapter(Context mContext, List<Contact> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_contact, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.fragment_details);
        myDialog.getWindow().setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));



        myViewHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView dialog_name = (TextView) myDialog.findViewById(R.id.name_on_details);
                TextView dialod_last_name = (TextView) myDialog.findViewById(R.id.lastname_on_details);
                Button edit_btn = (Button) myDialog.findViewById(R.id.edit_info_btn);
                Button delete_btn = (Button) myDialog.findViewById(R.id.delete_info_btn);
                ImageView photo = (ImageView) myDialog.findViewById(R.id.dialog_photo);
                dialog_name.setText(data.get(myViewHolder.getAdapterPosition()).getName());
                dialod_last_name.setText(data.get(myViewHolder.getAdapterPosition()).getLastname());
                photo.setImageResource(data.get(myViewHolder.getAdapterPosition()).getPhoto());

                Toast.makeText(mContext, "Click on " + String.valueOf(myViewHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
                myDialog.show();
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
