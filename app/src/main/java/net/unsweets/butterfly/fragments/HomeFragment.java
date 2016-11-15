package net.unsweets.butterfly.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.*;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.unsweets.butterfly.R;
import net.unsweets.butterfly.models.PagerItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener {
    private static final String TAG = HomeFragment.class.getSimpleName();
    private PagerItem pagerItem[];
    private View mView;

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(mView == null) {
            mView = inflater.inflate(R.layout.fragment_home, container, false);
        }
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState == null) {
            setupTabs();
        }
    }

    private void setupTabs() {
        pagerItem = new PagerItem[] {
            new PagerItem(getString(R.string.stream), StreamFragment.newInstance()),
            new PagerItem(getString(R.string.mentions), StreamFragment.newInstance()),
        };
        TabLayout tab = (TabLayout) mView.findViewById(R.id.home_tab_bar);
        ViewPager viewPager = (ViewPager) mView.findViewById(R.id.home_viewpager);
        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public int getCount() {
                return pagerItem.length;
            }

            @Override
            public Fragment getItem(int position) {
                return pagerItem[position].getFragment();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return pagerItem[position].getTitle();
            }

        };
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(this);
        tab.setupWithViewPager(viewPager);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
