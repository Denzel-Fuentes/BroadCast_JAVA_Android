package com.example.broadcast_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.broadcast_android.broadcast.CustomBroadcastReceiver;

public class MainActivity4 extends AppCompatActivity {
    private CustomBroadcastReceiver dynamicReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        TextView txt = findViewById(R.id.txt3);
        dynamicReceiver = CustomBroadcastReceiver.getInstance();
        dynamicReceiver.addTxt(txt);
        findViewById(R.id.btnSiguiente).setOnClickListener(
                v->ActivityNavigation.navigateToActivity(this,MainActivity5.class));
    }
}