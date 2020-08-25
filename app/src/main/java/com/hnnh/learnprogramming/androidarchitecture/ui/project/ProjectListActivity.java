package com.hnnh.learnprogramming.androidarchitecture.ui.project;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hnnh.learnprogramming.androidarchitecture.MyApp;
import com.hnnh.learnprogramming.androidarchitecture.R;
import com.hnnh.learnprogramming.androidarchitecture.model.response.Project;
import com.hnnh.learnprogramming.androidarchitecture.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hninNwayNwayhlaing on 8/25/2020.
 */
public class ProjectListActivity extends BaseActivity {
    @BindView(R.id.rv_project_list)
    RecyclerView rvProjectList;

    ProjectViewMode projectViewMode;
    ProjectListAdapter projectListAdapter;
    List<Project> projectList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);
        ButterKnife.bind(this);
        projectViewMode = new ViewModelProvider(this).get(ProjectViewMode.class);

        projectListAdapter = new ProjectListAdapter(getApplicationContext(), projectList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvProjectList.setLayoutManager(layoutManager);
        rvProjectList.setAdapter(projectListAdapter);


        if (MyApp.isNetworkAvailable(getApplicationContext())) {
            projectViewMode.getProjectList().observe(this, projects -> {
                if (projects != null) {
                    Log.e("result", "" + projects.size());
                    projectList.addAll(projects);
                    projectListAdapter.notifyDataSetChanged();
                }
            });

            projectViewMode.showProjectList(compositeDisposable, "HninNNHlaing");
        } else {
            showMessage(getResources().getString(R.string.dia_newtwork_des));
        }
    }


}
