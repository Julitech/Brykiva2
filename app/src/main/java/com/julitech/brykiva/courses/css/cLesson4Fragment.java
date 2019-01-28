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
public class cLesson4Fragment extends Fragment {

    String code1 = "body {\n" +
            "   color: grey;\n" +
            "}\n";

    public cLesson4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c_lesson4, container, false);
        CodeView codeView = view.findViewById(R.id.code1);
        codeView.setCode(code1)
                .setLanguage(Language.CSS)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        return view;
    }

}
