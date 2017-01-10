package com.example.felipe.restapigithub.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.felipe.restapigithub.R;
import com.example.felipe.restapigithub.adapter.PullRequestAdapterRecyclerView;
import com.example.felipe.restapigithub.rest.Retro;

public class PullRequestActivity extends AppCompatActivity {
    Context context = this;
    Screen screen;
    private Retro retro;

    public class Screen {
        public RecyclerView recyclerView;
        public PullRequestAdapterRecyclerView adapter;

        public Screen() {
            recyclerView = (RecyclerView) findViewById(R.id.myRecyclerViewPullRequest);
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            adapter = new PullRequestAdapterRecyclerView(null);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_request);
        screen = new Screen();
        Intent intent = getIntent();
        String owner = intent.getStringExtra("owner");
        String repository = intent.getStringExtra("repository");
        retro = new Retro(context);
        callRepositories(owner, repository);

    }

    public void callRepositories(String owner, String repository) {
        retro.getPullRequest(screen, owner, repository);
    }


}
