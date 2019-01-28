package com.julitech.brykiva.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.julitech.brykiva.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CssDescriptionFragment extends Fragment {


    public CssDescriptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description_css,container,false);
        return view;
    }

}
