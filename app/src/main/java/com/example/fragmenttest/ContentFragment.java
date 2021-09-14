package com.example.fragmenttest;

import android.view.Menu;
import android.view.MenuInflater;

import androidx.fragment.app.Fragment;

public class ContentFragment extends Fragment {
    public ContentFragment() {
        super(R.layout.content_fragment);
        setHasOptionsMenu(true);
    }
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.topbar, menu);
    }
}
