package com.example.felipe.restapigithub.rest;

import android.content.Context;

import com.example.felipe.restapigithub.activities.MainActivity;
import com.example.felipe.restapigithub.activities.PullRequestActivity;
import com.example.felipe.restapigithub.model.PullRequest;
import com.example.felipe.restapigithub.model.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Classe que utiliza a lib Retrofit para realizar ações HTTP
 *
 */

public class Retro {

    private Retrofit retrofit;
    private Context context;
    private static final String BASE_URL = "http://api.github.com/";

    public Retro(Context context) {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.context = context;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public Retro setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
        return this;
    }

    public GitHubService gitHubService() {
        return retrofit.create(GitHubService.class);
    }

    public void getRepositories(final MainActivity.Screen screen) {
        gitHubService().getRepositories().enqueue(new Callback<Repository>() {
            @Override
            public void onResponse(Call<Repository> call, Response<Repository> response) {
                Repository rep = response.body();
                screen.adapter.setRepository(rep);
                screen.recyclerView.setAdapter(screen.adapter);
                screen.adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Repository> call, Throwable t) {
                System.out.println(t);
            }
        });

    }

    public void getPullRequest(final PullRequestActivity.Screen screen, String owner, String repository) {
        gitHubService().getPullRequest(owner, repository).enqueue(new Callback<List<PullRequest>>() {
            @Override
            public void onResponse(Call<List<PullRequest>> call, Response<List<PullRequest>> response) {
                List<PullRequest> body = response.body();
                screen.adapter.setPullRequestActivities(body);
                screen.recyclerView.setAdapter(screen.adapter);
                screen.adapter.notifyDataSetChanged();
                System.out.println(body);
            }

            @Override
            public void onFailure(Call<List<PullRequest>> call, Throwable t) {
                System.out.println(t);
            }
        });
    }

}
