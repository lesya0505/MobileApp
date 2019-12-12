package com.lesenia.mobile;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


@SuppressLint("Registered")
public class NotificationActivity extends AppCompatActivity {

    private Button btnShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Button btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(view -> startActivity(new Intent(NotificationActivity.this, ListFragment.class)));
    }
}