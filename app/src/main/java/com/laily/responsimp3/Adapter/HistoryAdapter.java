package com.laily.responsimp3.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.laily.responsimp3.R;
import com.laily.responsimp3.model.History;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private List<History> historyList = new ArrayList<>();



    public  void setHistoryList(List<History> list){
        historyList.clear();
        historyList.addAll(list);
        notifyDataSetChanged();
    }
    

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_history,parent,false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.bind(historyList.get(position));

        }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView namapembayaran, metode,status,tanggal;
        private View view;
  

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            namapembayaran = itemView.findViewById(R.id.namapembayaran);
            metode = itemView.findViewById(R.id.metode);
            status = itemView.findViewById(R.id.status);
            tanggal = itemView.findViewById(R.id.tanggal);
         
        }

        public void bind(History history){
            namapembayaran.setText(history.getNamapembayaran());
            metode.setText( history.getMetodepembayaran() );
            status.setText( history.getStatus() );
            tanggal.setText( history.getTanggal() );
           
            Log.d(TAG, "test nama" +history.getNamapembayaran());
        }
    }
}
