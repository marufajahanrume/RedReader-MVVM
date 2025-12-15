package org.quantumbadger.redreader.mvvm.model;

public class UserPost {

    private String title;
    private String subreddit;
    private int upvotes;
    private int comments;
    private String time;

    public UserPost(String title, String subreddit, int upvotes, int comments, String time) {
        this.title = title;
        this.subreddit = subreddit;
        this.upvotes = upvotes;
        this.comments = comments;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public int getComments() {
        return comments;
    }

    public String getTime() {
        return time;
    }
}
