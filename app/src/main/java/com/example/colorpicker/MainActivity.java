package com.example.colorpicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnMessageSendListener {

    FragmentManager fg_manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fg_manager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            fg_manager.beginTransaction().replace(R.id.top_container_FG, new ColorPickFragment()).commit();
            fg_manager.beginTransaction().replace(R.id.bottom_container_FG, new HistoryFragment()).commit();
        }
    }

    @Override
    public void onMessageSend(String message) {
        HistoryFragment hist_fragment = new HistoryFragment();
        hist_fragment.addColor(message);
    }
}