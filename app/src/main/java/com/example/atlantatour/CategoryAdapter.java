package com.example.atlantatour;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context context;

    public CategoryAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return new HomeFragment();
        else if(position == 1)
            return new DiningFragment();
        else if(position == 2)
            return new ShoppingFragment();
        else if(position == 3)
            return new VenuesFragment();
        else
            return new NightLifeFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0)
            return "HOME";
        else if(position == 1)
            return "DINING";
        else if(position == 2)
            return "SHOPPING";
        else if(position == 3)
            return "VENUES";
        else
            return "NIGHTLIFE";
    }

    @Override
    public int getCount() {
        return 5;
    }
}
