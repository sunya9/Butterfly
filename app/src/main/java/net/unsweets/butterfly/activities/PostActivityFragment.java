package net.unsweets.butterfly.activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.unsweets.butterfly.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PostActivityFragment extends Fragment {

    public PostActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post, container, false);
    }
}