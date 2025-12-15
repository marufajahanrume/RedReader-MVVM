package org.quantumbadger.redreader.mvvm;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.quantumbadger.redreader.mvvm.adapter.UserPostsAdapter;
import org.quantumbadger.redreader.mvvm.model.UserPost;
import org.quantumbadger.redreader.mvvm.model.UserProfile;
import org.quantumbadger.redreader.mvvm.repository.UserProfileRepository;
import org.quantumbadger.redreader.mvvm.utils.ThemeManager;

import java.util.ArrayList;
import java.util.List;

public class UserProfileActivity extends AppCompatActivity {

    // Profile UI elements
    private ImageView ivAvatar;
    private TextView tvUsername, tvBio;
    private TextView tvGender, tvAge, tvLocation, tvHobbies, tvOccupation, tvLanguages;
    private TextView tvPostKarma, tvCommentKarma;

    // RecyclerView
    private RecyclerView rvUserPosts;

    // Repository (simulating API)
    private UserProfileRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeManager.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        repository = new UserProfileRepository();

        initViews();
        loadUserProfile();
        loadUserPosts();
    }

    /** Initialize layout views */
    private void initViews() {
        ivAvatar = findViewById(R.id.ivAvatar);
        tvUsername = findViewById(R.id.tvUsername);
        tvBio = findViewById(R.id.tvBio);

        tvGender = findViewById(R.id.tvGender);
        tvAge = findViewById(R.id.tvAge);
        tvLocation = findViewById(R.id.tvLocation);
        tvHobbies = findViewById(R.id.tvHobbies);
        tvOccupation = findViewById(R.id.tvOccupation);
        tvLanguages = findViewById(R.id.tvLanguages);

        tvPostKarma = findViewById(R.id.tvPostKarma);
        tvCommentKarma = findViewById(R.id.tvCommentKarma);

        rvUserPosts = findViewById(R.id.rvUserPosts);
        rvUserPosts.setLayoutManager(new LinearLayoutManager(this));
    }

    /** Loads static user profile from repository and applies it to UI */
    private void loadUserProfile() {
        UserProfile profile = repository.getUserProfile();

        tvUsername.setText(profile.getUsername());
        tvBio.setText(profile.getBio());

        tvGender.setText("Gender: " + profile.getGender());
        tvAge.setText("Age: " + profile.getAge());
        tvLocation.setText("Location: " + profile.getLocation());
        tvHobbies.setText("Hobbies: " + profile.getHobbies());
        tvOccupation.setText("Occupation: " + profile.getOccupation());
        tvLanguages.setText("Languages: " + profile.getLanguages());

        tvPostKarma.setText("Post Point: " + profile.getPostKarma());
        tvCommentKarma.setText("Comment Point: " + profile.getCommentKarma());

        // Avatar URL is empty → placeholder image is already set in XML
    }

    /** Loads static user posts and binds to RecyclerView */
    private void loadUserPosts() {
        List<UserPost> posts = repository.getUserPosts();
        UserPostsAdapter adapter = new UserPostsAdapter(posts);
        rvUserPosts.setAdapter(adapter);
    }
}