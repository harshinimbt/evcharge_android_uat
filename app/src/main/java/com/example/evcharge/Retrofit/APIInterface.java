package com.example.evcharge.Retrofit;


import com.example.evcharge.Model.RegisterRequest;
import com.example.evcharge.Model.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {
    @POST("/user/register")
    Call<RegisterResponse>getRegisterResponse(@Body RegisterRequest registerRequest);
}
