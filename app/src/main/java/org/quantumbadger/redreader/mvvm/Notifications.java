package org.quantumbadger.redreader.mvvm;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.quantumbadger.redreader.mvvm.adapter.NotificationsAdapter;
import org.quantumbadger.redreader.mvvm.model.NotificationItem;
import org.quantumbadger.redreader.mvvm.utils.ThemeManager;

import java.util.ArrayList;
import java.util.List;

public class Notifications extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeManager.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        recyclerView = findViewById(R.id.recyclerView);
        webView = findViewById(R.id.webView);

        String type = getIntent().getStringExtra("type");

        if (type == null) type = "";

        switch (type) {
            case "notifications":
                showNotificationsList();
                break;

            case "privacy":
                showWebView("https://www.redditinc.com/policies/privacy-policy");
                break;

            case "help":
                showWebView("https://support.reddithelp.com/");
                break;

            case "terms":
                showWebView("https://www.redditinc.com/policies/user-agreement");
                break;

            case "about":
                showWebView("https://www.redditinc.com/");
                break;
        }

    }

    private void showWebView(String url) {
        recyclerView.setVisibility(View.GONE);
        webView.setVisibility(View.VISIBLE);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);

        webView.setWebViewClient(new WebViewClient()); // prevents opening browser
        webView.loadUrl(url);
    }

    private void showNotificationsList() {
        webView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        List<NotificationItem> items = new ArrayList<>();

        items.add(new NotificationItem("New follower", "u/techguy123 started following you.", "2h ago"));
        items.add(new NotificationItem("Comment reply", "u/spacewizard replied to your comment in r/Android.", "3h ago"));
        items.add(new NotificationItem("Post upvoted", "Your post in r/RedReader received 42 upvotes!", "5h ago"));
        items.add(new NotificationItem("Message received", "You received a new message from u/admin.", "6h ago"));
        items.add(new NotificationItem("Mentioned", "You were mentioned in a thread in r/Technology.", "7h ago"));

        items.add(new NotificationItem("Comment upvoted", "Your comment in r/Programming received 12 upvotes.", "9h ago"));
        items.add(new NotificationItem("Thread trending", "Your post is trending in r/AndroidDev!", "11h ago"));
        items.add(new NotificationItem("Moderator invite", "You've been invited to moderate r/CoolPeople.", "14h ago"));
        items.add(new NotificationItem("Award received", "Your post received a Silver Award!", "15h ago"));
        items.add(new NotificationItem("New subscriber", "Someone subscribed to your profile updates.", "18h ago"));

        items.add(new NotificationItem("Post saved", "u/redreaderfan saved your post in r/Android.", "1d ago"));
        items.add(new NotificationItem("Weekly recap", "Your top comment this week was in r/Technology.", "1d ago"));
        items.add(new NotificationItem("Post commented", "You got 3 new comments in r/Pixel.", "1d ago"));
        items.add(new NotificationItem("New vote", "Your post in r/Science received a new upvote.", "2d ago"));
        items.add(new NotificationItem("New message", "u/bigbrain sent you a message.", "2d ago"));

        items.add(new NotificationItem("Community growth", "r/RedReader gained 50 new members today.", "2d ago"));
        items.add(new NotificationItem("Feedback request", "Moderators of r/Tech ask for your feedback.", "3d ago"));
        items.add(new NotificationItem("Achievement unlocked", "You reached 100 total karma!", "3d ago"));
        items.add(new NotificationItem("Security update", "Review new account safety recommendations.", "4d ago"));
        items.add(new NotificationItem("Event reminder", "Reddit AMA with developers starts soon.", "4d ago"));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NotificationsAdapter(items));
    }

}