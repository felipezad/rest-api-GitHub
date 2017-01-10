package com.example.felipe.restapigithub.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felipe on 09/01/2017.
 */

public class Repository {
    private List<Item> items;
    @SerializedName("total_count")
    private Double totalCount;
    @SerializedName("incomplete_results")
    private Boolean incompleteResults;

    public Repository() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public Repository setItems(List<Item> items) {
        this.items = items;
        return this;
    }

    public Double getTotalCount() {
        return totalCount;
    }

    public Repository setTotalCount(Double totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public Repository setIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
        return this;
    }
}
