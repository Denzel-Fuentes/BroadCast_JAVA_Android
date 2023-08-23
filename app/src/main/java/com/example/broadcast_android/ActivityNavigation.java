package com.example.broadcast_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class ActivityNavigation {
    public static void navigateToActivity(Context context, Class<? extends Activity> targetActivity) {
        Intent intent = new Intent(context, targetActivity);
        context.startActivity(intent);
    }

    public static void navigateToActivityAndFinishCurrent(Context context, Class<? extends Activity> targetActivity) {
        navigateToActivity(context, targetActivity);
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }
}
