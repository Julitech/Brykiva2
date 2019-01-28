package com.julitech.brykiva.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;

import com.julitech.brykiva.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CodeOutputFragment extends Fragment {

    EditText htmlCode;


    public CodeOutputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_code_output, container, false);


        htmlCode = getActivity().findViewById(R.id.htmlCodeEdittext);
        String html = htmlCode.getText().toString();
//                "<!DOCTYPE html><html><head></head><body><p>This is it</p></body></html>";

        WebView webView = view.findViewById(R.id.webview);
        webView.loadDataWithBaseURL("",html,"text/html","UTF-8","");

        return view;
    }

}
