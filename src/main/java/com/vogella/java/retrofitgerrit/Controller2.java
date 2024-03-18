package com.vogella.java.retrofitgerrit;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller2 implements Callback<List<Repos>> {

    static final String BASE_URL = "https://api.github.com/users/lauraaf/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GitAPI gitAPI = retrofit.create(GitAPI.class);

        Call<List<Repos>> call = gitAPI.loadRepos("status:open");
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Repos>> call, Response<List<Repos>> response) {
        if(response.isSuccessful()) {
            List<Repos> reposList = response.body();
            reposList.forEach(repos -> System.out.println("Nombre del repositorio:"+ repos.name +" ID:"+ repos.id));
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Repos>> call, Throwable t) {
        t.printStackTrace();
    }
}
