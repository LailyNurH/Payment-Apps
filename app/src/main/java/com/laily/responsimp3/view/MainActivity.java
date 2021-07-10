package com.laily.responsimp3.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.laily.responsimp3.DB.UserDB;
import com.laily.responsimp3.DB.UserDao;
import com.laily.responsimp3.viewmodel.UserViewModel;
import com.laily.responsimp3.model.Users;
import com.laily.responsimp3.R;

public class MainActivity extends AppCompatActivity {
    Button Login;
    EditText etEmail, etPass;
    TextView register,tvrecovery;
    private SharedprefManager sharedprefManager;
    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_main);


        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        etEmail = findViewById(R.id.email);
        etPass = findViewById(R.id.password);
        Login = findViewById(R.id.btnLogin);
        tvrecovery = findViewById(R.id.textView);
        tvrecovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RecoveryActivity.class);
                startActivity(intent);
            }
        });
        register = findViewById(R.id.tv_signup);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        sharedprefManager = new SharedprefManager(getApplicationContext());
        if(sharedprefManager.readLoginStatus()){
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish();
        }


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String strEmail = etEmail.getText().toString();
                final String strPassword = etPass.getText().toString();

                if(strEmail.isEmpty() || strPassword.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fill all the box.", Toast.LENGTH_SHORT).show();
                }else{
                    UserDB userDB = UserDB.getDatabase(getApplicationContext());
                    final UserDao userDao = userDB.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Users users = userDao.loginInfo(strEmail, strPassword);
                            if(users == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MainActivity.this, "Invalid Info!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else {
                                String strName = users.getName();
//                                String strAddress = users.getAddress();
                                String strEmail = users.getEmail();

                                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                SharedPreferences sharedPreferences=getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                editor.putString("sp_name", strName);
//                                editor.putString("sp_address", strAddress);
                                editor.putString("sp_email", strEmail);
                                editor.commit();
                                sharedprefManager.writeLoginStatus(true);
                                startActivity(intent);
                            }
                        }
                    }).start();
                }
            }
        });
    }
}
