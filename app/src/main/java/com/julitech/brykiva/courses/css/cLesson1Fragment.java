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
public class cLesson1Fragment extends Fragment {


    String code1 = "" +
            "p { color: red;}\n";
    String code2 = "" +
            "<p style=\"color: red;\">This text is important.</p>";
    String code3 = "<html>\n" +
            "  <head>\n" +
            "    <title>Hello World</title>\n" +
            "    <style type=\"text/css\">\n" +
            "      p{ color: red;}\n" +
            "    </style>\n" +
            "  </head>\n" +
            "  <body>\n" +
            "    <p>This paragraph will be red.</p>\n" +
            "  </body>\n" +
            "</html>\n";
    String code4 = "p{ color: red;}\n" +
            "<html>\n" +
            "  <head>\n" +
            "    <title>Hello World</title>\n" +
            "    <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
            "  </head>\n" +
            "  <body>\n" +
            "    <p>This paragraph will be red.</p>\n" +
            "  </body>\n" +
            "</html>\n";
    String code5 = "";

    public cLesson1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c_lesson1, container, false);
        CodeView codeView = view.findViewById(R.id.code1);
        codeView.setCode(code1)
                .setLanguage(Language.CSS)
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
        return view;
    }

}
