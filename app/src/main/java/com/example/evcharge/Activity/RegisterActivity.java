package com.example.evcharge.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evcharge.Model.ErrorResponse;
import com.example.evcharge.Model.RegisterRequest;
import com.example.evcharge.Model.RegisterResponse;
import com.example.evcharge.R;
import com.example.evcharge.Retrofit.APIClient;
import com.example.evcharge.Retrofit.APIInterface;
import com.example.evcharge.Storage.Constants;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatButton btnRegister;
    TextView tvLogin,tvFullName,tvMobileNumber,tvCreatePassword,tvConfirmPassword;
    EditText etFullName,etMobileNumber;
    TextInputEditText etCreatePassword,etConfirmPassword;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);
        tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(this);
        etFullName = findViewById(R.id.etFullName);
        etMobileNumber = findViewById(R.id.etMobileNumber);
        tvFullName = findViewById(R.id.tvFullName);
        tvMobileNumber = findViewById(R.id.tvMobileNumber);
        etCreatePassword = findViewById(R.id.etCreatePassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        tvCreatePassword = findViewById(R.id.tvCreatePassword);
        tvConfirmPassword = findViewById(R.id.tvConfirmPassword);
        tvCreatePassword.setOnClickListener(this);
        tvConfirmPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegister:
                if (validateRegister()){
                    Register();
                }
                break;
            case R.id.tvLogin:
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                break;
            case R.id.tvCreatePassword:
            case R.id.tvConfirmPassword:
                Toast.makeText(getApplicationContext(),getString(R.string.pass_validation),Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void Register() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFullName(etFullName.getText().toString());
        registerRequest.setMobileNumber(etMobileNumber.getText().toString());
        registerRequest.setNewPassword(etCreatePassword.getText().toString());
        registerRequest.setConfirmPassword(etConfirmPassword.getText().toString());

        apiInterface.getRegisterResponse(Constants.authorization,Constants.appName,registerRequest).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()){
                    Intent intent = new Intent(RegisterActivity.this, VerifyActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    try {
                        Type type = new TypeToken<ErrorResponse>() {
                        }.getType();
                        Gson gson = new Gson();
                        ErrorResponse errorResponse = gson.fromJson(response.errorBody().string(),type);
                        Toast.makeText(getApplicationContext(),errorResponse.getMessage(),Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {


            }
        });

    }

    private boolean validateRegister() {
        Boolean validationStatus = true;
        if (etFullName.getText().toString().contentEquals("")){
            tvFullName.setTextColor(getColor(R.color.red));
            etFullName.setBackground(getResources().getDrawable(R.drawable.border_red));
            validationStatus = false;
        }else{
            tvFullName.setTextColor(getColor(R.color.black));
            etFullName.setBackground(getResources().getDrawable(R.drawable.border_line));
        }
        if (etMobileNumber.getText().toString().contentEquals("")){
            tvMobileNumber.setTextColor(getColor(R.color.red));
            etMobileNumber.setBackground(getResources().getDrawable(R.drawable.border_red));
            validationStatus = false;
        }else{
            tvMobileNumber.setTextColor(getColor(R.color.black));
            etMobileNumber.setBackground(getResources().getDrawable(R.drawable.border_line));
        }
        if (etCreatePassword.getText().toString().contentEquals("")){
            tvCreatePassword.setTextColor(getColor(R.color.red));
            etCreatePassword.setBackground(getResources().getDrawable(R.drawable.border_red));
            validationStatus = false;
        }else{
            tvCreatePassword.setTextColor(getColor(R.color.black));
            etCreatePassword.setBackground(getResources().getDrawable(R.drawable.border_line));
        }
        if (etConfirmPassword.getText().toString().contentEquals("")){
            tvConfirmPassword.setTextColor(getColor(R.color.red));
            etConfirmPassword.setBackground(getResources().getDrawable(R.drawable.border_red));
            validationStatus = false;
        }else{
            tvConfirmPassword.setTextColor(getColor(R.color.black));
            etConfirmPassword.setBackground(getResources().getDrawable(R.drawable.border_line));
        }

        if (validationStatus){
            if (!Constants.getMobileNumberValidate(etMobileNumber.getText().toString())){
                Toast.makeText(getApplicationContext(),"Enter Valid MobileNumber",Toast.LENGTH_SHORT).show();
                validationStatus = false;
            }else if (!Constants.getPasswordValidate(etCreatePassword.getText().toString())){
//                etCreatePassword.getBackground().setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.SRC_ATOP);
                Toast.makeText(getApplicationContext(),"Enter Valid Password",Toast.LENGTH_SHORT).show();
                validationStatus = false;
            }else if (!Constants.getPasswordValidate(etConfirmPassword.getText().toString())){
                Toast.makeText(getApplicationContext(),"Enter Valid Password",Toast.LENGTH_SHORT).show();
                validationStatus = false;
            }else if (!etCreatePassword.getText().toString().contentEquals(etConfirmPassword.getText().toString())){
                Toast.makeText(getApplicationContext(),"Create Password and Confirm Password must be the same.",Toast.LENGTH_SHORT).show();
                validationStatus = false;
            }
        }
        return validationStatus;
    }
}