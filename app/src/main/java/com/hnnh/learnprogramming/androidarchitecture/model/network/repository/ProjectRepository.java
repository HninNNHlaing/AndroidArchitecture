package com.hnnh.learnprogramming.androidarchitecture.model.network.repository;

import com.hnnh.learnprogramming.androidarchitecture.model.network.ApiService;
import com.hnnh.learnprogramming.androidarchitecture.model.network.ApiServiceClient;
import com.hnnh.learnprogramming.androidarchitecture.model.response.Project;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by hninNwayNwayhlaing on 8/25/2020.
 */
public class ProjectRepository {
    ApiService apiService;
    private static ProjectRepository mInstance;

    public static ProjectRepository getInstance() {
        if ( mInstance== null) {
            mInstance = new ProjectRepository();
        }
        return mInstance;
    }


    public ProjectRepository() {
        this.apiService = ApiServiceClient.initRetrofit().create(ApiService.class);
    }

    public Observable<List<Project>> getProjectList(String user){
        return apiService.getProjectList(user);
    }

    public Observable<Project> getProjectDetails(String user,String projectName){
        return apiService.getProjectDetails(user,projectName);
    }


}
