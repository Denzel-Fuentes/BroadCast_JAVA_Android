package com.example.broadcast_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.broadcast_android.broadcast.CustomBroadcastIntent;
import com.example.broadcast_android.broadcast.CustomBroadcastReceiver;

public class MainActivity2 extends AppCompatActivity {

    private CustomBroadcastReceiver dynamicReceiver;
    TextView txt ;
    TextView txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt = findViewById(R.id.txt1);
        findViewById(R.id.btnSiguiente).setOnClickListener(
                v->ActivityNavigation.navigateToActivity(this,MainActivity3.class));

        dynamicReceiver = CustomBroadcastReceiver.getInstance();
        dynamicReceiver.addTxt(txt);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    public void sendCustomBroadcast(View view) {
        String dataToSend = "Hello, this is a custom broadcast!";
        Intent customBroadcastIntent = CustomBroadcastIntent.createIntent(dataToSend);
        sendOrderedBroadcast(customBroadcastIntent, null);
    }
}