package com.example.fragmenttest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private boolean settingsVisible = false;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view1, ContentFragment.class, null)
                    .commit();
        }
        
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.action_settings){
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment settings = fragmentManager.findFragmentById(R.id.settings);
            if (!settingsVisible) {
                if (settings == null) {
                    fragmentManager.beginTransaction()
                            .setReorderingAllowed(true).setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
                            .add(R.id.settings, settingsFragment.class, null).commit();
                } else {
                    fragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
                            .show(settings).commit();
                }
                settingsVisible = true;
            } else {
                if (settings != null) {
                    fragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
                            .hide(settings).commit();
                    settingsVisible = false;
                }

            }
            return true;
        }
        return false;
    }
    public void addFragmentPanel(){
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view2, ExtraContent.class, null)
                .commit();
    }
    public void removeFragmentPanel(){
        Fragment extra = getSupportFragmentManager().findFragmentById(R.id.fragment_container_view2);
        if (extra != null) {
            getSupportFragmentManager().beginTransaction().remove(extra).commit();
        }
    }
    public void switchChanged(boolean b){
        if (b){
            addFragmentPanel();
        } else {
            removeFragmentPanel();
        }
    }
    public void onBackPressed(){

    }
}

