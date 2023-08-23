package com.example.broadcast_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static final String CUSTOM_BROADCAST_ACTION = "practica.univalle.basicretrofitadapter.CUSTOM_ACTION";
    MyReceiver myReceiver ;
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button broadcastButton = findViewById(R.id.broadcast_button);
        textView = findViewById(R.id.result_text);
        editText = findViewById(R.id.editTextText);
        Intent customBroadcastIntent = new Intent(CUSTOM_BROADCAST_ACTION);
        broadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customBroadcastIntent.putExtra("dato",editText.getText().toString());
                sendBroadcast(customBroadcastIntent);
            }
        });
        if (myReceiver == null) {
            myReceiver = new MyReceiver(textView);
            IntentFilter intentFilter = new IntentFilter(CUSTOM_BROADCAST_ACTION);
            registerReceiver(myReceiver, intentFilter);
        }
    }
}