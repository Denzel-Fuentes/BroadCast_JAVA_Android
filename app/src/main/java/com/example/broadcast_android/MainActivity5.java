package com.example.broadcast_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.broadcast_android.broadcast.CustomBroadcastIntent;
import com.example.broadcast_android.broadcast.CustomBroadcastReceiver;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {
    EditText input,input2,input3;
    private CustomBroadcastReceiver dynamicReceiver;
    private List<String> inputs = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        input= findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);

        dynamicReceiver = CustomBroadcastReceiver.getInstance();
        registerReceiver(dynamicReceiver, CustomBroadcastIntent.createFilter());

        findViewById(R.id.btnPublicar).setOnClickListener(v -> {
                inputs.add(input.getText().toString());
            inputs.add(input2.getText().toString());
            inputs.add(input3.getText().toString());
                Intent customBroadcastIntent = CustomBroadcastIntent.createIntent(inputs.toString());
                sendOrderedBroadcast(customBroadcastIntent, null);

        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(dynamicReceiver);
    }
}