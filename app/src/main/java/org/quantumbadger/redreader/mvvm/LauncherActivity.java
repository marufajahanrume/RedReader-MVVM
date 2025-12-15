package org.quantumbadger.redreader.mvvm;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.quantumbadger.redreader.mvvm.utils.AppPreferenceManager;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Integer screen = AppPreferenceManager.getDefaultHomeScreen(this);
        if (screen == null) screen = AppPreferenceManager.HOME;

        Intent intent;

        switch (screen) {
            case AppPreferenceManager.TRENDING:
                intent = new Intent(this, DetailActivity.class);
                intent.putExtra("CATEGORY_TYPE", "TRENDING");
                break;

            case AppPreferenceManager.ALL_POST:
                intent = new Intent(this, DetailActivity.class);
                intent.putExtra("CATEGORY_TYPE", "All");
                break;

            case AppPreferenceManager.HOME:
                intent = new Intent(this, MainRedActivity.class);
                break;

            default:
                // HOME
                intent = new Intent(this, MainRedActivity.class);
                break;
        }

        startActivity(intent);
        finish(); // important: remove this from back stack
    }
}