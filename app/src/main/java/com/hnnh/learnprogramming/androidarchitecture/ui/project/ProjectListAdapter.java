package com.hnnh.learnprogramming.androidarchitecture.ui.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hnnh.learnprogramming.androidarchitecture.R;
import com.hnnh.learnprogramming.androidarchitecture.model.response.Project;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hninNwayNwayhlaing on 8/25/2020.
 */
public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ProjectViewHolder> {
    Context mContext;
    List<Project> projectList;

    public ProjectListAdapter(Context mContext, List<Project> projectList) {
        this.mContext = mContext;
        this.projectList = projectList;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_item_project, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        holder.tvProjectName.setText(projectList.get(position).getFull_name());
        holder.tvUserName.setText(projectList.get(position).getName());
        holder.tvLanguage.setText(projectList.get(position).getLanguage());
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    public static class ProjectViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_project_name)
        TextView tvProjectName;
        @BindView(R.id.tv_user_name)
        TextView tvUserName;
        @BindView(R.id.tv_language)
        TextView tvLanguage;

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
