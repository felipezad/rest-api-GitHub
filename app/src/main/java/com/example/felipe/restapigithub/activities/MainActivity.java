package com.example.felipe.restapigithub.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.Toast;

import com.example.felipe.restapigithub.R;
import com.example.felipe.restapigithub.adapter.OnItemClickListenerRecyclerView;
import com.example.felipe.restapigithub.adapter.RepositoriesAdapterRecyclerView;
import com.example.felipe.restapigithub.model.Item;
import com.example.felipe.restapigithub.model.Repository;
import com.example.felipe.restapigithub.rest.Retro;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    Context context = this;
    Screen screen;
    private Retro retro;

    public class Screen {
        public RecyclerView recyclerView;
        public RepositoriesAdapterRecyclerView adapter;
        public Screen() {
            recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            adapter = new RepositoriesAdapterRecyclerView(new Repository());
            adapter.setOnItemClickListenerRecyclerView(new OnItemClickListenerRecyclerView() {
                @Override
                public void onItemClick(Item item) {
                    Toast.makeText(MainActivity.this, "Carregando pull requests...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, PullRequestActivity.class);
                    intent.putExtra("owner", item.getLogin());
                    intent.putExtra("repository", item.getName());
                    startActivity(intent);

                }
            });
            recyclerView.setAdapter(adapter);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = new Screen();
        retro = new Retro(context);
        callRepositories();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void callRepositories() {
        retro.getRepositories(screen);
    }
}
