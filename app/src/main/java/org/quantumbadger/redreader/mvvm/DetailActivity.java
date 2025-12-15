package org.quantumbadger.redreader.mvvm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.quantumbadger.redreader.mvvm.adapter.DetailAdapter;
import org.quantumbadger.redreader.mvvm.model.DetailItem;
import org.quantumbadger.redreader.mvvm.utils.ThemeManager;
import org.quantumbadger.redreader.mvvm.viewmodel.DetailViewModel;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DetailAdapter adapter;
    private DetailViewModel viewModel;
    private List<DetailItem> detailList = new ArrayList<>();

    private TextView detailHeader;
    private ImageView iconBack;
    private ImageView iconProfile, iconSearch, iconRefresh, iconSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeManager.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initializeViews();
        initViews();
        setupRecycler();
        loadData();
    }

    private void initializeViews() {
        // Toolbar
        iconProfile = findViewById(R.id.icon_profile);
        iconSearch = findViewById(R.id.icon_search);
        iconSettings = findViewById(R.id.icon_settings);

        iconProfile.setOnClickListener(v -> {
            Intent intent = new Intent(DetailActivity.this, UserProfileActivity.class);
            startActivity(intent);
        });

        iconSearch.setOnClickListener(v ->
                Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show());
        iconSettings.setOnClickListener(v -> {
            Intent intent = new Intent(DetailActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

    }

    private void initViews() {
        recyclerView = findViewById(R.id.detail_recycler);
        detailHeader = findViewById(R.id.detail_title_header);
    }

    private void setupRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DetailAdapter(this, detailList);
        recyclerView.setAdapter(adapter);
    }

    private void loadData() {
        String category = getIntent().getStringExtra("CATEGORY_TYPE");
        detailHeader.setText(category + " Posts");

        viewModel = new ViewModelProvider(this).get(DetailViewModel.class);
        viewModel.getDetails(category).observe(this, items -> {
            detailList.clear();
            detailList.addAll(items);
            adapter.notifyDataSetChanged();
        });
    }
}
