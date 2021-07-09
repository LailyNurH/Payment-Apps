package com.laily.responsimp3.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.laily.responsimp3.R;
import com.laily.responsimp3.model.Shoes;
import com.laily.responsimp3.ShoesAdapter;
import com.laily.responsimp3.data.ShoesData;
import com.laily.responsimp3.view.MainActivity;
import com.laily.responsimp3.view.SharedprefManager;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private RecyclerView rvshoes;
    TextView user;
    ImageView logout;
    private SharedprefManager sharedprefManager;
    private ArrayList<Shoes> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        user = view.findViewById(R.id.user);
        logout = view.findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedprefManager.writeLoginStatus(false);
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        sharedprefManager = new SharedprefManager(getContext());
        SharedPreferences sharedPreferences= this.getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("sp_name","Data not found");
        user.setText(name);
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

        ShoesAdapter.setOnItemClickCallback(new ShoesAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Shoes data) {

                showSelectedBook(data);
            }

            private void showSelectedBook(Shoes data) {
                Toast.makeText(getContext(), "You Selected " + data.getShoesname(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
