package org.quantumbadger.redreader.mvvm;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.quantumbadger.redreader.mvvm.utils.ThemeManager;

public class CardDetailsActivity extends AppCompatActivity {

    private WebView webView;
    private TextView titleView;
    private ImageView backIcon;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeManager.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);

        titleView = findViewById(R.id.detail_title);
        backIcon = findViewById(R.id.icon_back);
        webView = findViewById(R.id.detail_webview);

        // Get data from intent
        String title = getIntent().getStringExtra("TITLE");
        String redditUrl = getIntent().getStringExtra("URL");

        titleView.setText(title);

        // Back icon
        backIcon.setOnClickListener(v -> onBackPressed());

        // WebView setup
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(redditUrl);
    }

    @SuppressLint("GestureBackNavigation")
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}