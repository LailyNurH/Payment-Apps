package com.laily.responsimp3.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.Result;
import com.laily.responsimp3.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class PaymentFragment extends Fragment implements ZXingScannerView.ResultHandler {
    private ZXingScannerView scannerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_payment, container, false);
        return view;

    }

    @Override
    public void handleResult(Result result) {

    }


}