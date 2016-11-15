package net.unsweets.butterfly.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class BasePostableFragment extends Fragment {
    private final static String TAG = BasePostableFragment.class.getSimpleName();
    private FloatingActionButton fab;

    public BasePostableFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState == null) {
            FragmentActivity activity = getActivity();
        }
    }
}
