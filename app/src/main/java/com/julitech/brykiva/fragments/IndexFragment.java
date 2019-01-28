package com.julitech.brykiva.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.julitech.brykiva.R;
import com.julitech.brykiva.adapters.TopicsAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class IndexFragment extends Fragment {

    ListView topicsList;
    TopicsAdapter topicsAdapter;
    String[] topics = {
            "HTML Basics",
            "HTML Elements",
            "HTML Hierarchy",
            "HTML Semantics",
            "HTML Formatting",
            "HTML Text",
            "Inline Semantics",
            "HTML Links",
            "HTML Images",
            "HTML Tables",
            "HTML Structure"
    };

    public IndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_index, container, false);
        topicsAdapter = new TopicsAdapter(getActivity().getApplicationContext(),topics);
        topicsList = (ListView) view.findViewById(R.id.htmlList);
        topicsList.setAdapter(topicsAdapter);

        return view;
    }

}
