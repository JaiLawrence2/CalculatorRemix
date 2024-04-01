package edu.jsu.mcis.cs408.lab5a_cs408;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class TabLayoutAdapter extends FragmentStateAdapter {

    public static final int NUM_TABS = 3;
    private ArrayList<Fragment> tabs;

    public TabLayoutAdapter(Fragment fragment) {

        super(fragment);

        tabs = new ArrayList<>();

        tabs.add(new TipFragment());
        tabs.add(new TempFragment());
        tabs.add(new DistanceFragment()); // replace later

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        /*Fragment fragment = null;
        if (position == 0){
            tabs.add(new TipFragment());
        }
        else if(position == 1){
            tabs.add(new TempFragment());
        }
        else{
            //tabs.add(new DistanceFragment());
            //fragment = new DistanceFragment();
        }
        Bundle args = new Bundle();
        args.putInt(TabLayoutFragment.ARG_ID, position + 1);
        fragment.setArguments(args);*/

        return tabs.get(position);

    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

}
