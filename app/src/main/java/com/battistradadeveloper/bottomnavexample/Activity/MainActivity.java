package com.battistradadeveloper.bottomnavexample.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.battistradadeveloper.bottomnavexample.Fragment.AccountFragment;
import com.battistradadeveloper.bottomnavexample.Fragment.ChatFragment;
import com.battistradadeveloper.bottomnavexample.Fragment.DataFragment;
import com.battistradadeveloper.bottomnavexample.Fragment.MoreFragment;
import com.battistradadeveloper.bottomnavexample.Fragment.TimelineFragment;
import com.battistradadeveloper.bottomnavexample.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bn_main);
        loadFragment(new DataFragment());

        bottomNav.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.account_menu:
                fragment = new AccountFragment();
                break;
            case R.id.chat_menu:
                fragment = new ChatFragment();
                break;
            case R.id.data_menu:
                fragment = new DataFragment();
                break;
            case R.id.more_menu:
                fragment = new MoreFragment();
                break;
            case R.id.timeline_menu:
                fragment = new TimelineFragment();
                break;
        }
        return loadFragment(fragment);
    }
    private boolean loadFragment(Fragment fragment) {
        if (fragment !=null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
