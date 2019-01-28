package com.julitech.brykiva.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.julitech.brykiva.R;
import com.julitech.brykiva.adapters.TopicsAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CssIndexFragment extends Fragment {

    ListView topicsList;
    TopicsAdapter topicsAdapter;
    String[] topics = {
            "CSS Basics",
            "CSS Syntax",
            "CSS Selectors",
            "CSS Inheritance",
            "CSS Priority",
            "CSS Color Units",
            "CSS Size Units",
            "CSS Reset"
    };

    public CssIndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_css_index, container, false);
        topicsAdapter = new TopicsAdapter(getActivity().getApplicationContext(),topics);
        topicsList = (ListView) view.findViewById(R.id.cssList);
        topicsList.setAdapter(topicsAdapter);
        return view;
    }

}
