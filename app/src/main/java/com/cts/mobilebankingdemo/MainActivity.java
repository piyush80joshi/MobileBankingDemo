package com.cts.mobilebankingdemo;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ncapdevi.fragnav.FragNavController;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;
import com.roughike.bottombar.OnMenuTabClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CoordinatorLayout coordinatorLayout;
    private Fragment balTransferFragment;
    private Fragment accountsFragment;
    private Fragment settingsFragment;

    private FragNavController fragNavController;
    BottomBar bottomBar;

    //indices to fragments
    private final int TAB_FIRST = FragNavController.TAB1;
    private final int TAB_SECOND = FragNavController.TAB2;
    private final int TAB_THIRD = FragNavController.TAB3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        balTransferFragment = new TestFragment();//new BalanceTransferFragment();
        accountsFragment = new AccountFragment();
        settingsFragment = new SettingsFragment();
        List<Fragment> fragments = new ArrayList<>(3);
       //add fragments to list
        fragments.add(balTransferFragment);
        fragments.add(accountsFragment);
        fragments.add(settingsFragment);

        //link fragments to container
        fragNavController = new FragNavController(getSupportFragmentManager(),R.id.container,fragments);
        bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setItems(R.menu.bottom_navigation_main);
        bottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int  itemId) {
                switch (itemId) {
                    case R.id.view_balance:
                        //Snackbar.make(coordinatorLayout, "View Balance Item Selected", Snackbar.LENGTH_LONG).show();
                        fragNavController.switchTab(TAB_FIRST);
                        break;
                    case R.id.bal_transfer:
                        //Snackbar.make(coordinatorLayout, "Bal Transfer Selected", Snackbar.LENGTH_LONG).show();
                        fragNavController.switchTab(TAB_SECOND);
                        break;
                    case R.id.settings:
                        fragNavController.switchTab(TAB_THIRD);
                        //Snackbar.make(coordinatorLayout, "Settings Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                }

            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.view_balance) {
                    fragNavController.clearStack();
                }
            }

        });

    }

    @Override
    public void onBackPressed() {
        if (fragNavController.getCurrentStack().size() > 1) {
            fragNavController.pop();
        } else {
            super.onBackPressed();
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        bottomBar.onSaveInstanceState(outState);
    }
}
