package com.julitech.brykiva.courses.css;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.julitech.brykiva.R;

import br.tiagohm.codeview.CodeView;
import br.tiagohm.codeview.Language;
import br.tiagohm.codeview.Theme;

/**
 * A simple {@link Fragment} subclass.
 */
public class cLesson5Fragment extends Fragment {

    String code1 = "<p class=\"message\" id=\"introduction\">\n" +
            "  MarkSheet is a free HTML and CSS tutorial.\n" +
            "</p>\n";
    String code2 = "\np   { color: blue;}\n";
    String code3 = "\n.message  { color: green;}\n";
    String code4 = "\n  #introduction {color: red ;}\n";
    String code5 = "p   { color: green;}\n" +
            "p  { color: red;}\n" +
            "/* Paragraphs will be red */\n";
    String code6 = "#introduction{ color: red;}\n" +
            ".message{ color: green;}\n" +
            "p{ color: blue;}\n";

    public cLesson5Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_c_lesson5, container, false);
        CodeView codeView = view.findViewById(R.id.code1);
        codeView.setCode(code1)
                .setLanguage(Language.HTML)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView2 = view.findViewById(R.id.code2);
        codeView2.setCode(code2)
                .setLanguage(Language.CSS)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView3 = view.findViewById(R.id.code3);
        codeView3.setCode(code3)
                .setLanguage(Language.CSS)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView4 = view.findViewById(R.id.code4);
        codeView4.setCode(code4)
                .setLanguage(Language.CSS)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView5 = view.findViewById(R.id.code5);
        codeView5.setCode(code5)
                .setLanguage(Language.CSS)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView6 = view.findViewById(R.id.code6);
        codeView6.setCode(code6)
                .setLanguage(Language.CSS)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        return view;
    }

}
