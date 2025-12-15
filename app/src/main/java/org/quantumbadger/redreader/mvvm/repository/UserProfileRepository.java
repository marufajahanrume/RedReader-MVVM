package org.quantumbadger.redreader.mvvm.repository;

import org.quantumbadger.redreader.mvvm.model.UserPost;
import org.quantumbadger.redreader.mvvm.model.UserProfile;

import java.util.ArrayList;
import java.util.List;

public class UserProfileRepository {

    public UserProfile getUserProfile() {

        return new UserProfile(
                "TechExplorer99",
                5423,                           // Post Karma
                2891,                           // Comment Karma
                "12 June, 2025",                // Cake Day
                "Software developer. Coffee lover. Android UI enthusiast.", // Bio
                "",                             // Avatar placeholder (URL empty)
                "Male",
                27,
                "US",
                "Music, Gaming, Hiking",
                "Student",
                "English"
        );
    }


    /** Returns a dummy list of posts belonging to the user */
    public List<UserPost> getUserPosts() {
        List<UserPost> posts = new ArrayList<>();

        posts.add(new UserPost(
                "Just migrated my project to MVVM — feels so much cleaner now!",
                "androiddev",
                125,
                14,
                "2h ago"
        ));

        posts.add(new UserPost(
                "How do you structure repository classes in large apps?",
                "learnprogramming",
                89,
                22,
                "5h ago"
        ));

        posts.add(new UserPost(
                "Finally understood RecyclerView DiffUtil — game changer!",
                "android",
                210,
                34,
                "1d ago"
        ));

        posts.add(new UserPost(
                "Which architecture do you prefer for Android? MVC vs MVVM vs MVI?",
                "androidquestions",
                76,
                19,
                "2d ago"
        ));

        posts.add(new UserPost(
                "Sharing my first open-source contribution 🎉",
                "opensource",
                154,
                27,
                "3d ago"
        ));

        posts.add(new UserPost(
                "What are your top debugging tips for junior developers?",
                "programming",
                98,
                16,
                "4d ago"
        ));

        return posts;
    }
}
