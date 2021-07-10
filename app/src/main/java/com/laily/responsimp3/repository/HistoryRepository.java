package com.laily.responsimp3.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.laily.responsimp3.model.History;
import com.laily.responsimp3.network.ApiClient;
import com.laily.responsimp3.network.ApiRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryRepository {
    private static final String TAG = HistoryRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public HistoryRepository() {
        apiRequest = ApiClient.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<List<History>> getAllPayment() {
        final MutableLiveData<List<History>> data = new MutableLiveData<>();
        apiRequest.getAllPayment()
                .enqueue(new Callback<List<History>>() {
                    @Override
                    public void onResponse(Call<List<History>> call, Response<List<History>> response) {
                        Log.d(TAG, "onResponse response " + response);
                        if (response.body() != null) {
                            data.setValue(response.body());
                            Log.d(TAG, "onResponse: " + response.body().size());
//                            Log.d(TAG, "job " + response.body();
                        }

                    }

                    @Override
                    public void onFailure(Call<List<History>> call, Throwable t) {
                        data.setValue(null);

                    }
                });
        return data;
    }
}
