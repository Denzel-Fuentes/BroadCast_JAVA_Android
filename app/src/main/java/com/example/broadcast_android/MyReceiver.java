package com.example.broadcast_android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class MyReceiver  extends BroadcastReceiver {
    private TextView textView;

    public MyReceiver(TextView textView) {
        this.textView = textView;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(MainActivity.CUSTOM_BROADCAST_ACTION)) {
            textView.setText(intent.getStringExtra("dato"));
        }
    }
}