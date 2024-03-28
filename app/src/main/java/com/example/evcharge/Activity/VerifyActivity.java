package com.example.evcharge.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.evcharge.R;

public class VerifyActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatButton btnVerify;
    EditText etFullName,etMobileNumber;
    TextView tvFullName,tvMobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        btnVerify = findViewById(R.id.btnVerify);
        btnVerify.setOnClickListener(this);
        etFullName = findViewById(R.id.etFullName);
        etMobileNumber = findViewById(R.id.etMobileNumber);
        tvFullName = findViewById(R.id.tvFullName);
        tvMobileNumber = findViewById(R.id.tvMobileNumber);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnVerify:
                startActivity(new Intent(VerifyActivity.this,CreatePasswordActivity.class));
                break;
        }
    }
}