package com.example.retrofit.retrofit;

import java.util.List;

import com.example.retrofit.model.ModelPost;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts/")
    Call<List<ModelPost>> getposts();
}
