package com.example.felipe.restapigithub.model;

/**
 * Created by Felipe on 09/01/2017.
 */

public class User {

    private String login;
    private String avatarUrl;

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public User setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }
}
