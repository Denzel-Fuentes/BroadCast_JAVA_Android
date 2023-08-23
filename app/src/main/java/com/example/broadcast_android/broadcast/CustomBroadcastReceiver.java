package com.example.broadcast_android.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomBroadcastReceiver extends BroadcastReceiver {
    TextView txt;
    List<TextView> txts = new ArrayList<>();
    private static CustomBroadcastReceiver instance;
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(CustomBroadcastIntent.ACTION_CUSTOM_BROADCAST)) {
            String receivedData = intent.getStringExtra(CustomBroadcastIntent.EXTRA_DATA);
            String[] arregloDeStrings = receivedData.split(",");
            for (int i = 0; i < txts.size() ; i++) {
                txts.get(i).setText(arregloDeStrings[i]);
            }

        }
    }
    public static CustomBroadcastReceiver getInstance() {
        if (instance == null) {
            synchronized (CustomBroadcastReceiver.class) {
                if (instance == null) {
                    instance = new CustomBroadcastReceiver();
                }
            }
        }
        return instance;
    }

    public void addTxt(TextView txt){
        txts.add(txt);
    };

}