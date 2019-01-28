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
public class hLesson7Fragment extends Fragment {

    String code1 = "<p>\n" +
            "  This is <strong>important</strong> take note\n" +
            "</p>\n";
    String code2 = "<p>\n" +
            "  This is <em>emphasized</em> but this is not.\n" +
            "</p>";
    String code3 = "<p>\n" +
            "  I just bought a <abbr title=\"United State of America\">USA</abbr>.\n" +
            "</p>\n";

    public hLesson7Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_h_lesson7, container, false);
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

        return view;
    }

}
