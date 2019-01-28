package com.julitech.brykiva;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.julitech.brykiva.adapters.FragmentAdapter;
import com.julitech.brykiva.helpers.BottomNavigationHelper;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;
    ViewPager viewPager;
    FragmentAdapter fragmentAdapter;
    SharedPreferences preferences;


    FirebaseAuth mAuth;
    FirebaseUser user;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.mEditProfile :
                Intent intent = new Intent(this,EditProfileActivity.class);
                startActivity(intent);
                return true;
            case R.id.mSignOut:
                //Sign out
                new AlertDialog.Builder(this)
                        .setTitle("Sign Out")
                        .setMessage("Are you sure you want to sign out?")
                        .setNegativeButton("No",null)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                preferences.edit()
                                        .putBoolean("SignIn",false)
                                        .apply();
                                mAuth.signOut();
                                finish();
                                Intent intent = new Intent(MainActivity.this,WizardActivity.class);
                                startActivity(intent);
                            }
                        })
                        .show();

                return true;
            default:
                return false;


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Check if user is signed in
        preferences = getSharedPreferences("com.julitech.brykiva", MODE_PRIVATE);
        boolean signedIn = preferences.getBoolean("SignIn", false);

        if (!signedIn) {
            Intent intent = new Intent(this, WizardActivity.class);
            startActivity(intent);
        }


        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();


        viewPager = (ViewPager) findViewById(R.id.mainViewPager);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());

        viewPager.setAdapter(fragmentAdapter);
        viewPager.addOnPageChangeListener(viewPagerListener);

        navigationView = (BottomNavigationView) findViewById(R.id.bottom_menu);
        BottomNavigationHelper.removeShiftMode(navigationView);
        navigationView.setOnNavigationItemSelectedListener(mListener);
    }


    //Bottom navigation item listener
    BottomNavigationView.OnNavigationItemSelectedListener mListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.mHome:
                    viewPager.setCurrentItem(0);
                    getSupportActionBar().setTitle("KivaLearn");
                    return true;
                case R.id.mLearn:
                    viewPager.setCurrentItem(1);
                    getSupportActionBar().setTitle("Learn");
                    return true;
                case R.id.mCode:
                    viewPager.setCurrentItem(2);
                    getSupportActionBar().setTitle("Code");
                    return true;
                case R.id.mQuestions:
                    viewPager.setCurrentItem(3);
                    getSupportActionBar().setTitle("Q&A");
                    return true;
                case R.id.mCompete:
                    Intent intent = new Intent(MainActivity.this, CompetitionActivity.class);
                    startActivity(intent);
                    return false;
                default:
                    return false;

            }
        }
    };

    ViewPager.OnPageChangeListener viewPagerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    navigationView.setSelectedItemId(R.id.mHome);
                    getSupportActionBar().setTitle("KivaLearn");
                    break;
                case 1:
                    navigationView.setSelectedItemId(R.id.mLearn);
                    getSupportActionBar().setTitle("Learn");
                    break;
                case 2:
                    navigationView.setSelectedItemId(R.id.mCode);
                    getSupportActionBar().setTitle("Code");
                    break;
                case 3:
                    navigationView.setSelectedItemId(R.id.mQuestions);
                    getSupportActionBar().setTitle("Q&A");
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    @Override
    public void onBackPressed() {
        finishAffinity();
        finish();
        super.onBackPressed();
    }
}
