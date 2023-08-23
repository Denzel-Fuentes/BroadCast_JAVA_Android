package com.example.broadcast_android.broadcast;

import android.content.Intent;
import android.content.IntentFilter;

public class CustomBroadcastIntent {
    public static final String ACTION_CUSTOM_BROADCAST = "com.example.CUSTOM_BROADCAST";
    public static final String EXTRA_DATA = "data";

    public static Intent createIntent(String data) {
        Intent intent = new Intent(ACTION_CUSTOM_BROADCAST);
        intent.putExtra(EXTRA_DATA, data);
        return intent;
    }
    public static IntentFilter createFilter() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_CUSTOM_BROADCAST);
        return filter;
    }
}