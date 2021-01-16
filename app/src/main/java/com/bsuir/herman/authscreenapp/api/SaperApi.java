package com.bsuir.herman.authscreenapp.api;

import com.bsuir.herman.authscreenapp.dto.AuthenticationRequestDto;
import com.bsuir.herman.authscreenapp.dto.MessageDto;
import com.bsuir.herman.authscreenapp.dto.OriginDto;
import com.bsuir.herman.authscreenapp.model.LoginRequestDto;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SaperApi {

    @GET("/ip")
    Call<OriginDto> getIp();

    @GET("/test/")
    Call<MessageDto> getMain();

    @POST("/api/v1/auth/login")
    Call<LoginRequestDto> login(@Body AuthenticationRequestDto body);

//    @GET("/api/v1/auth/registration")
//    Call<String> register(@Query("name") String name);
}
