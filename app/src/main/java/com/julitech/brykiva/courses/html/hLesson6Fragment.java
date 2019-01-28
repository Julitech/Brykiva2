package com.julitech.brykiva.courses.html;


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
public class hLesson6Fragment extends Fragment {

    String code1 = "<p>\n" +
            " Brykiva, is a platform where we empower problems solvers and idea thinkers with the skills of programming.\n" +
            "</p>\n";
    String code2 = "<p>Football Players:</p>\n" +
            "<ul>\n" +
            "  <li>Drogba</li>\n" +
            "  <li>Hazard</li>\n" +
            "  <li>Ronaldo</li>\n" +
            "  <li>Messi</li>\n" +
            "</ul>\n";
    String code3 = "<ol>\n" +
            "  <li>Today</li>\n" +
            "  <li>Tomorrow</li>\n" +
            "  <li>Yesterday</li>\n" +
            "  <li>Next Tomorrow</li>\n" +
            "</ol>\n";
    String code4 = "<dl>\n" +
            "  <dt>Web</dt>\n" +
            "  <dd>The part of the Internet that contains websites and webpages</dd>\n" +
            "  <dt>HTML</dt>\n" +
            "  <dd>A markup language for creating webpages</dd>\n" +
            "  <dt>CSS</dt>\n" +
            "  <dd>A technology to make HTML look better</dd>\n" +
            "</dl>\n";
    String code5 = "<p>Sir Tim Berners-Lee said:</p>\n" +
            "<blockquote>\n" +
            "  “The original idea of the web was that it should be a collaborative space where you can communicate through sharing information.”\n" +
            "</blockquote>\n";
    String code6 = "<h1>this is my h1 heading </h1>\n" +
            "<h2>this is my h2 heading </h2>\n" +
            "<h3>this is my h3 heading </h3>\n" +
            "<h4>this is my h4 heading </h4>\n" +
            "<h5>this is my h5 heading </h5>\n" +
            "<h6>this is my h6 heading </h6>\n";

    public hLesson6Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_h_lesson6, container, false);
        CodeView codeView = view.findViewById(R.id.code1);
        codeView.setCode(code1)
                .setLanguage(Language.HTML)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView2 = view.findViewById(R.id.code2);
        codeView2.setCode(code2)
                .setLanguage(Language.HTML)
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
                .setLanguage(Language.HTML)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView6 = view.findViewById(R.id.code6);
        codeView6.setCode(code6)
                .setLanguage(Language.HTML)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        return view;
    }

}
