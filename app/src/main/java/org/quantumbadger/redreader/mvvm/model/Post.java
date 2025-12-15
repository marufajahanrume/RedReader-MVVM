package org.quantumbadger.redreader.mvvm.model;

public class Post {
    private String title;
    private String author;
    private String subreddit;
    private String imageUrl, redditurl1;
    private int upvotes;

    public Post(String title, String author, String subreddit, String imageUrl,String redditurl, int upvotes) {
        this.title = title;
        this.author = author;
        this.subreddit = subreddit;
        this.imageUrl = imageUrl;
        this.redditurl1 = redditurl;
        this.upvotes = upvotes;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public String getRedditUrl() {
        return redditurl1;
    }

    public void setRedditurl(String redditurl1) {
        this.redditurl1 = redditurl1;
    }

    public String getSubreddit() { return subreddit; }
    public String getImageUrl() { return imageUrl; }
    public int getUpvotes() { return upvotes; }


}
