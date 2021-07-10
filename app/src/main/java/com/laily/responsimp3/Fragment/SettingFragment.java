package com.laily.responsimp3.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.laily.responsimp3.R;
import com.laily.responsimp3.view.PaymentActivity;
import com.laily.responsimp3.view.ProfileActivity;


public class SettingFragment extends Fragment {
    private RelativeLayout profile;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_setting, container, false);

        profile = view.findViewById(R.id.profiledetail);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}