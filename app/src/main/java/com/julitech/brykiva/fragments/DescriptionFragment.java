package com.julitech.brykiva.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.julitech.brykiva.R;
import com.julitech.brykiva.courses.PreviewActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescriptionFragment extends Fragment {


    public DescriptionFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_description, container, false);

        return view;
    }

}
