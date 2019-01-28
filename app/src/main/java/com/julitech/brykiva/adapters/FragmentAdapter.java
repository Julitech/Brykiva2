package com.julitech.brykiva.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.julitech.brykiva.fragments.CodeFragment;
import com.julitech.brykiva.fragments.LearnFragment;
import com.julitech.brykiva.fragments.HomeFragment;
import com.julitech.brykiva.fragments.QuestionsFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new LearnFragment();
            case 2:
                return new CodeFragment();
            case 3:
                return new QuestionsFragment();
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return 4;
    }
}
