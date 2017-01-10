package com.example.felipe.restapigithub.adapter;

import com.example.felipe.restapigithub.model.Item;

/**
 * Interface para implementação do click para a RecyclerView da MainActivity para gerar Intent para os PullRequest.
 */

public interface OnItemClickListenerRecyclerView {
    void onItemClick(Item item);
}
