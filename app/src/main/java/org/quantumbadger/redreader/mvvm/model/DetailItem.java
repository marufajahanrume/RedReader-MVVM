package org.quantumbadger.redreader.mvvm.model;

public class DetailItem {
    private String title;
    private String description;
    private String imageUrl;
    private double rating;
    private int votes;
    private String publishDate;
    private int imageResId;
    private boolean isLocalImage = false;

    public DetailItem(String title, String description, String imageUrl, double rating, int votes, String publishDate) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.votes = votes;
        this.publishDate = publishDate;
    }

    public DetailItem(String title, String desc, int imageResId, double rating, int votes, String publishDate) {
        this.title = title;
        this.description = desc;
        this.imageResId = imageResId;
        this.rating = rating;
        this.votes = votes;
        this.publishDate = publishDate;
        this.isLocalImage = true;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; }
    public double getRating() { return rating; }
    public int getVotes() { return votes; }
    public String getPublishDate() { return publishDate; }
    public boolean isLocalImage() { return isLocalImage; }
    public int getImageResId() { return imageResId; }
}
