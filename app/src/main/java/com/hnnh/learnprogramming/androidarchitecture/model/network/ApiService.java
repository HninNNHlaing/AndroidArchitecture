package com.hnnh.learnprogramming.androidarchitecture.model.network;

import com.hnnh.learnprogramming.androidarchitecture.model.response.Project;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by hninNwayNwayhlaing on 8/25/2020.
 */
public interface ApiService {
    @GET("users/{user}/repos")
    Observable<List<Project>> getProjectList(@Path("user") String user);

    @GET("/repos/{user}/{reponame}")
    Observable<Project> getProjectDetails(@Path("user") String user, @Path("reponame") String projectName);
}
