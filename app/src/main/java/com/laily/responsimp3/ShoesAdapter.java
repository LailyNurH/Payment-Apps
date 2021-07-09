package com.laily.responsimp3;

import android.app.DownloadManager;
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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ShoesAdapter extends RecyclerView.Adapter<ShoesAdapter.ListViewHolder> {
    private final ArrayList<Shoes> listShoes;
    private Context context;
    private OnItemClickCallback onItemClickCallback;


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

        final Context mContext = holder.itemView.getContext();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listShoes.get(holder.getAdapterPosition()));

            }
        });

    }

    @Override
    public int getItemCount() {
        return listShoes.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgshoes;
        TextView name, type, price;

        public ListViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            imgshoes = itemView.findViewById(R.id.imgshoes);
            name = itemView.findViewById(R.id.shoesname);
            type = itemView.findViewById(R.id.typeshoes);
            price = itemView.findViewById(R.id.price);


        }
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Shoes data);
    }
}