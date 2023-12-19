package com.amazic.ads.admob.unit.app_open;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;

public class AppOpenCallback {
    public void onNextAction() {
    }

    public void onLoadedSuccessfully(@NonNull AppOpenAd ad) {
    }

    public void onFailedToLoad(@NonNull LoadAdError loadAdError) {
    }

    public void onFailedToShow(@NonNull AdError error) {
    }

    public void onAdImpression() {
    }


    public void onAdClicked() {
    }

    public void onAdShowed() {
    }

    public void onAdDismissed() {
    }
}
