package com.example.felipe.restapigithub.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.felipe.restapigithub.R;
import com.example.felipe.restapigithub.model.PullRequest;

import java.util.List;

/**
 * Created by Felipe on 10/01/2017.
 */

public class PullRequestAdapterRecyclerView extends RecyclerView.Adapter<PullRequestAdapterRecyclerView.RowViewHolder> {

    List<PullRequest> pullRequestActivities;


    public PullRequestAdapterRecyclerView(List<PullRequest> pullRequestActivities) {
        this.pullRequestActivities = pullRequestActivities;
    }

    public PullRequestAdapterRecyclerView setPullRequestActivities(List<PullRequest> pullRequestActivities) {
        this.pullRequestActivities = pullRequestActivities;
        this.notifyDataSetChanged();
        return this;
    }

    @Override
    public RowViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_pull_request, null);
        PullRequestAdapterRecyclerView.RowViewHolder row = new PullRequestAdapterRecyclerView.RowViewHolder(view);
        return row;
    }

    @Override
    public void onBindViewHolder(RowViewHolder rowViewHolder, int position) {
        final PullRequest pullRequest = this.pullRequestActivities.get(position);

        rowViewHolder.body.setText(pullRequest.getBody());
        rowViewHolder.login.setText(pullRequest.getUser().getLogin());
        rowViewHolder.url.setText(pullRequest.getUrl());

    }

    @Override
    public int getItemCount() {
        if (pullRequestActivities != null)
            return pullRequestActivities.size();
        return 0;
    }

    class RowViewHolder extends RecyclerView.ViewHolder {
        public TextView login;
        public TextView url;
        public TextView body;

        public RowViewHolder(View view) {
            super(view);
            this.login = (TextView) view.findViewById(R.id.login);
            this.url = (TextView) view.findViewById(R.id.url);
            this.body = (TextView) view.findViewById(R.id.body);
        }
    }
}
