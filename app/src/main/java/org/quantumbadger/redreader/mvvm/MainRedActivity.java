package org.quantumbadger.redreader.mvvm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.quantumbadger.redreader.mvvm.adapter.PostAdapter;
import org.quantumbadger.redreader.mvvm.model.Post;
import org.quantumbadger.redreader.mvvm.utils.AppPreferenceManager;
import org.quantumbadger.redreader.mvvm.utils.ThemeManager;
import org.quantumbadger.redreader.mvvm.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainRedActivity extends AppCompatActivity {

    // Toolbar icons
    private ImageView iconProfile, iconSearch, iconRefresh, iconSettings;

    // Category cards
    private androidx.cardview.widget.CardView cardTrending, cardFavourite, cardAll;

    // RecyclerView
    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private HomeViewModel viewModel;
    private final List<Post> postList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeManager.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_red);
//        checkDefaultHomeScreen();

        initializeViews();
        setupToolbar();
        setupCategoryCards();
        setupRecyclerView();
        setupViewModel();
    }

    private void checkDefaultHomeScreen() {
        Integer screen = AppPreferenceManager.getDefaultHomeScreen(MainRedActivity.this);

// NULL CHECK
        if (screen == null) {
            screen = AppPreferenceManager.HOME; // fallback to default
        }

        switch (screen) {
            case AppPreferenceManager.HOME:
                break;

            case AppPreferenceManager.TRENDING:
                openTrendingScreen();
                break;

            case AppPreferenceManager.ALL_POST:
                openAllPostsScreen();
                break;

//            case AppPreferenceManager.LAST_OPENED:
//                openLastOpenedScreen();
//                break;

            default:
                // fallback in case unexpected value appears
                break;
        }
    }

    private void openLastOpenedScreen() {
    }

    private void openAllPostsScreen() {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("CATEGORY_TYPE", "All");
        startActivity(intent);
    }

    private void openTrendingScreen() {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("CATEGORY_TYPE", "Trending");
        startActivity(intent);
    }

    // --------------------------
    // 🔧 1. Initialize All Views
    // --------------------------
    private void initializeViews() {
        // Toolbar
        iconProfile = findViewById(R.id.icon_profile);
        iconSearch = findViewById(R.id.icon_search);
        iconRefresh = findViewById(R.id.icon_refresh);
        iconSettings = findViewById(R.id.icon_settings);

        // Category Cards
        cardTrending = findViewById(R.id.card_trending);
        cardFavourite = findViewById(R.id.card_favourite);
        cardAll = findViewById(R.id.card_all);

        // RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
    }

    // --------------------------
    // 🧭 2. Toolbar Actions
    // --------------------------
    private void setupToolbar() {
        iconProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainRedActivity.this, UserProfileActivity.class);
            startActivity(intent);
        });

        iconSearch.setOnClickListener(v ->
                Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show());

        iconRefresh.setOnClickListener(v -> {
            Toast.makeText(this, "Refreshing...", Toast.LENGTH_SHORT).show();
            viewModel.getMorePosts().observe(this, posts -> {
                postList.clear();
                postList.addAll(posts);
                adapter.notifyDataSetChanged();
            });
        });

        iconSettings.setOnClickListener(v -> {
            Intent intent = new Intent(MainRedActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
    }

    // --------------------------
    // 📦 3. Category Cards Setup
    // --------------------------
    private void setupCategoryCards() {
        cardTrending.setOnClickListener(v -> {
            openDetails("Trending");
        });
        cardFavourite.setOnClickListener(v -> openDetails("Favourite"));
        cardAll.setOnClickListener(v -> openDetails("All"));
    }

    private void openDetails(String category) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("CATEGORY_TYPE", category);
        startActivity(intent);
    }

    // --------------------------
    // 🧩 4. RecyclerView Setup
    // --------------------------
    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PostAdapter(this, postList);
        recyclerView.setAdapter(adapter);
    }

    // --------------------------
    // 🧠 5. ViewModel Data
    // --------------------------
    private void setupViewModel() {
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        viewModel.getMorePosts().observe(this, posts -> {
            postList.clear();
            postList.addAll(posts);
            adapter.notifyDataSetChanged();
        });
    }
}
