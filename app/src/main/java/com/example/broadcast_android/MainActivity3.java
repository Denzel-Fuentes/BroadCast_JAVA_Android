package com.example.broadcast_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.broadcast_android.broadcast.CustomBroadcastReceiver;

public class MainActivity3 extends AppCompatActivity {
    private CustomBroadcastReceiver dynamicReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView txt = findViewById(R.id.txt2);
        dynamicReceiver = CustomBroadcastReceiver.getInstance();
        dynamicReceiver.addTxt(txt);
        findViewById(R.id.btnSiguiente).setOnClickListener(
                v->ActivityNavigation.navigateToActivity(this,MainActivity4.class));
    }
}