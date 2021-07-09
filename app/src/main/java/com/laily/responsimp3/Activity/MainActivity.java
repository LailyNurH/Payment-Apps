package com.laily.responsimp3.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import com.laily.responsimp3.R;

public class MainActivity extends AppCompatActivity {
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_main);

        Login = findViewById(R.id.btnLogin);
        Login.setOnClickListener(v -> {
            Intent intent = new Intent (MainActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}