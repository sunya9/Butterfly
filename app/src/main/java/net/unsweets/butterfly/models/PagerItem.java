package net.unsweets.butterfly.models;

import android.support.v4.app.Fragment;

public class PagerItem {
    private final static String TAG = PagerItem.class.getSimpleName();
    private final Fragment mFragment;
    private final String mTitle;

    public Fragment getFragment() {
        return mFragment;
    }

    public String getTitle() {
        return mTitle;
    }

    public PagerItem(String title, Fragment fragment) {
        mTitle = title;

        mFragment = fragment;
    }
}
