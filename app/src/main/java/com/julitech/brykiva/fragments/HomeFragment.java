package com.julitech.brykiva.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.julitech.brykiva.R;
import com.julitech.brykiva.courses.PreviewActivity;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class HomeFragment extends Fragment {


    ViewPager viewPager;
    TabLayout tabLayout;
    int[] image_array = {
        R.drawable.slider_1,
        R.drawable.slider_2,
        R.drawable.slider_3,
        R.drawable.slider_4
    };

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = view.findViewById(R.id.topSlider);
        tabLayout = view.findViewById(R.id.tab_selector);

        SliderAdapter adapter = new SliderAdapter();
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        CardView cardHtml = view.findViewById(R.id.cardHtml);
        CardView cardCss = view.findViewById(R.id.cardCss);
        CardView cardJs = view.findViewById(R.id.cardJs);




        cardHtml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), PreviewActivity.class);
                intent.putExtra("course","HTML");
                startActivity(intent);
            }
        });
        cardCss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), PreviewActivity.class);
                intent.putExtra("course","CSS");
                startActivity(intent);
            }
        });
        cardJs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), PreviewActivity.class);
                intent.putExtra("course","Javascript");
                startActivity(intent);
            }
        });


        return view;
    }

    public class SliderAdapter extends PagerAdapter {

        LayoutInflater inflater;

        SliderAdapter() {
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {


            inflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.item_slider,container,false);

            ImageView imageView = view.findViewById(R.id.sliderImage);
            imageView.setImageResource(image_array[position]);


            container.addView(view);
            return view;
        }
        @Override
        public int getCount() {
            return image_array.length;
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
