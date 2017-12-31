package com.example.shubham.engifestapp.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shubham.engifestapp.Models.SponsorData;
import com.example.shubham.engifestapp.R;
import com.github.siyamed.shapeimageview.CircularImageView;


import java.util.ArrayList;

/**
 * Created by mohitkumar on 08/01/17.
 */

public class SponsorAdapter extends RecyclerView.Adapter<SponsorAdapter.RecyclerViewHolder> {

    ArrayList<SponsorData> arrayList = new ArrayList<SponsorData>();
    Context context;

    public SponsorAdapter(Context context, ArrayList<SponsorData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sponsor_card,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        SponsorData sponsorData = arrayList.get(position);

//        Typeface tf = Typeface.createFromAsset(context.getAssets(),"fonts/OpenSans-Regular.ttf");
//        holder.textView.setTypeface(tf);

        holder.textView.setText(sponsorData.getName());

        Glide.with(context).load(sponsorData.getImagesrc()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        CircularImageView imageView;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.title1);
            imageView = itemView.findViewById(R.id.thumbnail);
        }
    }
}
