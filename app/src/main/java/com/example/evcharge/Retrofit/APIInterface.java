package com.example.evcharge.Retrofit;


import com.example.evcharge.Model.LoginRequest;
import com.example.evcharge.Model.LoginResponse;
import com.example.evcharge.Model.RegisterRequest;
import com.example.evcharge.Model.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIInterface {
    @POST("/user/register")
    Call<RegisterResponse>getRegisterResponse(@Header("authorization") String authorization, @Header("app_name") String appName,@Body RegisterRequest registerRequest);

    @POST("/login")
    Call<LoginResponse>getLoginResponse(@Header("authorization") String authorization, @Header("app_name") String appName,@Body LoginRequest loginRequest);
}
