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
public class hLesson3Fragment extends Fragment {

     String code1 =
            "<p>\n" +
                    "  <strong>Kivalearn</strong> is a platform known for: <q>\"learning and creating.\"</q>.\n" +
                    "</p>\n";

    String code2 = "<p>\n" +
            "  This HTML code won't work because the \"strong\" tag is opened here <strong> and was closed after the paragraph tag.\n" +
            "</p></strong>\n" +
            "\n" +
            "\n"+
            "<p>  This HTML code will work because the \"strong\" tag is opened <strong>and closed</strong> properly.\n" +
            "</p>\n";

    public hLesson3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_h_lesson3, container, false);
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
        return view;
    }

}
