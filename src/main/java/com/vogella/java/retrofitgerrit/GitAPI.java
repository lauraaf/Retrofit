package com.vogella.java.retrofitgerrit;

import java.util.*;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitAPI {
    @GET("repos")
    Call<List<Repos>> loadRepos(@Query("q") String status);
}