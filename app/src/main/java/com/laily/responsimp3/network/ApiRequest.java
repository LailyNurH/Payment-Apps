package com.laily.responsimp3.network;

import com.laily.responsimp3.model.History;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {
    @GET("api/payment")
//    Call<Job> getAllJob();
    Call<List<History>> getAllPayment();
}
