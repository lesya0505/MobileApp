package com.lesenia.mobile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.firebase.messaging.FirebaseMessaging;

import android.content.Intent;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lesenia.mobile.R;
import com.lesenia.mobile.TabsAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private FloatingActionButton floatingActionButton;
    private static final String[] tabTitles = {"Medicine", "Tab 2", "Profile"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        floatingActionButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, PostMedicineActivity.class)));

        final TabLayout tabLayout = findViewById(R.id.main_activity_tab);
        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(tabTitles[position]);
                    }
                }
        ).attach();
    }

        private void initViews() {
            floatingActionButton = findViewById(R.id.floating_action_button);
            viewPager = findViewById(R.id.main_activity_view_pager);
            TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager(), getLifecycle());
            viewPager.setAdapter(tabsAdapter);
        }


    }