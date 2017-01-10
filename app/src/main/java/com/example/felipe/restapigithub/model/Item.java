package com.example.felipe.restapigithub.model;

/**
 * Created by Felipe on 09/01/2017.
 */

public class Item {
    private Integer id;
    private String name;
    private String url;
    private Owner owner;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Item setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Item setUrl(String url) {
        this.url = url;
        return this;
    }

    public Owner getOwner() {
        return owner;
    }

    public Item setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public String getLogin() {
        return owner.getLogin();
    }
}
