package net.unsweets.butterfly.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.unsweets.butterfly.R;
import net.unsweets.butterfly.adapters.StreamAdapter;

import java.util.ArrayList;

public class StreamFragment extends Fragment {
    private final static String TAG = StreamFragment.class.getSimpleName();
    private View mView;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<String> strings;

    public StreamFragment() {
    }

    public static StreamFragment newInstance() {
        StreamFragment fragment = new StreamFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mView == null) {
            mView = inflater.inflate(R.layout.fragment_list, container, false);
        }
        return mView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState == null) {
            setupList();
        }
    }

    private void setupList() {
        RecyclerView recyclerView = (RecyclerView) mView.findViewById(R.id.recycler_list);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        strings = new ArrayList<String>() {{
            add("aaa");
            add("aaa");
            add("aaa");
            add("aaa");
            add("aaa");
            add("aaa");
            add("aaa");
            add("aaa");
            add("aaa");
            add("aaa");
            add("aaa");
            add("aaa");
            add("aaa");
            add("aaa");
        }};
        StreamAdapter<String> adapter = new StreamAdapter<>(strings);
        recyclerView.setAdapter(adapter);
    }
}
