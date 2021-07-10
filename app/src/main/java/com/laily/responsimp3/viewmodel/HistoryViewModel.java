package com.laily.responsimp3.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.laily.responsimp3.model.History;
import com.laily.responsimp3.repository.HistoryRepository;

import java.util.List;

public class HistoryViewModel extends AndroidViewModel {

    private HistoryRepository historyRepository;
    private LiveData<List<History>> getHistoryLiveData;

    public HistoryViewModel(@NonNull Application application) {
        super(application);

        historyRepository = new HistoryRepository();
        this.getHistoryLiveData = historyRepository.getAllPayment();
    }

    public LiveData<List<History>> getHistoryLiveData() {
        this.getHistoryLiveData = historyRepository.getAllPayment();
        return getHistoryLiveData;
    }
}