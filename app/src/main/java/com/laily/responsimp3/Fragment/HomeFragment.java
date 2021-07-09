package com.laily.responsimp3.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.laily.responsimp3.R;
import com.laily.responsimp3.Shoes;
import com.laily.responsimp3.ShoesAdapter;
import com.laily.responsimp3.ShoesData;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private RecyclerView rvshoes;
    private ArrayList<Shoes> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvshoes = view.findViewById(R.id.rvShoes);
        rvshoes.setHasFixedSize(true);

        list.addAll(ShoesData.getListData());
        showRecyclerList();
        return view;

    }

    private void showRecyclerList() {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        rvshoes.setLayoutManager(mLayoutManager);
        ShoesAdapter shoesAdapter = new ShoesAdapter(list);
        rvshoes.setAdapter(shoesAdapter);

//        ShoesAdapter.setOnItemClickCallback(new ShoesAdapter.OnItemClickCallback() {
//            @Override
//            public void onItemClicked(Shoes data) {
//
//                showSelectedBook(data);
            }
//
//            private void showSelectedBook(Shoes data) {
//                Toast.makeText(getContext(), "You Selected " + data.getShoesname(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
//    }
