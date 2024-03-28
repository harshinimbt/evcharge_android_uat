package com.example.evcharge.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evcharge.R;
import com.example.evcharge.Storage.Constants;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatButton btnLogin;
    TextView tvRegister,tvLoginOTP,tvForgotPassword,tvMobileNumber,tvPassword;
    EditText etMobileNumber;
    TextInputEditText etPassword;
    CheckBox cbRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        tvRegister = findViewById(R.id.tvRegister);
        tvRegister.setOnClickListener(this);
        tvLoginOTP = findViewById(R.id.tvLoginOTP);
        tvLoginOTP.setOnClickListener(this);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvForgotPassword.setOnClickListener(this);
        etMobileNumber = findViewById(R.id.etMobileNumber);
        etPassword = findViewById(R.id.etPassword);
        tvMobileNumber = findViewById(R.id.tvMobileNumber);
        tvPassword = findViewById(R.id.tvPassword);
        cbRemember = findViewById(R.id.cbRemember);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                if (validateLogin()){
                startActivity(new Intent(LoginActivity.this, PanelActivity.class));
                finish();
                }
                break;
            case R.id.tvRegister:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.tvLoginOTP:
                startActivity(new Intent(LoginActivity.this, LoginOTPVerifyActivity.class));
                break;
            case R.id.tvForgotPassword:
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
                break;
        }
    }

    private Boolean validateLogin() {

        Boolean validationStatus = true;
        if (etMobileNumber.getText().toString().contentEquals("")){
            tvMobileNumber.setTextColor(getColor(R.color.red));
            etMobileNumber.setBackground(getResources().getDrawable(R.drawable.border_red));
            validationStatus = false;
        }else{
            tvMobileNumber.setTextColor(getColor(R.color.black));
            etMobileNumber.setBackground(getResources().getDrawable(R.drawable.border_line));
        }
        if (etPassword.getText().toString().contentEquals("")){
            tvPassword.setTextColor(getColor(R.color.red));
            etPassword.setBackground(getResources().getDrawable(R.drawable.border_red));
            validationStatus = false;
        }else{
            tvPassword.setTextColor(getColor(R.color.black));
            etPassword.setBackground(getResources().getDrawable(R.drawable.border_line));
        }

        if (validationStatus){
            if (!Constants.getMobileNumberValidate(etMobileNumber.getText().toString())){
                Toast.makeText(getApplicationContext(),"Enter Valid Mobile Number",Toast.LENGTH_SHORT).show();
                validationStatus = false;
            }else if (!Constants.getPasswordValidate(etPassword.getText().toString())){
                Toast.makeText(getApplicationContext(),"Enter Valid Password",Toast.LENGTH_SHORT).show();
                validationStatus = false;
            }
        }
         return validationStatus;
    }
}