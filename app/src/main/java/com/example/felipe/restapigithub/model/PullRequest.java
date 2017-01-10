package com.example.felipe.restapigithub.model;

/**
 * Created by Felipe on 09/01/2017.
 */

public class PullRequest {

    private Integer id;
    private String url;
    private User user;
    private String body;

    public Integer getId() {
        return id;
    }

    public PullRequest setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PullRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    public User getUser() {
        return user;
    }

    public PullRequest setUser(User user) {
        this.user = user;
        return this;
    }

    public String getBody() {
        return body;
    }

    public PullRequest setBody(String body) {
        this.body = body;
        return this;
    }
}
