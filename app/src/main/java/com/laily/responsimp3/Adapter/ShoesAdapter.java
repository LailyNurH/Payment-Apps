package com.laily.responsimp3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.laily.responsimp3.R;
import com.laily.responsimp3.model.Shoes;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ShoesAdapter extends RecyclerView.Adapter<ShoesAdapter.ListViewHolder> {
    private final ArrayList<Shoes> listShoes;
    private Context context;


    public ShoesAdapter(ArrayList<Shoes> listShoes) {
        this.listShoes = listShoes;

    }

    @NonNull
    @NotNull
    @Override
    public ShoesAdapter.ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_shoes, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ShoesAdapter.ListViewHolder holder, int position) {
        Shoes shoes = listShoes.get(position);
        Glide.with(holder.itemView.getContext())
                .load(shoes.getImage())
                .apply(new RequestOptions())
                .into(holder.imgshoes);
        holder.name.setText(shoes.getShoesname());
        holder.type.setText(shoes.getType());
        holder.price.setText(shoes.getPrice());
        holder.rating.setText(shoes.getRating());

        final Context mContext = holder.itemView.getContext();



    }

    @Override
    public int getItemCount() {
        return listShoes.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgshoes;
        TextView name, type, price,rating;

        public ListViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            imgshoes = itemView.findViewById(R.id.imgshoes);
            name = itemView.findViewById(R.id.shoesname);
            type = itemView.findViewById(R.id.typeshoes);
            price = itemView.findViewById(R.id.price);
            rating = itemView.findViewById(R.id.rating);


        }
    }
}