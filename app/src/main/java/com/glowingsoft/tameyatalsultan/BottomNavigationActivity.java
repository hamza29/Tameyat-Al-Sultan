package com.glowingsoft.tameyatalsultan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.glowingsoft.tameyatalsultan.Fragment.AccountFragment;
import com.glowingsoft.tameyatalsultan.Fragment.HomeFragment;
import com.glowingsoft.tameyatalsultan.Fragment.MenuFragment;
import com.glowingsoft.tameyatalsultan.Fragment.MoreFragment;
import com.glowingsoft.tameyatalsultan.Fragment.OfferFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class BottomNavigationActivity extends AppCompatActivity {
    private static final String TAG_HOME = "home";
    public static String CURRENT_TAG = TAG_HOME;
    private Handler mHandler;
    ImageView Logout;
    private TextView mTextMessage;
    SharedPreferences mSharedPreferences;
    public static final String PREFERENCE = "preference";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_home:
                    loadHomeFragment(1);
                    return true;

                case R.id.navigation_dashboard:
                    loadHomeFragment(2);
                    return true;

                case R.id.navigation_offer:
                    loadHomeFragment(3);
                    return true;

                case R.id.navigation_account:
                    loadHomeFragment(4);
                    return true;

                case R.id.navigation_more:
                    loadHomeFragment(5);
                    return true;

            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        mSharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mHandler = new Handler();
        Dexter.withActivity(this)
                .withPermissions(
                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION
                ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
            }
        }).check();

        loadHomeFragment(0);
    }

    private void loadHomeFragment(final int i) {
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment(i);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.disallowAddToBackStack();
                fragmentTransaction.commitAllowingStateLoss();
            }
        };
        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }
    }


    @Override
    public void onBackPressed() {
    }

    @SuppressLint("SetTextI18n")
    private Fragment getHomeFragment(int i) {
        switch (i) {
            case 1:
//                mTextMessage.setText("Home");
//                mTextMessage.setVisibility(View.VISIBLE);
                return new HomeFragment();
            case 2:
//                mTextMessage.setText("Create Shipment");
//                mTextMessage.setVisibility(View.VISIBLE);
                return new MenuFragment();
            case 3:
//                mTextMessage.setText("Tracking");
//                mTextMessage.setVisibility(View.VISIBLE);
                return new OfferFragment();
            case 4:
//                mTextMessage.setText("History");
//                mTextMessage.setVisibility(View.VISIBLE);
                return new AccountFragment();
            case 5:
//                mTextMessage.setText("Account");
//                mTextMessage.setVisibility(View.VISIBLE);
                return new MoreFragment();
            default:
                return new HomeFragment();
        }
    }

}
