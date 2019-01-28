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
public class hLesson11Fragment extends Fragment {

    String code = "<header>\n" +
            "  <p>\n" +
            "    <a>\n" +
            "      <img src=\"my-logo.jpg\" alt=\"my company logo\">\n" +
            "    </a>\n" +
            "    <em>A cool website</em>\n" +
            "  </p>\n" +
            "\n" +
            "  <ul>\n" +
            "    <li>\n" +
            "      <a href=\"home.html\">Home</a>\n" +
            "      <a href=\"about.html\">About</a>\n" +
            "      <a href=\"contact.html\">Contact</a>\n" +
            "    </li>\n" +
            "  </ul>\n" +
            "</header>\n";

    String code2 = "<footer>\n" +
            "\n" +
            "  <p>MarkSheet.io | Copyright 2015</p>\n" +
            "\n" +
            "  <ul>\n" +
            "    <li> <a href=\"home.html\">Home</a>  </li>\n" +
            "    <li>\n" +
            "      <a href=\"about.html\">About</a>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "      <a href=\"contact.html\">Contact</a>\n" +
            "    </li>\n" +
            "  </ul>\n" +
            "\n" +
            "  <ul>\n" +
            "    <li>\n" +
            "      <a href=\"privacy-policy.html\">Privacy Policy</a>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "      <a href=\"terms-of-use.html\">Terms of use</a>\n" +
            "    </li>\n" +
            "  </ul>\n" +
            "</footer>\n";

    public hLesson11Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_h_lesson11, container, false);
        CodeView codeView = view.findViewById(R.id.code);
        codeView.setCode(code)
                .setLanguage(Language.HTML)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView2 = view.findViewById(R.id.code1);
        codeView2.setCode(code2)
                .setLanguage(Language.HTML)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        return view;
    }

}
