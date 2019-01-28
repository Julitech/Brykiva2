package com.julitech.brykiva.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.julitech.brykiva.R;
import com.julitech.brykiva.adapters.SectionPagerAdapter;

public class CodeFragment extends Fragment {


    SectionPagerAdapter adapter;
    ViewPager pager;


    public CodeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_code, container, false);
        pager = (ViewPager) view.findViewById(R.id.sectionPager);
        adapter = new SectionPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new CodeHtmlFragment(),"Html");
        adapter.addFragment(new CodeCssFragment(),"Css");
        adapter.addFragment(new CodeJsFragment(),"JS");
        adapter.addFragment(new CodeOutputFragment(),"Output");
        pager.setAdapter(adapter);
        TabLayout layout = (TabLayout) view.findViewById(R.id.tab_layout);
        layout.setupWithViewPager(pager);

        final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.oFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(3);
            }
        });


        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 3){
                    fab.setVisibility(View.GONE);
                }else {
                    fab.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        return view;
    }
}
