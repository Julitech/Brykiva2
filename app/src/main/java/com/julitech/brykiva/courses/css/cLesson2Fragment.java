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
public class cLesson2Fragment extends Fragment {

    String code1 = "" +
            "<blockquote>Something New</blockquote>\n";
    String code2 = "" +
            "blockquote { \n" +
            "   background: lightgreen;\n" +
            "}";
    String code3 = "blockquote {\n" +
            "  background: lightgreen;\n" +
            "  color: darkgreen;\n" +
            "}\n";
    String code4 = "q,\n" +
            "blockquote {\n" +
            "  background: lightgreen;\n" +
            "  color: darkgreen;\n" +
            "}\n";
    String code5 = "/* This is a CSS comment */\n" +
            "q,\n" +
            "blockquote{\n" +
            "  background: lightgreen;\n" +
            "  color: darkgreen;\n" +
            "}\n" +
            "/*\n" +
            "comments are visible to human, unread by the browser \n" +
            "*/\n";
    public cLesson2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_c_lesson2, container, false);
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
        return view;
    }

}
