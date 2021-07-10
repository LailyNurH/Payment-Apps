package com.laily.responsimp3.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.laily.responsimp3.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        final Handler handler = new Handler();

        final SharedprefManager sharedPrefManager = new SharedprefManager(this);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (sharedPrefManager.readLoginStatus()) {
                    Intent i = new Intent(SplashActivity.this, HomeActivity.class);
                    finishAffinity();
                    startActivity(i);

                } else {
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    finishAffinity();
                    startActivity(i);
                }
            }
        }, 3000);
    }
}