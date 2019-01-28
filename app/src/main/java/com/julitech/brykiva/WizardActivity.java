package com.julitech.brykiva;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class WizardActivity extends AppCompatActivity {

    SharedPreferences preferences;

    ViewPager viewPager;
    private String title_array[] = {"Learn","Create","Compete"};
    private int image_array[] = {
            R.drawable.image_wizard_2,
            R.drawable.image_wizard_4,
            R.drawable.image_wizard_3};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizard);

/*        //Check if user is signed in
        preferences = getSharedPreferences("com.julitech.brykiva",MODE_PRIVATE);
        boolean signedIn = preferences.getBoolean("SignIn",false);

        if (signedIn){
            Intent intent = new Intent(WizardActivity.this,MainActivity.class);
            startActivity(intent);
        }*/

        viewPager = (ViewPager) findViewById(R.id.viewPager);
//        viewPager.setPageMargin(getResources().getDimensionPixelOffset(R.dimen.viewpager_margin_overlap));
        viewPager.setOffscreenPageLimit(3);
        MyPagerAdapter pagerAdapter = new MyPagerAdapter();
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager);
//        startAutoSlider(pagerAdapter.getCount());
    }



    //Open signup activity
    public void openSignUpActivity(View view){
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }

    //Open login activity when login button is clicked
    public void openLoginActivity(View view){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);

    }



    //Pager adapter for view pager card wizard
    public class MyPagerAdapter extends PagerAdapter {

        LayoutInflater inflater;

        public MyPagerAdapter() {
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {


            inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.item_card_wizard,container,false);

            TextView textView = view.findViewById(R.id.wTitle);
            textView.setText(title_array[position]);

            ImageView imageView = view.findViewById(R.id.wImageView);
            imageView.setImageResource(image_array[position]);


            container.addView(view);
            return view;
        }
        @Override
        public int getCount() {
            return title_array.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}


