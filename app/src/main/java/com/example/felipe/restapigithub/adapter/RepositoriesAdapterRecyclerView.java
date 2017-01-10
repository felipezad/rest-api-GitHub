package com.example.felipe.restapigithub.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.felipe.restapigithub.R;
import com.example.felipe.restapigithub.model.Item;
import com.example.felipe.restapigithub.model.Repository;

/**
 * Created by Felipe on 09/01/2017.
 */

public class RepositoriesAdapterRecyclerView extends RecyclerView.Adapter<RepositoriesAdapterRecyclerView.RowViewHolder> {
    private Repository repository;
    private OnItemClickListenerRecyclerView onItemClickListenerRecyclerView;


    public RepositoriesAdapterRecyclerView() {
    }

    public RepositoriesAdapterRecyclerView(Repository repository) {
        this.repository = repository;
    }


    public OnItemClickListenerRecyclerView getOnItemClickListenerRecyclerView() {
        return onItemClickListenerRecyclerView;
    }

    public RepositoriesAdapterRecyclerView setOnItemClickListenerRecyclerView(OnItemClickListenerRecyclerView onItemClickListenerRecyclerView) {
        this.onItemClickListenerRecyclerView = onItemClickListenerRecyclerView;
        return this;
    }

    public RepositoriesAdapterRecyclerView setRepository(Repository repository) {
        this.repository = repository;
        this.notifyDataSetChanged();
        return this;
    }

    @Override
    public RowViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, null);
        RowViewHolder row = new RowViewHolder(view);
        return row;
    }

    @Override
    public void onBindViewHolder(RowViewHolder rowViewHolder, int position) {
        final Item item = this.repository.getItems().get(position);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListenerRecyclerView.onItemClick(item);
            }
        };
        rowViewHolder.textView.setText(item.getName());
        rowViewHolder.textView.setOnClickListener(onClickListener);

    }

    @Override
    public int getItemCount() {
        return repository.getItems().size();
    }

    class RowViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public RowViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.titleRow);
        }
    }
}
