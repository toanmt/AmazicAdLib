package com.amazic.ads.admob.unit.app_open;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;

import java.util.ArrayList;
import java.util.List;

public class AppOpenManager {
    private static final String TAG = "AppOpenManager";
    CheckShowAd checkShowAd = new CheckShowAd();

    public void loadAndShow(Activity activity, String adId, AppOpenCallback callback) {
        AppOpenUtil.loadAd(activity, adId, new AppOpenCallback() {
            @Override
            public void onFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onFailedToLoad(loadAdError);
                Log.e(TAG, "onFailedToLoad: " + loadAdError.getMessage());
                callback.onFailedToLoad(loadAdError);
            }

            @Override
            public void onLoadedSuccessfully(@NonNull AppOpenAd ad) {
                super.onLoadedSuccessfully(ad);
                callback.onLoadedSuccessfully(ad);
                AppOpenUtil.showAd(activity, ad, callback);
            }
        });
    }

    public void disableAppResumeWithActivity(@NonNull Activity activityClass) {
        checkShowAd.disableAppResumeWithActivity(activityClass.getClass());
    }

    public void enableAppResumeWithActivity(@NonNull Activity activityClass) {
        checkShowAd.enableAppResumeWithActivity(activityClass.getClass());
    }
}
