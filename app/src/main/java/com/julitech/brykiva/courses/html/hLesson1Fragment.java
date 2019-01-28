package com.julitech.brykiva.courses.html;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.julitech.brykiva.R;

import br.tiagohm.codeview.CodeView;
import br.tiagohm.codeview.Language;
import br.tiagohm.codeview.Theme;

/**
 * A simple {@link Fragment} subclass.
 */
public class hLesson1Fragment extends Fragment {

     String code1 = "\n"+
            "<p> Welcome to Kivalearn</p>\n";
     String code2 = "\n <a href=\"http://www.brykiva.com\">Brykiva Solutions</a>\n";
    String code3 = "\n<img src=\"#\" alt=\"Description of the image\">\n";

     String code4 =
            "<!-- This sentence will be ignored by the browser -->\n" +
            "<p>Welcome to kivalearn</p>\n";
     String code5 =
            "<br> <!-- line-break -->\n" +
                    "<img src=\"http://placehold.it/50x50\" alt=\"Description\"> <!-- image -->\n" +
                    "<input type=\"text\"> <!-- text input -->\n";

    public hLesson1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_h_lesson1, container, false);
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
        return view;
    }

}
