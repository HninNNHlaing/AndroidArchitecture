package com.hnnh.learnprogramming.androidarchitecture.ui.project;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hnnh.learnprogramming.androidarchitecture.model.network.repository.ProjectRepository;
import com.hnnh.learnprogramming.androidarchitecture.model.response.Project;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hninNwayNwayhlaing on 8/25/2020.
 */
public class ProjectViewMode extends ViewModel {

    private MutableLiveData<List<Project>> projectList =new MutableLiveData<>();
    private MutableLiveData<Project> projectDetails=new MutableLiveData<>();

    public void showProjectList(CompositeDisposable compositeDisposable, String user) {
        compositeDisposable.add(ProjectRepository.getInstance().getProjectList(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> projectList.postValue(result), error ->
                                projectList.postValue(null)
                ));
    }

    public void showProjectDetails(CompositeDisposable compositeDisposable, String user, String projectName) {
        compositeDisposable.add(ProjectRepository.getInstance().getProjectDetails(user, projectName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> {
                            projectDetails.postValue(result);
                        },
                        error -> {
                            projectDetails.postValue(null);
                        }
                )
        );
    }

    MutableLiveData<List<Project>> getProjectList() {
        return projectList;
    }

    MutableLiveData<Project> getProjectDetails() {
        return projectDetails;
    }

}
