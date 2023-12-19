package com.amazic.ads.admob.unit.app_open;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

import com.amazic.ads.util.NetworkUtil;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;

public class AppOpenUtil {
    public static void loadAd(Context context, String adUnitID, AppOpenCallback callback) {
        if (!NetworkUtil.isNetworkActive(context)) {
            callback.onFailedToLoad(
                    new LoadAdError(-1, "No Internet!", "", null, null)
            );
            return;
        }
        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(context, adUnitID, request, new AppOpenAd.AppOpenAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull AppOpenAd ad) {
                callback.onLoadedSuccessfully(ad);
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                callback.onFailedToLoad(loadAdError);
            }
        });
    }

    public static void showAd(Activity activity, @NonNull AppOpenAd appOpenAd, AppOpenCallback callback) {
        if (!NetworkUtil.isNetworkActive(activity)) {
            callback.onFailedToLoad(
                    new LoadAdError(-1, "No Internet!", "", null, null)
            );
            return;
        }
        appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() {

            public void onAdClicked() {
                callback.onAdClicked();
            }

            public void onAdDismissedFullScreenContent() {
                callback.onAdDismissed();
                callback.onNextAction();
            }

            public void onAdFailedToShowFullScreenContent(@NonNull AdError var1) {
                callback.onFailedToShow(var1);
            }

            public void onAdImpression() {
                callback.onAdImpression();
            }

            public void onAdShowedFullScreenContent() {
                callback.onAdShowed();
            }
        });
        appOpenAd.show(activity);
    }
}
