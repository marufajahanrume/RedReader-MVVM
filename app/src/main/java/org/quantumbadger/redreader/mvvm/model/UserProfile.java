package org.quantumbadger.redreader.mvvm.model;

public class UserProfile {

    private String username;
    private int postKarma;
    private int commentKarma;
    private String cakeDay;
    private String bio;
    private String avatarUrl;

    private String gender;
    private int age;
    private String location;
    private String hobbies;
    private String occupation;
    private String languages;

    public UserProfile(String username, int postKarma, int commentKarma, String cakeDay,
                       String bio, String avatarUrl, String gender, int age,
                       String location, String hobbies, String occupation, String languages) {

        this.username = username;
        this.postKarma = postKarma;
        this.commentKarma = commentKarma;
        this.cakeDay = cakeDay;
        this.bio = bio;
        this.avatarUrl = avatarUrl;

        this.gender = gender;
        this.age = age;
        this.location = location;
        this.hobbies = hobbies;
        this.occupation = occupation;
        this.languages = languages;
    }

    public String getUsername() { return username; }
    public int getPostKarma() { return postKarma; }
    public int getCommentKarma() { return commentKarma; }
    public String getCakeDay() { return cakeDay; }
    public String getBio() { return bio; }
    public String getAvatarUrl() { return avatarUrl; }

    public String getGender() { return gender; }
    public int getAge() { return age; }
    public String getLocation() { return location; }
    public String getHobbies() { return hobbies; }
    public String getOccupation() { return occupation; }
    public String getLanguages() { return languages; }
}
