package com.manager.spaclinic.controllers;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerController extends FragmentPagerAdapter {

    int tabsnum;

    public PagerController(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.tabsnum = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new Appointments();
            case 1:
                return new Patients();
            case 2:
                return new Services();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabsnum;
    }
}
