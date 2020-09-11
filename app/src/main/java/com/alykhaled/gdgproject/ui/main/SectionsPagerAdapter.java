package com.alykhaled.gdgproject.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.alykhaled.gdgproject.LearningFragment;
import com.alykhaled.gdgproject.R;
import com.alykhaled.gdgproject.SkillFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                LearningFragment learningfragment = new LearningFragment();
                return learningfragment;
            case 1:
                SkillFragment skillfragment = new SkillFragment();
                return skillfragment;
            default:
                return null;
        }
    }

    @Nullable

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}