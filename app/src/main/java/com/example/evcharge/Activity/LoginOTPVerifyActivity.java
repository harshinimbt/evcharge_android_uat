package com.example.evcharge.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.chaos.view.PinView;
import com.example.evcharge.R;
import com.example.evcharge.Storage.Constants;

public class LoginOTPVerifyActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvRegister,tvOTPSent,tvEnterOtp,tvMobileNumber;
    AppCompatButton btnSubmit;
    PinView pinview;
    LinearLayout llResend,llRegister;
    EditText etMobileNumber;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verify);
        tvRegister = findViewById(R.id.tvRegister);
        tvRegister.setOnClickListener(this);
        pinview = findViewById(R.id.pinview);
        tvOTPSent = findViewById(R.id.tvOTPSent);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
        tvEnterOtp = findViewById(R.id.tvEnterOtp);
        llResend = findViewById(R.id.llResend);
        llRegister = findViewById(R.id.llRegister);
        tvMobileNumber = findViewById(R.id.tvMobileNumber);
        etMobileNumber = findViewById(R.id.etMobileNumber);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvRegister:
                startActivity(new Intent(LoginOTPVerifyActivity.this,RegisterActivity.class));
                break;
            case R.id.btnSubmit:
                if (etMobileNumber.getText().toString().contentEquals("")){
                    tvMobileNumber.setTextColor(getColor(R.color.red));
                    etMobileNumber.setBackground(getResources().getDrawable(R.drawable.border_red));
                }else if (!Constants.getMobileNumberValidate(etMobileNumber.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Enter valid Mobile Number",Toast.LENGTH_SHORT).show();
                }else{
                    tvMobileNumber.setTextColor(getColor(R.color.black));
                    etMobileNumber.setBackground(getResources().getDrawable(R.drawable.border_line));
                    tvEnterOtp.setText(getString(R.string.enter_otp));
                    tvOTPSent.setVisibility(View.VISIBLE);
                    llRegister.setVisibility(View.GONE);
                    pinview.setVisibility(View.VISIBLE);
                    llResend.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
}
