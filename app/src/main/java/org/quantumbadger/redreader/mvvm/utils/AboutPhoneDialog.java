package org.quantumbadger.redreader.mvvm.utils;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.quantumbadger.redreader.mvvm.R;
import org.quantumbadger.redreader.mvvm.SettingsActivity;

public class AboutPhoneDialog extends Dialog {
    private final Activity activity;

    public AboutPhoneDialog(@NonNull Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_about_phone);

        setCancelable(true);

        // Get device info
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        String androidVersion = Build.VERSION.RELEASE;
        int sdkVersion = Build.VERSION.SDK_INT;

        // App version
        String appVersion = "Unknown";
        try {
            appVersion = activity.getPackageManager()
                    .getPackageInfo(activity.getPackageName(), 0).versionName;
        } catch (Exception ignored) {}

        // Bind views
        TextView deviceName = findViewById(R.id.deviceName);
        TextView androidVer = findViewById(R.id.androidVersion);
        TextView sdkVer = findViewById(R.id.sdkVersion);
        TextView appVer = findViewById(R.id.appVersion);
        TextView closeBtn = findViewById(R.id.closeButton);

        deviceName.setText(manufacturer.toUpperCase() + " " + model);
        androidVer.setText("Android Version: " + androidVersion);
        sdkVer.setText("SDK Level: " + sdkVersion);
        appVer.setText("App Version: " + appVersion);

        closeBtn.setOnClickListener(v -> dismiss());
    }
}
