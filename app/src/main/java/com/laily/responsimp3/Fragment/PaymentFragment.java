package com.laily.responsimp3.Fragment;

import android.app.Activity;
import android.content.Context;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.zxing.Result;
import com.laily.responsimp3.R;
import com.laily.responsimp3.view.PaymentActivity;

import java.util.ArrayList;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.hardware.Camera.getNumberOfCameras;



public class PaymentFragment extends Fragment {

    private Activity mActivity;
    private Context mContext;
    private TextView here;
    private ViewGroup contentFrame;
    private ZXingScannerView zXingScannerView;
    private int camId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVar();
        zXingScannerView = new ZXingScannerView(mActivity);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_payment, container, false);

        here = rootView.findViewById(R.id.txhere);
        here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PaymentActivity.class);
                startActivity(intent);
            }
        });
        initView(rootView);
        return rootView;
    }

    private void initVar() {
        mActivity = getActivity();
        mContext = mActivity.getApplicationContext();
    }


    private void initView(View rootView) {
        contentFrame = (ViewGroup) rootView.findViewById(R.id.scan);

    }

    private void activateScanner() {
        if(zXingScannerView != null) {

            if(zXingScannerView.getParent()!=null) {
                ((ViewGroup) zXingScannerView.getParent()).removeView(zXingScannerView); // to prevent crush on re adding view
            }
            contentFrame.addView(zXingScannerView);

            if(zXingScannerView.isActivated()) {
                zXingScannerView.stopCamera();
            }

            zXingScannerView.startCamera(camId);
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        activateScanner();
    }

    @Override
    public void onPause() {
        super.onPause();
        if(zXingScannerView != null) {
            zXingScannerView.stopCamera();
        }
    }

}
