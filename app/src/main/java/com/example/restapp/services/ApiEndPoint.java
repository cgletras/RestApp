package com.example.restapp.services;

import com.example.restapp.entities.Post;
import com.example.restapp.entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndPoint {
    @GET("users")
    Call<List<User>> obterUsuarios();

    @POST("posts")
    Call<Post>criarpost(@Body Post post);
}
