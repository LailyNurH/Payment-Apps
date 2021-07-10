package com.laily.responsimp3.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.laily.responsimp3.viewmodel.UserViewModel;
import com.laily.responsimp3.model.Users;
import com.laily.responsimp3.R;

public class RegisterActivity extends AppCompatActivity {
    Button Register;
    EditText et_Email, et_Pass, et_confrimpass;
    TextView register;
    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        et_Email = findViewById(R.id.remail);
        et_Pass = findViewById(R.id.rpassword);
        et_confrimpass = findViewById(R.id.confrimpass);
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Register = findViewById(R.id.btnRegister);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String remail = et_Email.getText().toString();
                String rpass = et_Pass.getText().toString();
                String confrimpass = et_confrimpass.getText().toString();

                if (et_Pass.equals(et_confrimpass)) {

                    Users users = new Users(remail, rpass);
                    userViewModel.insertuser(users);

                    et_Email.setText("");
                    et_Pass.setText("");
                    et_confrimpass.setText("");


                    Toast.makeText(RegisterActivity.this, "Registration Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));

                } else if( rpass.isEmpty() || remail.isEmpty()||confrimpass.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Fill all the box.", Toast.LENGTH_SHORT).show();
                } else{
//,confrimpass
                    Toast.makeText(RegisterActivity.this, "Password Harus Sama", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    }

