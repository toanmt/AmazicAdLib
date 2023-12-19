package com.amazic.ads.admob.unit.app_open;

import android.app.Activity;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CheckShowAd {
    private final List<Class<?>> listActivityDisable = new ArrayList<>();

    public void disableAppResumeWithActivity(@NonNull Class<?> activityClass) {
        listActivityDisable.add(activityClass);
    }

    public void enableAppResumeWithActivity(@NonNull Class<?> activityClass) {
        listActivityDisable.remove(activityClass);
    }

    public boolean isShowAd(Activity currentActivity) {
        for (Class<?> activity : listActivityDisable) {
            if (currentActivity.getClass() == activity)
                return false;
        }
        return true;
    }
}
