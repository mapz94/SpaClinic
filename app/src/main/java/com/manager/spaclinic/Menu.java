package com.manager.spaclinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.spaclinic.R;
import com.manager.spaclinic.controllers.PagerController;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Menu extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tabAppointments, tabPatients, tabServices;

    PagerController pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);

        tabAppointments = findViewById(R.id.tabAppointments);
        tabPatients = findViewById(R.id.tabPatients);
        tabServices = findViewById(R.id.tabServices);

        pager = new PagerController(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0){
                    pager.notifyDataSetChanged();
                }
                if(tab.getPosition() == 1){
                    pager.notifyDataSetChanged();
                }
                if(tab.getPosition() == 2){
                    pager.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

}