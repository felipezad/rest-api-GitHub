package com.example.felipe.restapigithub.rest;

import com.example.felipe.restapigithub.model.PullRequest;
import com.example.felipe.restapigithub.model.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Utilizando o RetroFit essa interface é convertida num Client Http
 * Deste modo organizando as requisições de uma maneira clara e legivel.
 */

public interface GitHubService {

    @GET("search/repositories?q=language:Java&sort=stars)")
    Call<Repository> getRepositories();

    @GET("repos/{owner}/{repository}/pulls")
    Call<List<PullRequest>> getPullRequest(@Path("owner") String owner, @Path("repository") String repository);

}
