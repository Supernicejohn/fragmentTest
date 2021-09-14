package com.example.fragmenttest;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.fragment.app.Fragment;

public class settingsFragment extends Fragment {
    public settingsFragment(){
        super(R.layout.settings_fragment);

    }
    public void onActivityCreated(Bundle b){
        super.onActivityCreated(b);
        Switch switch1 = getActivity().findViewById(R.id.toggle1);
        switch1.setOnCheckedChangeListener((compoundButton, b1) -> ((MainActivity)getActivity()).switchChanged(b1));
    }
}
