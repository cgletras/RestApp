package com.example.restapp.services;

import com.example.restapp.entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {
    @GET("users")
    Call<List<User>> obterUsuarios();
}
