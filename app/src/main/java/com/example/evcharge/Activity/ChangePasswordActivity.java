package com.example.evcharge.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.evcharge.R;
import com.google.android.material.textfield.TextInputEditText;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvLogin,tvNewPassword,tvConfirmPassword;
    AppCompatButton btnSave;
    TextInputEditText etNewPassword,etConfirmPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(this);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        tvNewPassword = findViewById(R.id.tvNewPassword);
        tvConfirmPassword = findViewById(R.id.tvConfirmPassword);
        tvNewPassword.setOnClickListener(this);
        tvConfirmPassword.setOnClickListener(this);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etNewPassword = findViewById(R.id.etNewPassword);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvLogin:
                startActivity(new Intent(ChangePasswordActivity.this,LoginActivity.class));
                break;
            case R.id.btnSave:
                if (etNewPassword.getText().toString().contentEquals("")){
                    tvNewPassword.setTextColor(getColor(R.color.red));
                    etNewPassword.setBackground(getResources().getDrawable(R.drawable.border_red));
                }else{
                    tvNewPassword.setTextColor(getColor(R.color.black));
                    etNewPassword.setBackground(getResources().getDrawable(R.drawable.border_line));
                }
                if (etConfirmPassword.getText().toString().contentEquals("")){
                    tvConfirmPassword.setTextColor(getColor(R.color.red));
                    etConfirmPassword.setBackground(getResources().getDrawable(R.drawable.border_red));
                }else{
                    tvConfirmPassword.setTextColor(getColor(R.color.black));
                    etConfirmPassword.setBackground(getResources().getDrawable(R.drawable.border_line));
                }
                if (!etNewPassword.getText().toString().contentEquals(etConfirmPassword.getText().toString())){
                    Toast.makeText(getApplicationContext(),"New Password and Confirm Password must be the same.",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tvNewPassword:
            case R.id.tvConfirmPassword:
                Toast.makeText(getApplicationContext(),getString(R.string.pass_validation),Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
