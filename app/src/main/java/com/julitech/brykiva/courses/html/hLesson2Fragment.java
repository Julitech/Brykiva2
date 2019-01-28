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
public class hLesson2Fragment extends Fragment {

    private String code1 =
            "<p> \n"+
                    "  Have you seen this <a href=\"http://www.youtube.com\">amazing video</a> on YouTube? \n"+
                    "</p>\n";

    public hLesson2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_h_lesson2, container, false);
        CodeView codeView = (CodeView) view.findViewById(R.id.code1);
        codeView.setCode(code1)
                .setLanguage(Language.HTML)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        return view;
    }

}
