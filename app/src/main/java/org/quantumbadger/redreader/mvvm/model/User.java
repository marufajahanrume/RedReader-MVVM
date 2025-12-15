package org.quantumbadger.redreader.mvvm.model;

public class User {
    private String username;
    private String avatarUrl;
    private int karma;

    public User(String username, String avatarUrl, int karma) {
        this.username = username;
        this.avatarUrl = avatarUrl;
        this.karma = karma;
    }

    public String getUsername() { return username; }
    public String getAvatarUrl() { return avatarUrl; }
    public int getKarma() { return karma; }
}
