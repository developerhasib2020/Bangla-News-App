package com.example.hasibsnews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<Model> list = new ArrayList<Model>();

    public Adapter(Context context, ArrayList<Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Model model = list.get(position);
        holder.newsimage.setImageResource(model.getImage());
        holder.newsname.setText(model.getNewsname());
        holder.rating.setRating(model.getRating());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView newsimage;
        RatingBar rating;
        TextView newsname;
        LinearLayout cardlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardlayout = itemView.findViewById(R.id.cardlayout);
            newsimage = itemView.findViewById(R.id.itemimage);
            rating = itemView.findViewById(R.id.ratingBar);
            newsname = itemView.findViewById(R.id.itemnewsname);

        }
    }
}
