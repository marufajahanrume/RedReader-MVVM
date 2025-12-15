package org.quantumbadger.redreader.mvvm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.quantumbadger.redreader.mvvm.utils.AboutPhoneDialog;
import org.quantumbadger.redreader.mvvm.utils.AppPreferenceManager;
import org.quantumbadger.redreader.mvvm.utils.ThemeManager;

public class SettingsActivity extends AppCompatActivity {

    // Layout holders for each setting
    private LinearLayout layoutAccount, layoutAppearance, layoutNotifications,
            layoutPrivacy, layoutDataUsage, layoutAppPreferences, layoutClearCache,
            layoutHelp, layoutTerms, layoutAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeManager.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initViews();
        initClicks();
    }

    private void initViews() {
        layoutAccount = findViewById(R.id.layoutAccount);
        layoutAppearance = findViewById(R.id.layoutAppearance);
        layoutNotifications = findViewById(R.id.layoutNotifications);
        layoutPrivacy = findViewById(R.id.layoutPrivacy);
        layoutDataUsage = findViewById(R.id.layoutDataUsage);
        layoutAppPreferences = findViewById(R.id.layoutAppPreferences);
        layoutClearCache = findViewById(R.id.layoutClearCache);
        layoutHelp = findViewById(R.id.layoutHelp);
        layoutTerms = findViewById(R.id.layoutTerms);
        layoutAbout = findViewById(R.id.layoutAbout);
    }

    private void initClicks() {
        layoutAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, UserProfileActivity.class);
                startActivity(intent);
            }
        });
        layoutNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, Notifications.class);
                intent.putExtra("type", "notifications");
                startActivity(intent);
            }
        });
        layoutPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, Notifications.class);
                intent.putExtra("type", "privacy");
                startActivity(intent);
            }
        });
        layoutHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, Notifications.class);
                intent.putExtra("type", "help");
                startActivity(intent);
            }
        });
        layoutTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, Notifications.class);
                intent.putExtra("type", "terms");
                startActivity(intent);
            }
        });

        layoutAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAboutPhoneDialog();
            }
        });

        layoutAppearance.setOnClickListener(v -> showThemeDialog());
        layoutDataUsage.setOnClickListener(v -> toast("Data Usage"));
        layoutAppPreferences.setOnClickListener(v -> showAppPreferencesDialog());
        layoutClearCache.setOnClickListener(v -> showClearCacheDialog());
    }

    private void showAboutPhoneDialog() {
        AboutPhoneDialog dialog = new AboutPhoneDialog(this);
        dialog.show();
    }

    private void showClearCacheDialog() {
        final String[] options = {
                "Clear cache: Last Hour",
                "Clear cache: Last 6 Hours",
                "Clear cache: Last Day",
                "Clear All Cache"
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Clear Cache");

        builder.setItems(options, (dialog, which) -> {

            String selected = options[which];
            Toast.makeText(this, selected, Toast.LENGTH_SHORT).show();

            dialog.dismiss();
        });

        builder.show();
    }

    private void showAppPreferencesDialog() {
        final String[] options = {
                "Home",
                "Trending",
                "All Post"
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("App Preferences");

        builder.setItems(options, (dialog, which) -> {
            String selected = options[which];

            // Save the index as preference
            AppPreferenceManager.setDefaultHomeScreen(this, which);

            Toast.makeText(this, "Default Home Screen: " + selected, Toast.LENGTH_SHORT).show();

            dialog.dismiss();
        });

        builder.show();
    }

    private void showThemeDialog() {
        final String[] themes = {"Light Mode", "Dark Mode"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Theme");

        builder.setItems(themes, (dialog, which) -> {

            if (which == 0) {
                // LIGHT
                ThemeManager.setTheme(this, AppCompatDelegate.MODE_NIGHT_NO);
                Toast.makeText(this, "Light Mode Enabled", Toast.LENGTH_SHORT).show();
            } else {
                // DARK
                ThemeManager.setTheme(this, AppCompatDelegate.MODE_NIGHT_YES);
                Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show();
            }

            dialog.dismiss();

            // Restart activity to apply immediately
            recreate();
        });

        builder.show();
    }


    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}