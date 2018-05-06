package com.example.huseyincengiz.obsswatering.Utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.huseyincengiz.obsswatering.Models.Sebze;
import com.example.huseyincengiz.obsswatering.R;

import java.util.ArrayList;

/**
 * Created by HuseyinCengiz on 5.05.2018.
 */

public class RecyclerViewCustomAdapter extends RecyclerView.Adapter<RecyclerViewCustomAdapter.MyViewHolder> {

    ArrayList<Sebze> mDataList;
    LayoutInflater mInflater;
    setOnWateringClickListener msSetOnWateringClickListener;


    public RecyclerViewCustomAdapter(Context context, ArrayList<Sebze> mDataList) {
        this.mDataList = mDataList;
        mInflater = (LayoutInflater) LayoutInflater.from(context);
        try{
            msSetOnWateringClickListener=(setOnWateringClickListener)context;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.recyclerview_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Sebze sebze = mDataList.get(position);
        holder.txtSebzeAdi.setText(sebze.sebzeAdi);
        holder.mSebzePhoto.setImageResource(sebze.photoId);
        holder.mSulaResim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msSetOnWateringClickListener.setOnWateringClick(sebze);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtSebzeAdi;
        ImageView mSebzePhoto, mSulaResim;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtSebzeAdi = (TextView) itemView.findViewById(R.id.txtSebzeAdi);
            mSebzePhoto = (ImageView) itemView.findViewById(R.id.imgSebze);
            mSulaResim = (ImageView) itemView.findViewById(R.id.imgSula);
        }
    }

    public interface setOnWateringClickListener{
         void setOnWateringClick(Sebze sebze);
    }
}
