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

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvLogin,tvOTPSent,tvEnterNum;
    AppCompatButton btnSubmit;
    PinView pinview;
    LinearLayout llResend,llLogin;
    EditText etMobileNumber;
    TextView tvMobileNumber;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(this);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
        tvEnterNum = findViewById(R.id.tvEnterNum);
        pinview = findViewById(R.id.pinview);
        tvOTPSent = findViewById(R.id.tvOTPSent);
        llResend = findViewById(R.id.llResend);
        llLogin = findViewById(R.id.llLogin);
        tvMobileNumber = findViewById(R.id.tvMobileNumber);
        etMobileNumber = findViewById(R.id.etMobileNumber);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvLogin:
                startActivity(new Intent(ForgotPasswordActivity.this, LoginActivity.class));
                break;
            case R.id.btnSubmit:
                if (etMobileNumber.getText().toString().contentEquals("")){
                    tvMobileNumber.setTextColor(getColor(R.color.red));
                    etMobileNumber.setBackground(getResources().getDrawable(R.drawable.border_red));
                }else if (!Constants.getMobileNumberValidate(etMobileNumber.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Enter valid Mobile Number",Toast.LENGTH_SHORT).show();
                }else{
                    if (btnSubmit.getText().toString().contentEquals("Submit")){
                        etMobileNumber.setBackground(getResources().getDrawable(R.drawable.border_line));
                        tvMobileNumber.setTextColor(getColor(R.color.black));
                        btnSubmit.setText(getString(R.string.verify));
                        tvEnterNum.setText(getString(R.string.enter_otp_to_verify));
                        llResend.setVisibility(View.VISIBLE);
                        llLogin.setVisibility(View.GONE);
                        tvOTPSent.setVisibility(View.VISIBLE);
                        pinview.setVisibility(View.VISIBLE);
                    }else{
                        startActivity(new Intent(ForgotPasswordActivity.this, ChangePasswordActivity.class));
                    }
                }


                break;
        }
    }
}
