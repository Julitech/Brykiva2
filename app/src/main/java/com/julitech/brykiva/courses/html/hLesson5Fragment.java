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
public class hLesson5Fragment extends Fragment {

    String code = "<blockquote>\n" +
            "The original idea of the web was that it should be a collaborative\n";
    String code2 = "<p>\n" +
            "  Let's push      this text with tabulations.\n" +
            "</p>\n";

    public hLesson5Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_h_lesson5, container, false);
        CodeView codeView = view.findViewById(R.id.code1);
        codeView.setCode(code)
                .setLanguage(Language.HTML)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView2 = view.findViewById(R.id.code2);
        codeView2.setCode(code2)
                .setLanguage(Language.HTML)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        return view;
    }

}
