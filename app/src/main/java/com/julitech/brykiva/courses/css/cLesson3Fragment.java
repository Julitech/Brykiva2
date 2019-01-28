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
public class cLesson3Fragment extends Fragment {

    String code1 = "a{ /* Links */ }\n" +
            "p{ /* Paragraphs */ }\n" +
            "ul{ /* Unordered lists */ }\n" +
            "li{ /* List items */ }\n";
    String code2 = ".date {\n" +
            "  color: red;\n" +
            "}\n";
    String code3 = "<p class=\"date\">\n" +
            "  Saturday Feb 21\n" +
            "</p>\n" +
            "<p>\n" +
            "  The event will be on <em class=\"date\">Saturday</em>.\n" +
            "</p>\n";
    String code4 = "" +
            "\n<h1 id=\"tagline\">This heading will be orange.</h1>\n";
    String code5 = "" +
            "#tagline {\n" +
            " color: orange;\n" +
            "}\n";
    String code6 = "em.date {\n" +
            "  color: blue;\n" +
            "}\n";
    String code7 = "header a {\n" +
            "  color: red;\n" +
            "}\n";
    String code8 = "a {\n" +
            "  color: blue;\n" +
            "}\n" +
            "\n" +
            "a:hover {\n" +
            "  color: red;\n" +
            "}\n";

    public cLesson3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_c_lesson3, container, false);
        CodeView codeView = view.findViewById(R.id.code1);
        codeView.setCode(code1)
                .setLanguage(Language.CSS)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView2 = view.findViewById(R.id.code2);
        codeView2.setCode(code2)
                .setLanguage(Language.CSS)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView3 = view.findViewById(R.id.code3);
        codeView3.setCode(code3)
                .setLanguage(Language.HTML)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView4 = view.findViewById(R.id.code4);
        codeView4.setCode(code4)
                .setLanguage(Language.HTML)
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
        CodeView codeView7 = view.findViewById(R.id.code7);
        codeView7.setCode(code7)
                .setLanguage(Language.CSS)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView8 = view.findViewById(R.id.code8);
        codeView8.setCode(code8)
                .setLanguage(Language.CSS)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        return view;
    }

}
