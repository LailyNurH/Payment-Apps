package com.laily.responsimp3.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laily.responsimp3.Adapter.HistoryAdapter;
import com.laily.responsimp3.R;
import com.laily.responsimp3.model.History;
import com.laily.responsimp3.viewmodel.HistoryViewModel;

import java.util.List;


public class HistoryFragment extends Fragment {

    private HistoryViewModel historyViewModel;
    private HistoryAdapter historyAdapter;
    private RecyclerView rvHistory;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        historyViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
        rvHistory = view.findViewById(R.id.rvhistory);
        historyAdapter = new HistoryAdapter();
        rvHistory.setLayoutManager(new LinearLayoutManager(getContext()));

        getAllPayment();
        return view;
    }
    private void getAllPayment() {
        rvHistory.setAdapter(historyAdapter);
        historyViewModel.getHistoryLiveData().observe((LifecycleOwner) getContext(), historyResponse -> {
            if (historyResponse != null) {

                List<History> historyResponses = historyResponse;
                historyAdapter.setHistoryList(historyResponses);

            }
        });
    }


}